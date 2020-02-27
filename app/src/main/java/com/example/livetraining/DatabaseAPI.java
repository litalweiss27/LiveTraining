package com.example.livetraining;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseAPI {

    FirebaseDatabase firebaseDatabase;
   public  DatabaseReference databaseReference;

    public DatabaseAPI(FirebaseDatabase firebaseDatabase, DatabaseReference databaseReferenceCurrent, DatabaseReference databaseReference)
    {
        this.firebaseDatabase = FirebaseDatabase.getInstance();
        this.databaseReference = firebaseDatabase.getReference().child("TEST");
    }

    void SendObjectToDatabase(Object object)
    {
        String key = "";
        databaseReference.child(key).setValue(object);

    }

    void removeObjectFromDatabase(String objectKey)
    {

    }

    Object GetObjectFromDatabase(String objectKey)
    {
        return null;
    }
}
