package com.devop.JobApp.reviews;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long CompanyId,Review review);
    Review getReview(Long CompanyId, Long ReviewId);
    boolean updateReview(Long CompanyId, Long ReviewId, Review review);
    boolean deleteReview(Long CompanyId, Long ReviewId);
}
