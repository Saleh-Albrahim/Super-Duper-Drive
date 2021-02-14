package com.udacity.jwdnd.course1.cloudstorage.service;

import com.udacity.jwdnd.spring_security_basics.mapper.MessageMapper;
import com.udacity.jwdnd.spring_security_basics.model.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageListService {


    private MessageMapper messageMapper;

    public MessageListService(MessageMapper messageMapper) {
        this.messageMapper=messageMapper;
    }

    public void addMessage(Message message) {

        messageMapper.insert(message);

    }

    public List<Message> getMessages(String username) {
        return messageMapper.getMessage(username);
    }
}
