package com.student.service.web.service.facade.api;

import com.student.service.web.model.Comment;

import java.util.List;

public interface CommentService {

    Comment findById(Integer id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(Integer id);

    void deleteAllComments();

    List<Comment> findAllComments();

    boolean isCommentExist(Comment comment);
}
