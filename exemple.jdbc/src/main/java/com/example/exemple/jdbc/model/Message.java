package com.example.exemple.jdbc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Message {
    private String id;
    private String name;
    private Integer idade;
}
