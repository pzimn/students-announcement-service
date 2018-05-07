package com.student.service.web.controller;


import com.student.service.web.model.Comment;
import com.student.service.web.service.facade.api.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentController {

    private final Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    CommentService commentService;

    // Get All Comments
    @GetMapping("/comments")
    public List<Comment> getAllComments() {
        return commentService.findAll();
    }

    // Create a new Comment
    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comment) {
        logger.info("Saving comment: {}. ", comment);
        return commentService.save(comment);
    }

    // Get a Single Comment
    @GetMapping("/comments/{id}")
    public Comment getCommentById(@PathVariable(value = "id") Integer commentId) {
        Comment comment = commentService.findOne(commentId);
        logger.info("Retrieved user from DB: {}. ", comment);
        return comment;
    }

    // Update a Comment
    @PutMapping("/comments")
    public Comment updateComment(@RequestBody Comment comment) {
        logger.info("Updating comment in DB: {}. ", comment);
        commentService.save(comment);
        logger.info("Updated comment in DB: {}. ", comment);
        return comment;
    }

    // Delete a Comment
    @DeleteMapping("/comments/{id}")
    public void deleteComment(@PathVariable("id") Integer commentId) {
        logger.info("Deleting comment from DB with ID: {}. ", commentId);
        commentService.deleteById(commentId);
    }

}


