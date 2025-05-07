package com.example.empvisitor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.empvisitor.model.Visitor;
import java.util.ArrayList;

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.VisitorViewHolder> {

    private Context context;
    private ArrayList<Visitor> visitorList;

    public VisitorAdapter(Context context, ArrayList<Visitor> visitorList) {
        this.context = context;
        this.visitorList = visitorList;
    }

    @Override
    public VisitorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.visitor_item, parent, false);
        return new VisitorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VisitorViewHolder holder, int position) {
        Visitor visitor = visitorList.get(position);

        holder.nameTextView.setText(visitor.getName());
        holder.emailTextView.setText(visitor.getEmail());
        holder.mobileTextView.setText(visitor.getMobile());
        holder.purposeTextView.setText(visitor.getPurpose());
        holder.inTimeTextView.setText(visitor.getInTime());
    }

    @Override
    public int getItemCount() {
        return visitorList.size();
    }

    public static class VisitorViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, emailTextView, mobileTextView, purposeTextView, inTimeTextView;

        public VisitorViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            emailTextView = itemView.findViewById(R.id.emailTextView);
            mobileTextView = itemView.findViewById(R.id.mobileTextView);
            purposeTextView = itemView.findViewById(R.id.purposeTextView);
            inTimeTextView = itemView.findViewById(R.id.inTimeTextView);
        }
    }
}
