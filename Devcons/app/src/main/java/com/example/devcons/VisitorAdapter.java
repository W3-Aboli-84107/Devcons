package com.example.emp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder> {

    private List<Visitor> visitors;

    @NonNull
    @Override
    public VisitorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.visitor_item, parent, false);
        return new VisitorViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorViewHolder holder, int position) {
        Visitor visitor = visitors.get(position);
        holder.nameText.setText(visitor.getName());
        holder.emailText.setText(visitor.getEmail());
        holder.phoneText.setText(visitor.getPhone());
        holder.intimeText.setText(visitor.getIntime());
        holder.outtimeText.setText(visitor.getOuttime());
    }

    @Override
    public int getItemCount() {
        return visitors != null ? visitors.size() : 0;
    }

    public void setVisitors(List<Visitor> visitors) {
        this.visitors = visitors;
        notifyDataSetChanged();
    }

    class VisitorViewHolder extends RecyclerView.ViewHolder {

        private TextView nameText, emailText, phoneText, intimeText, outtimeText;

        public VisitorViewHolder(View itemView) {
            super(itemView);
            nameText = itemView.findViewById(R.id.nameText);
            emailText = itemView.findViewById(R.id.emailText);
            phoneText = itemView.findViewById(R.id.mobileText);
            intimeText = itemView.findViewById(R.id.intimeText);
            outtimeText = itemView.findViewById(R.id.outtimeText);
        }
    }
}
