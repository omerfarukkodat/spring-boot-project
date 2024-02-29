package com.kodat.of.springbootrabbitmqtutorial.controller;

import com.kodat.of.springbootrabbitmqtutorial.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1")
public class RabbitMQController {

    private final RabbitMQProducer rabbitMQProducer;

    public RabbitMQController(RabbitMQProducer rabbitMQProducer) {
        this.rabbitMQProducer = rabbitMQProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){

        rabbitMQProducer.sendMessage(message);
        return ResponseEntity.ok("message sent to RabbitMQ...");
    }


}
