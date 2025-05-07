package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class VisitorDetailActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvMobile, tvInTime, tvOutTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail); // This layout will show all data

        // Find the TextViews by ID
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvMobile = findViewById(R.id.tvMobile);
        tvInTime = findViewById(R.id.tvInTime);
        tvOutTime = findViewById(R.id.tvOutTime);

        // Get the data sent from SecondScreen
        Intent intent = getIntent();
        tvName.setText("Name: " + intent.getStringExtra("name"));
        tvEmail.setText("Email: " + intent.getStringExtra("email"));
        tvMobile.setText("Mobile: " + intent.getStringExtra("mobile"));
        tvInTime.setText("In Time: " + intent.getStringExtra("inTime"));
        tvOutTime.setText("Out Time: " + intent.getStringExtra("outTime"));
    }
}
