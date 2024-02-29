package com.kodat.of.jobms.job.service;


import com.kodat.of.jobms.job.dto.JobDTO;
import com.kodat.of.jobms.job.model.Job;

import java.util.List;

public interface JobService {


    List<JobDTO> findAll();

    void addJob(Job job);

    boolean updateJob(Long id , Job updatedJob);

    boolean deleteJob(Long id);

    JobDTO getJobById(Long id);
}
