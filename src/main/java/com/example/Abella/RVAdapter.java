package com.example.Abella;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public Context context;
    ArrayList<ModalClass> list = new ArrayList<>();
    public RVAdapter(Context ctx){
        this.context = ctx;

    }
    public void setItems(ArrayList<ModalClass> modal){
        list.addAll(modal);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new ModalVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ModalVH vh = (ModalVH) holder;
        ModalClass modal = list.get(position);
        vh.txt_name.setText(modal.getName());
        vh.txt_age.setText(modal.getAge());
        vh.txt_gender.setText(modal.getGender());
        vh.txt_contact.setText(modal.getContact());
        vh.txt_address.setText(modal.getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
