package com.devop.JobApp.company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    //It is used to implement ORM which converts objects into relational table records
}
