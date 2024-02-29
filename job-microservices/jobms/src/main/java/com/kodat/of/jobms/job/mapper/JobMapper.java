package com.kodat.of.jobms.job.mapper;

import com.kodat.of.jobms.job.external.Company;
import com.kodat.of.jobms.job.external.Review;
import com.kodat.of.jobms.job.dto.JobDTO;
import com.kodat.of.jobms.job.model.Job;

import java.util.List;

public class JobMapper {

    public static JobDTO mapToJobWithCompanyDto(Job job , Company company, List<Review> review){

        JobDTO jobDTO = new JobDTO();

        jobDTO.setId(job.getId());
        jobDTO.setDescription(job.getDescription());
        jobDTO.setTitle(job.getTitle());
        jobDTO.setMaxSalary(job.getMaxSalary());
        jobDTO.setMinSalary(job.getMinSalary());
        jobDTO.setLocation(job.getLocation());
        jobDTO.setCompany(company);
        jobDTO.setReview(review);

        return jobDTO;
    }

}
