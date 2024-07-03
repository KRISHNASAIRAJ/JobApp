package com.devop.JobApp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
    //This is ORM which converts the objects into relational table records
}
