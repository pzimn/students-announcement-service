package com.student.service.web.service.facade;

import com.student.service.web.model.Comment;
import com.student.service.web.repository.CommentRepository;
import com.student.service.web.service.facade.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment findById(Integer id) {
        return commentRepository.findOne(id);
    }

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void updateComment(Comment comment){
        saveComment(comment);
    }

    public void deleteCommentById(Integer id){
        commentRepository.delete(id);
    }

    public void deleteAllComments(){
        commentRepository.deleteAll();
    }

    public List<Comment> findAllComments(){
        return commentRepository.findAll();
    }

    public boolean isCommentExist(Comment comment) {
        //return findByName(comment.getName()) != null;
        return false; //todo
    }
}
