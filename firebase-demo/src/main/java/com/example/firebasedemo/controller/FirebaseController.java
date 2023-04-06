package com.example.firebasedemo.controller;

import com.example.firebasedemo.services.firebase.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class FirebaseController {

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping("/send-notification")
    public ResponseEntity<String> sendNotification(@RequestParam String title, @RequestParam String message) {
        try {
            this.firebaseService.sendNotification(title, message, UUID.randomUUID().toString());
            return ResponseEntity.ok().body("Notification sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok().body("Notification sent error.");
        }
    }
}
