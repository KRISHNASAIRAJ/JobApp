package com.devop.JobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//It is used to make restful web services(REST APi's)
@RequestMapping("/jobs") // it sets base url for all the methods and can be used in class level and method level
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    @GetMapping("/jobs")
@GetMapping//It Fetches Records
    public ResponseEntity<List<Job>> findAll(){//It is used to fetch all jobs
//        return new ResponseEntity.ok(jobService.findAll());
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);// it returns the entity Job with a status successful
    }
//    @PostMapping("/jobs")
    @PostMapping//It creates Record
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);//We Will Create A Job
        return new ResponseEntity<>("Job created", HttpStatus.OK);
    }

//    @GetMapping("/jobs/{id}")
@GetMapping("/{id}")//It is used to fetch a particular Job
    public ResponseEntity<Job> getByJobId(@PathVariable Long id){
        Job job=jobService.getJobById(id);//We will fetch the job by I'd
        if(job!=null)//if job is found
            return new ResponseEntity<>(job, HttpStatus.OK);//We will return job with a successful status
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @DeleteMapping("jobs/{id}")
@DeleteMapping("/{id}")//It is used to delete a particular Job
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean delete=jobService.deleteJobById(id);
        if(delete){
            return new ResponseEntity<>("Job deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @PutMapping("jobs/{id}")
@PutMapping("/{id}")//It is used to update a particular Job
//    @RequestMapping(value="/jobs/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean update=jobService.updateJobById(id,updatedJob);
        if(update){
            return new ResponseEntity<>("Job updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
