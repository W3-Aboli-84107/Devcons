package com.example.app2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder> {

    private final ArrayList<Visitor> visitorList;

    public VisitorAdapter(ArrayList<Visitor> visitorList) {
        this.visitorList = visitorList;
    }

    @NonNull
    @Override
    public VisitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_visitor, parent, false);
        return new VisitorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorViewHolder holder, int position) {
        Visitor visitor = visitorList.get(position);
        holder.nameTextView.setText(visitor.getName());
        holder.emailTextView.setText(visitor.getEmail());
        holder.mobileTextView.setText(visitor.getMobileNumber());
        holder.inTimeTextView.setText(visitor.getInTime());
        holder.outTimeTextView.setText(visitor.getOutTime());
    }

    @Override
    public int getItemCount() {
        return visitorList.size();
    }

    public static class VisitorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, emailTextView, mobileTextView, inTimeTextView, outTimeTextView;

        public VisitorViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            mobileTextView = itemView.findViewById(R.id.mobileTextView);
            inTimeTextView = itemView.findViewById(R.id.inTimeTextView);
            outTimeTextView = itemView.findViewById(R.id.outTimeTextView);
        }
    }
}
