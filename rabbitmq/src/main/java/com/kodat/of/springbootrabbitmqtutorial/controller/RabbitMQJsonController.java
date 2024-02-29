package com.kodat.of.springbootrabbitmqtutorial.controller;

import com.kodat.of.springbootrabbitmqtutorial.dto.User;
import com.kodat.of.springbootrabbitmqtutorial.producer.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class RabbitMQJsonController {

    private final RabbitMQJsonProducer rabbitMQJsonProducer;


    public RabbitMQJsonController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }


    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQJsonProducer.sendMessage(user);
        return ResponseEntity.ok("json message sent to RabbitMQ... ");


    }


}
