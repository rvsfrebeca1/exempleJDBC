package com.example.exemple.jdbc.service;

import com.example.exemple.jdbc.model.Message;
import com.example.exemple.jdbc.repository.MessageWriteRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageWriteRepository writeRepository;

    public MessageService(MessageWriteRepository writeRepository) {
        this.writeRepository = writeRepository;
    }


    public Message save(Message message){

        return writeRepository.persist(message);

    }



}
