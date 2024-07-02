package com.devop.JobApp.reviews.impl;
import java.util.List;

import com.devop.JobApp.company.Company;
import com.devop.JobApp.company.CompanyRepository;
import com.devop.JobApp.company.CompanyService;
import com.devop.JobApp.reviews.Review;
import com.devop.JobApp.reviews.ReviewRepository;
import com.devop.JobApp.reviews.ReviewService;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long CompanyId, Review review) {
        Company company=companyService.getCompanyById(CompanyId);
        if(company!=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReview(Long CompanyId, Long ReviewId) {
        List<Review> reviews=reviewRepository.findByCompanyId(CompanyId);
        return reviews.stream().filter(r->r.getId().equals(ReviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean updateReview(Long CompanyId, Long ReviewId, Review updatedReview) {
        if(companyService.getCompanyById(CompanyId)!=null){
            updatedReview.setCompany(companyService.getCompanyById(CompanyId));
            updatedReview.setId(ReviewId);
            reviewRepository.save(updatedReview);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteReview(Long CompanyId, Long ReviewId) {
        if(companyService.getCompanyById(CompanyId)!=null && reviewRepository.existsById(ReviewId)){
            Review review=reviewRepository.findById(ReviewId).orElse(null);
            Company company=review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);// lastly added
            companyService.updateCompany(CompanyId,company);
            reviewRepository.deleteById(ReviewId);
            return true;
        }
        return false;
    }

}
