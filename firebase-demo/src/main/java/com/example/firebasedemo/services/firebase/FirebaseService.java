package com.example.firebasedemo.services.firebase;

import com.example.firebasedemo.model.Message;
import com.google.cloud.Timestamp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Component;

@Component
public class FirebaseService {

    public void sendNotification(String title, String message, String id) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference(title).child("Message-" + id);
        Message mes = new Message();
        mes.setMessage(message);
        mes.setTimestamp(Timestamp.now());
        databaseReference.setValue(mes, (databaseError, reference) -> {
        });
    }
}
