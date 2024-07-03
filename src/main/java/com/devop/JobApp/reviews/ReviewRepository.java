package com.devop.JobApp.reviews;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId);// it will create implementation in run time
    //It also is responsible for ORM
}
