package com.selva.sample.controller;

import com.selva.sample.domain.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class MessageController {

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public Message getMessage(){
        return new Message("id1", "value");
    }
}
