package com.hotel_management.model.service;

import com.hotel_management.model.JobPosting;
import com.hotel_management.model.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceIMPL implements  JobService{
    @Autowired
    private JobRepository jobRepository;


    @Override
    public List<JobPosting> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public void saveJobPost(JobPosting jobPosting) {
        this.jobRepository.save(jobPosting);

    }

    @Override
    public JobPosting getJobById(long jobid) {
        Optional<JobPosting> optional = jobRepository.findById(jobid);
        JobPosting jobPosting = null;
        if(optional.isPresent())
        {
            jobPosting = optional.get();
        }
        else{
            throw new RuntimeException("Job post not found for id: "+jobid);
        }
        return jobPosting;
    }

    @Override
    public void deleteJobPost(long jobid) {
        this.jobRepository.deleteById(jobid);
    }
}
