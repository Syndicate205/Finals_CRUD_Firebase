package com.example.Abella;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User user = new User();
        mAuth = FirebaseAuth.getInstance();

        final EditText edit_key = findViewById(R.id.idEdtKey);
        final EditText edit_name = findViewById(R.id.idEdtName);
        final EditText edit_age = findViewById(R.id.idEdtAge);
        final EditText edit_gender = findViewById(R.id.idEdtGender);
        final EditText edit_contact = findViewById(R.id.idEdtContact);
        final EditText edit_address = findViewById(R.id.idEdtAddress);
        Button btnAdd = findViewById(R.id.idBtnAdd); //Add button
        Button btnRead = findViewById(R.id.idBtnRead); //Read button
        Button btnUpdate = findViewById(R.id.idBtnUpdate); //Update button
        Button btnRemove = findViewById(R.id.idBtnRemove); //Delete button
        Button btnLogout = findViewById(R.id.idBtnLogout); //Logout button

        btnAdd.setOnClickListener(v -> {
            ModalClass modal = new ModalClass(
                    edit_name.getText().toString(),
                    edit_age.getText().toString(),
                    edit_gender.getText().toString(),
                    edit_contact.getText().toString(),
                    edit_address.getText().toString());
            user.add(modal).addOnSuccessListener(suc -> {
                Toast.makeText(this, "Data recorded", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
        btnRead.setOnClickListener(view ->  {
            startActivity(
                    new Intent(MainActivity.this, RVActivity.class)
            );
        });
        btnUpdate.setOnClickListener(v -> {
            HashMap<String, Object> hashmap = new HashMap<>();
            hashmap.put("name", edit_name.getText().toString());
            hashmap.put("age", edit_age.getText().toString());
            hashmap.put("gender", edit_gender.getText().toString());
            hashmap.put("contact", edit_contact.getText().toString());
            hashmap.put("address", edit_address.getText().toString());
            user.update(edit_key.getText().toString(), hashmap).addOnSuccessListener(suc ->{
                Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
        btnRemove.setOnClickListener(v -> {
            user.remove(edit_key.getText().toString()).addOnSuccessListener(suc ->{
                Toast.makeText(this, "Data deleted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er -> {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });
        btnLogout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, Login.class));
            Toast.makeText(this, "Sign out successful", Toast.LENGTH_SHORT).show();
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, Login.class));
        }
    }
}