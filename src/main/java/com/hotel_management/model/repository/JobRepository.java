package com.hotel_management.model.repository;

import com.hotel_management.model.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobPosting,Long> {
}
