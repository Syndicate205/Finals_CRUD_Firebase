package com.example.Abella;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ModalVH extends RecyclerView.ViewHolder {
    public TextView txt_name, txt_age, txt_gender, txt_contact, txt_address;
    public ModalVH(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_age = itemView.findViewById(R.id.txt_age);
        txt_gender = itemView.findViewById(R.id.txt_gender);
        txt_contact = itemView.findViewById(R.id.txt_contact);
        txt_address = itemView.findViewById(R.id.txt_address);
    }
}
