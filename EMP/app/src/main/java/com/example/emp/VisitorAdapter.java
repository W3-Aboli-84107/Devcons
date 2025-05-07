package com.example.employee;

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

public class VisitorAdapter extends RecyclerView.Adapter<VisitorAdapter.ViewHolder> {

    private List<Visitor> visitorList;
    private Context context;
    private ActivityResultLauncher<Intent> editLauncher;

    public VisitorAdapter(Context context, List<Visitor> visitors, ActivityResultLauncher<Intent> editLauncher) {
        this.context = context;
        this.visitorList = visitors;
        this.editLauncher = editLauncher;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textEmail, textPhone, textInTime, textOutTime;
        LinearLayout detailsContainer;
        ImageView editButton, deleteButton;

        public ViewHolder(View view) {
            super(view);
            textName = view.findViewById(R.id.nameText);
            textEmail = view.findViewById(R.id.emailText);
            textPhone = view.findViewById(R.id.editPhone);
            textInTime = view.findViewById(R.id.intime);
            textOutTime = view.findViewById(R.id.outtime);
            detailsContainer = view.findViewById(R.id.detailsContainer);
            editButton = view.findViewById(R.id.editButton);
            deleteButton = view.findViewById(R.id.deleteButton);
        }
    }

    @Override
    public VisitorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {
        Visitor visitor = visitorList.get(position);
        holder.textName.setText(visitor.getName());
        holder.textEmail.setText("Email: " + visitor.getEmail());
        holder.textPhone.setText("Phone: " + visitor.getPhone());
        holder.textInTime.setText("In Time: " + visitor.getInTime());
        holder.textOutTime.setText("Out Time: " + visitor.getOutTime());

        holder.detailsContainer.setVisibility(View.GONE);

        holder.textName.setOnClickListener(v -> {
            holder.detailsContainer.setVisibility(
                    holder.detailsContainer.getVisibility() == View.GONE ? View.VISIBLE : View.GONE
            );
        });

        holder.editButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditVisitorActivity.class);
            intent.putExtra("visitor", visitor);
            editLauncher.launch(intent);
        });

        holder.deleteButton.setOnClickListener(v -> {
            visitorList.remove(position);
            notifyItemRemoved(position);
            Toast.makeText(context, "Visitor deleted", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return visitorList.size();
    }
}
