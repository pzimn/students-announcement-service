package com.student.service.web.service.facade.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.student.service.web.model.Message;

@Service
public interface MessageService extends JpaRepository<Message, Integer>{

    void deleteById(Integer id);

}