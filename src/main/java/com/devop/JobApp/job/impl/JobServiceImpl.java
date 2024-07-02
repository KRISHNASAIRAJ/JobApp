package com.devop.JobApp.job.impl;

import com.devop.JobApp.job.Job;
import com.devop.JobApp.job.JobRepository;
import com.devop.JobApp.job.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
//    private List<Job> jobs=new ArrayList<>();
    JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        jobRepository.save(job);
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateJobById(Long id, Job updatedJob) {
        Optional<Job> job = jobRepository.findById(id);
        if(job.isPresent()) {
            Job oldJob = job.get();
            oldJob.setDescription(updatedJob.getDescription());
            oldJob.setLocation(updatedJob.getLocation());
            oldJob.setTitle(updatedJob.getTitle());
            oldJob.setMaxSalary(updatedJob.getMaxSalary());
            oldJob.setMinSalary(updatedJob.getMinSalary());
            jobRepository.save(oldJob);
            return true;
        }
        return false;
    }


}
