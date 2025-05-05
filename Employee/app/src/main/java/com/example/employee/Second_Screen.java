package com.example.employee;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class Second_Screen extends AppCompatActivity {

    RecyclerView recyclerView;
    VisitorAdapter adapter;
    ArrayList<Visitor> visitorList;

    Button cancelButton;

    ActivityResultLauncher<Intent> editVisitorLauncher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        recyclerView = findViewById(R.id.recyclerViewSecond);

        visitorList = (ArrayList<Visitor>) getIntent().getSerializableExtra("visitorList");

        // In your EditVisitorActivity or the activity with the Cancel button

        Button cancelButton = findViewById(R.id.cancelButton);  // Get the Cancel button



        cancelButton.setOnClickListener(v -> {
            // Create an AlertDialog to ask for confirmation
            new AlertDialog.Builder(Second_Screen.this)  // Use Second_Screen.this instead of EditVisitorActivity.this
                    .setMessage("Are you sure you want to cancel?")
                    .setCancelable(false)  // Prevent the dialog from being dismissed by clicking outside
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // If user clicks "Yes", navigate back to the first screen (MainActivity)
                        Intent intent = new Intent(Second_Screen.this, MainActivity.class);
                        startActivity(intent);  // Navigate to MainActivity
                        finish();  // Finish this activity (optional, to clear this screen from the stack)
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        // If user clicks "No", do nothing and stay on the current screen
                        dialog.dismiss();  // Close the dialog
                    })
                    .show();  // Show the dialog
        });





        editVisitorLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Visitor updatedVisitor = (Visitor) result.getData().getSerializableExtra("updatedVisitor");

                        for (int i = 0; i < visitorList.size(); i++) {
                            if (visitorList.get(i).getName().equals(updatedVisitor.getName())) {
                                visitorList.set(i, updatedVisitor);
                                adapter.notifyItemChanged(i);
                                Toast.makeText(this, "Visitor updated", Toast.LENGTH_SHORT).show();
                                break;
                            }
                        }
                    }
                });

        adapter = new VisitorAdapter(this, visitorList, editVisitorLauncher);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

}
