package com.student.service.web.service.facade.api;

import com.student.service.web.model.Message;

import java.util.List;

public interface MessageService {

    Message findById(Integer id);

    void saveMessage(Message message);

    void updateMessage(Message message);

    void deleteMessageById(Integer id);

    void deleteAllMessages();

    List<Message> findAllMessages();

    boolean isMessageExist(Message message);
}