package com.hotel_management.model;

import javax.persistence.*;

@Entity
@Table(name = "jobs")
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobid;

    @Column(name = "job_title")
    private String Jobtitle;

    @Column(name = "job_description")
    private String Jobdesc;

    @Column(name = "ctc")
    private Float ctc;

    public Long getJobid() {
        return jobid;
    }

    public void setJobid(Long jobid) {
        this.jobid = jobid;
    }

    public String getJobtitle() {
        return Jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        Jobtitle = jobtitle;
    }

    public String getJobdesc() {
        return Jobdesc;
    }

    public void setJobdesc(String jobdesc) {
        Jobdesc = jobdesc;
    }

    public Float getCtc() {
        return ctc;
    }

    public void setCtc(Float ctc) {
        this.ctc = ctc;
    }
}
