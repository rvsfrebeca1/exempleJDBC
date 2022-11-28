package com.example.exemple.jdbc.controller;

import com.example.exemple.jdbc.model.Message;
import com.example.exemple.jdbc.service.MessageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping
    public ResponseEntity<Message> save(@RequestBody final Message message, @RequestHeader HttpHeaders headers) {

        // call save service
        final Optional<Message> saved = Optional.ofNullable(this.messageService.save(message));

        // if saved is empty, return accepted because fallback process will be executed
        if (saved.isEmpty()) {
            return ResponseEntity.accepted().build();
        }

        // return created when successfully service executed
        return ResponseEntity.status(HttpStatus.CREATED).body(saved.get());
    }
}
