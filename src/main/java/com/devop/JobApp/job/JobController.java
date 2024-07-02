package com.devop.JobApp.job;

import com.devop.JobApp.company.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs") // it sets base url for all the methods and can be used in class level and method level
public class JobController {
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

//    @GetMapping("/jobs")
@GetMapping
    public ResponseEntity<List<Job>> findAll(){
//        return new ResponseEntity.ok(jobService.findAll());
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }
//    @PostMapping("/jobs")
    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job created", HttpStatus.OK);
    }

//    @GetMapping("/jobs/{id}")
@GetMapping("/{id}")
    public ResponseEntity<Job> getByJobId(@PathVariable Long id){
        Job job=jobService.getJobById(id);
        if(job!=null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @DeleteMapping("jobs/{id}")
@DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        boolean delete=jobService.deleteJobById(id);
        if(delete){
            return new ResponseEntity<>("Job deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
//    @PutMapping("jobs/{id}")
@PutMapping("/{id}")
//    @RequestMapping(value="/jobs/{id}", method=RequestMethod.PUT)
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job updatedJob){
        boolean update=jobService.updateJobById(id,updatedJob);
        if(update){
            return new ResponseEntity<>("Job updated", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
