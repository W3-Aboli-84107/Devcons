package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SecondScreen extends AppCompatActivity {

    Toolbar toolbar;
    Button cancelButton;
    RecyclerView recyclerView;
    VisitorAdapter visitorAdapter;
    ArrayList<Visitor> visitorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        // Initialize the toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize the cancel button
        cancelButton = findViewById(R.id.cancelButton);
        recyclerView = findViewById(R.id.recyclerViewVisitors);

        // Set up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the list and adapter
        visitorList = new ArrayList<>();
        visitorAdapter = new VisitorAdapter(visitorList);
        recyclerView.setAdapter(visitorAdapter);

        // Set the cancel button listener with a confirmation dialog
        cancelButton.setOnClickListener(v -> {
            // Show confirmation dialog
            new AlertDialog.Builder(SecondScreen.this)
                    .setTitle("Cancel")
                    .setMessage("Are you sure you want to cancel?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        // If user clicks 'Yes', go back to MainActivity
                        startActivity(new Intent(SecondScreen.this, MainActivity.class));
                        finish();
                    })
                    .setNegativeButton("No", null) // If 'No', just close the dialog
                    .show();
        });

        // Get the visitor data passed from MainActivity
        Intent intent = getIntent();
        ArrayList<Visitor> visitors = (ArrayList<Visitor>) intent.getSerializableExtra("visitorDataList");

        // If there are visitors, display them
        if (visitors != null && !visitors.isEmpty()) {
            visitorList.addAll(visitors);
            visitorAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "No visitor data available", Toast.LENGTH_SHORT).show();
        }
    }
}