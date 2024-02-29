package com.kodat.of.reviewms.review.service;


import com.kodat.of.reviewms.review.model.Review;
import com.kodat.of.reviewms.review.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Review review, Long companyId) {
        if (companyId != null && review != null) {
            review.setCompanyId(companyId);
            reviewRepository.save(review);
            return true;
        } else
            return false;
    }

    @Override
    public Review getReviewById( Long reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);

    }

    @Override
    public boolean updateReview( Long reviewId, Review review) {
        Review review1 = reviewRepository.findById(reviewId).get();
        if (review1 != null) {
           review1.setTitle(review.getTitle());
           review1.setDescription(review.getDescription());
           review1.setRating(review.getRating());
           review1.setCompanyId(review.getCompanyId());
            reviewRepository.save(review1);
            return true;

        }
        return false;


    }

    @Override
    public boolean deleteReview(Long deleteReviewId) {
        Review review = reviewRepository.findById(deleteReviewId).orElse(null);
        if (review != null){
            reviewRepository.delete(review);
            return true;
        }
        else {
            return false;
        }


    }
}
