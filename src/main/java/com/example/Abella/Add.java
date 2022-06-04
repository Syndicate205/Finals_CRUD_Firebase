package com.example.Abella;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Add extends AppCompatActivity {

    private DatabaseReference mDatabase;
    Button add;
    EditText edtname, edtage, edtgender, edtcontact, edtaddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        mDatabase = db.getReference();

        edtname = findViewById(R.id.idEdtName);
        edtage = findViewById(R.id.idEdtAge);
        edtgender = findViewById(R.id.idEdtGender);
        edtcontact = findViewById(R.id.idEdtContact);
        edtaddress = findViewById(R.id.idEdtAddress);

        add = findViewById(R.id.idBtnAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String recordName = edtname.getText().toString();
                String recordAge = edtage.getText().toString();
                String recordGender = edtgender.getText().toString();
                String recordContact = edtcontact.getText().toString();
                String recordStatus = edtaddress.getText().toString();

                addData(recordName, recordAge, recordGender, recordContact, recordStatus);
            }
        });
    }
    public void addData(String name, String age, String gender, String contact, String address){
        //ModalClass modal = new ModalClass(name, age, gender, contact, address);

        //mDatabase.child("UserData").push().setValue(modal);
    }
}