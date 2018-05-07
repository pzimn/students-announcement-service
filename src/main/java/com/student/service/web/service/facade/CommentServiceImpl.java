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

    @Override
    public Comment findOne(Integer id) {
        return commentRepository.findOne(id);
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void update(Comment comment){
        save(comment);
    }

    @Override
    public void deleteById(Integer id){
        commentRepository.delete(id);
    }

    @Override
    public void deleteAll(){
        commentRepository.deleteAll();
    }

    @Override
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }
}
