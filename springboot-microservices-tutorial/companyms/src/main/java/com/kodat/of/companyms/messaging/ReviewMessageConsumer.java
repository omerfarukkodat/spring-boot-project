package com.kodat.of.companyms.messaging;

import com.kodat.of.companyms.dto.ReviewMessage;
import com.kodat.of.companyms.service.CompanyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewMessageConsumer {
    private final CompanyService companyService;


    public ReviewMessageConsumer(CompanyService companyService) {
        this.companyService = companyService;
    }
@RabbitListener(queues = "companyRatingQueue")
    public void consumeMessage(ReviewMessage reviewMessage){
        companyService.updateCompanyRating(reviewMessage);
    }

}
