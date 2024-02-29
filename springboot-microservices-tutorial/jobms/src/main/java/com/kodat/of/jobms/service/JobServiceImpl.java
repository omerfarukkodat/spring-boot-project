package com.kodat.of.jobms.service;


import com.kodat.of.jobms.job.clients.CompanyClient;
import com.kodat.of.jobms.job.clients.ReviewClient;
import com.kodat.of.jobms.job.dto.JobDTO;
import com.kodat.of.jobms.job.external.Company;
import com.kodat.of.jobms.job.external.Review;
import com.kodat.of.jobms.job.mapper.JobMapper;
import com.kodat.of.jobms.job.model.Job;
import com.kodat.of.jobms.job.repository.JobRepository;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    int attempt=0;


    private final CompanyClient companyClient;
    private final JobRepository jobRepository;
    private final ReviewClient reviewClient;
    @Autowired
    private  RestTemplate restTemplate;

    public JobServiceImpl(CompanyClient companyClient, JobRepository jobRepository, ReviewClient reviewClient) {
        this.companyClient = companyClient;
        this.jobRepository = jobRepository;
        this.reviewClient = reviewClient;
    }


    @Override
    @Retry(name = "companyBreaker" , fallbackMethod = "companyBreakerFallback")
   // @RateLimiter(name = "companyBreaker" , fallbackMethod = "companyBreakerFallback")
//    @CircuitBreaker(name = "companyBreaker" , fallbackMethod = "companyBreakerFallback")
    public List<JobDTO> findAll() {
        System.out.println("attempt: " + attempt++);
        List<Job> jobList = jobRepository.findAll();
        return jobList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());


    }
    public List<String> companyBreakerFallback(Exception e){
        List<String> list = new ArrayList<>();
        list.add("Dummy");
        return list;


    }




    private JobDTO convertToDto(Job job) {
        Company company = companyClient.getCompany(job.getCompanyId());
 List<Review> reviews = reviewClient.getAllReviews(job.getCompanyId());
        return JobMapper
                .mapToJobWithCompanyDto(job,company,reviews);

    }





@Override
public void addJob(Job job) {
    jobRepository.save(job);
}

@Override
public boolean updateJob(Long id, Job updatedJob) {

    Optional<Job> jobOptional = jobRepository.findById(id);
    if (jobOptional.isPresent()) {

        Job job = jobOptional.get();
        job.setTitle(updatedJob.getTitle());
        job.setDescription(updatedJob.getDescription());
        job.setMinSalary(updatedJob.getMinSalary());
        job.setMaxSalary(updatedJob.getMaxSalary());
        job.setLocation(updatedJob.getLocation());
        jobRepository.save(job);
        return true;
    }
    return false;

}

@Override
public boolean deleteJob(Long id) {
    try {
        jobRepository.deleteById(id);
        return true;
    } catch (Exception e) {
        return false;

    }
}

@Override
public JobDTO getJobById(Long id) {
     Job job = jobRepository.findById(id).orElse(null);
     return convertToDto(job);
}
}
