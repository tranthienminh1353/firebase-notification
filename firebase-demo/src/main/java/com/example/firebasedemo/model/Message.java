package com.example.firebasedemo.model;

import com.google.cloud.Timestamp;
import lombok.*;

@Data
public class Message {
    String message;
    Timestamp timestamp;
}
