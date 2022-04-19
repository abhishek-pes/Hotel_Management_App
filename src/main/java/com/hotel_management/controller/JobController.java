package com.hotel_management.controller;

import com.hotel_management.model.JobPosting;
import com.hotel_management.model.Room;
import com.hotel_management.model.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobController {
    @Autowired
    private JobService jobService;

    //Display list of all job posts
    @GetMapping("/admin/authenticate/all_jobs")
    public String viewalljobs(Model model){
        model.addAttribute("listjobs",jobService.getAllJobs());
        return "all_jobs";
    }

    @GetMapping("/admin/authenticate/createNewJobPost")
    public  String creatnewjob(Model model){
        JobPosting jobPosting = new JobPosting();
        model.addAttribute("job",jobPosting);
        return "new_job";
    }

    // to save a job post
    @PostMapping("/saveJob")
    public String savejob(@ModelAttribute("job") JobPosting jobPosting){
        jobService.saveJobPost(jobPosting);
        return "redirect:/admin/authenticate/all_jobs";
    }

    // controller to handle update of job posting
    @GetMapping("/admin/authenticate/showFormForUpdate/{jobid}")
    public  String updateJob(@PathVariable(value = "jobid") long jobid, Model model){
        JobPosting jobPosting = jobService.getJobById(jobid);

        model.addAttribute("job",jobPosting);
        return "update_job";
    }

    // controller to delete job post
    @GetMapping("/admin/authenticate/deleteJobPost/{jobid}")
    public String deleteBlog(@PathVariable (value = "jobid") long jobid) {

        this.jobService.deleteJobPost(jobid);
        return "redirect:/admin/authenticate/all_jobs";
    }

}
