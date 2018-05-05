package com.student.service.web.controller;

import com.student.service.web.model.Message;
import com.student.service.web.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MessageController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    MessageRepository messageRepository;

    // Get All Messages
    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // Create a new Message
    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message) {
        logger.info("Saving message: {}. ", message);
        return messageRepository.save(message);
    }

    // Get a Single Message
    @GetMapping("/messages/{id}")
    public Message getMessageById(@PathVariable(value = "id") Integer messageId) {
        Message message = messageRepository.findOne(messageId);
        logger.info("Retrieved user from DB: {}. ", message);
        return message;
    }

    // Update a Message
    @PutMapping("/messages")
    public Message updateMessage(@RequestBody Message message) {
        logger.info("Updating message in DB: {}. ", message);
        messageRepository.save(message);
        logger.info("Updated message in DB: {}. ", message);
        return message;
    }

    // Delete a Message
    @DeleteMapping("/messages/{id}")
    public void deleteMessage(@PathVariable("id") Integer messageId) {
        logger.info("Deleting message from DB with ID: {}. ", messageId);
        messageRepository.delete(messageId);
    }

}