package com.example.Abella;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;

public class Edit extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        final EditText edit_key = findViewById(R.id.idEdtKey);
        final EditText edit_name = findViewById(R.id.idEdtName);
        final EditText edit_age = findViewById(R.id.idEdtAge);
        final EditText edit_gender = findViewById(R.id.idEdtGender);
        final EditText edit_contact = findViewById(R.id.idEdtContact);
        final EditText edit_address = findViewById(R.id.idEdtAddress);
        Button btnUpdate = findViewById(R.id.idBtnUpdate);

        User user = new User();

    }
}