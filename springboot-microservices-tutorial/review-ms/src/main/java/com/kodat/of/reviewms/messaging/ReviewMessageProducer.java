package com.kodat.of.reviewms.messaging;

import com.kodat.of.reviewms.review.dto.ReviewMessage;
import com.kodat.of.reviewms.review.model.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageProducer {
    private final RabbitTemplate rabbitTemplate;


    public ReviewMessageProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(Review review){
        ReviewMessage reviewMessage = new ReviewMessage();
        reviewMessage.setId(review.getId());
        reviewMessage.setDescription(review.getDescription());
        reviewMessage.setCompanyId(review.getCompanyId());
        reviewMessage.setTitle(review.getTitle());
        reviewMessage.setRating(review.getRating());
        rabbitTemplate.convertAndSend("companyRatingQueue", reviewMessage);

    }


}
