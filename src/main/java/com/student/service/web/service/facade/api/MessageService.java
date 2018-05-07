package com.student.service.web.service.facade.api;

import com.student.service.web.model.Message;

import java.util.List;

public interface MessageService {

    Message findOne(Integer id);

    Message save(Message message);

    void update(Message message);

    void deleteById(Integer id);

    void deleteAll();

    List<Message> findAll();
}