package com.example.Abella;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import java.util.HashMap;

public class User {
    private DatabaseReference databaseReference;
    public User(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference("UserData");//(ModalClass.class.getSimpleName());
    }
    public Task<Void> add(ModalClass modal){
        return databaseReference.push().setValue(modal);
    }

    public Task<Void> update(String key, HashMap<String, Object> hashmap){
        return databaseReference.child(key).updateChildren(hashmap);
    }
    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }
    public Query get(){
        return databaseReference.orderByKey();
    }
}