package com.kodat.of.reviewms.review.controller;


import com.kodat.of.reviewms.review.messaging.ReviewMessageProducer;
import com.kodat.of.reviewms.review.model.Review;
import com.kodat.of.reviewms.review.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMessageProducer reviewMessageProducer;


    public ReviewController(ReviewService reviewService, ReviewMessageProducer reviewMessageProducer) {
        this.reviewService = reviewService;
        this.reviewMessageProducer = reviewMessageProducer;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {

        boolean isReviewed = reviewService.addReview(review, companyId);
        if (isReviewed) {
            reviewMessageProducer.sendMessage(review);
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("review not saved", HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewId(@PathVariable Long reviewId) {


        return new ResponseEntity<>(reviewService.getReviewById( reviewId), HttpStatus.OK);

    }


    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId,
                                               @RequestBody Review review){

        boolean isReviewed = reviewService.updateReview(reviewId,review);
        if (isReviewed) {
            return new ResponseEntity<>("review updated.", HttpStatus.OK);
        }
        return new ResponseEntity<>("not found" , HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview( @PathVariable Long reviewId){
    boolean isDeleted = reviewService.deleteReview(reviewId);
if (isDeleted) {
    return new ResponseEntity<>("Deleted review", HttpStatus.OK);
}
else return new ResponseEntity<>("not found review" , HttpStatus.NOT_FOUND);
    }


    @GetMapping("averageRating")
    public Double getAverageReview(@RequestParam Long companyId){
    List<Review> reviewList = reviewService.getAllReviews(companyId);
    return reviewList.stream().mapToDouble(Review::getRating).average().orElse(0.0);
    }


}
