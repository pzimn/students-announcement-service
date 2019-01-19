package com.student.service.web.service.facade.api;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.service.web.model.Comment;

public interface CommentService extends JpaRepository<Comment, Integer> {

    void deleteById(Integer id);
}
