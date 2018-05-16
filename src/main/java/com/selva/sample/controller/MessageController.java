package com.selva.sample.controller;

import com.selva.sample.domain.Message;
import com.selva.sample.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/app")
public class MessageController {

    @Autowired
    private MessageProducer messageProducer;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public Message getMessage(){
        return new Message("id1", "value");
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public void postMessage(Message message) throws ExecutionException, InterruptedException {
        messageProducer.pusblishMessage(message.toString());
    }

}
