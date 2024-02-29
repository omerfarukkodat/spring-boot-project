package com.kodat.of.jobms.repository;


import com.kodat.of.jobms.job.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
