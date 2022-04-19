package com.hotel_management.model.service;

import com.hotel_management.model.JobPosting;

import java.util.List;

public interface JobService {
    List<JobPosting> getAllJobs();
    void saveJobPost(JobPosting jobPosting);
    JobPosting getJobById(long jobid);
    void deleteJobPost(long jobid);
}
