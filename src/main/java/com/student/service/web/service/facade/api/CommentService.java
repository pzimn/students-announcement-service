package com.student.service.web.service.facade.api;

import com.student.service.web.model.Comment;

import java.util.List;

public interface CommentService {

    Comment findOne(Integer id);

    Comment save(Comment comment);

    void update(Comment comment);

    void deleteById(Integer id);

    void deleteAll();

    List<Comment> findAll();
}
