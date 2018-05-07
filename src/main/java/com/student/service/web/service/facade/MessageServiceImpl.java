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

    @Override
    public Message findOne(Integer id) {
        return messageRepository.findOne(id);
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void update(Message message){
        save(message);
    }

    @Override
    public void deleteById(Integer id){
        messageRepository.delete(id);
    }

    @Override
    public void deleteAll(){
        messageRepository.deleteAll();
    }

    @Override
    public List<Message> findAll(){
        return messageRepository.findAll();
    }
}
