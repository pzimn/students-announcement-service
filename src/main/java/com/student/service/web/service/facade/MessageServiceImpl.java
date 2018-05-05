package com.student.service.web.service.facade;

import com.student.service.web.model.Message;
import com.student.service.web.repository.MessageRepository;
import com.student.service.web.service.facade.api.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message findById(Integer id) {
        return messageRepository.findOne(id);
    }

    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    public void updateMessage(Message message){
        saveMessage(message);
    }

    public void deleteMessageById(Integer id){
        messageRepository.delete(id);
    }

    public void deleteAllMessages(){
        messageRepository.deleteAll();
    }

    public List<Message> findAllMessages(){
        return messageRepository.findAll();
    }

    public boolean isMessageExist(Message message) {
        //return findByName(message.getName()) != null;
        return false; //todo
    }
}
