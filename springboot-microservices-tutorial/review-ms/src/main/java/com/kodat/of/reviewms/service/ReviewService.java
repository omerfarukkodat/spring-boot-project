package com.kodat.of.reviewms.service;


import com.kodat.of.reviewms.review.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);

    boolean addReview(Review review , Long companyId);

    Review getReviewById(Long reviewId);

    boolean updateReview(Long reviewId , Review review);

    boolean deleteReview(Long deleteReviewId);
}
