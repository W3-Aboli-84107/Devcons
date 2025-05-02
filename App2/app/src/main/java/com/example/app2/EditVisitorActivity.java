package com.example.app2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditVisitorActivity extends AppCompatActivity {

    EditText nameEditText, emailEditText, mobileEditText, intimeEditText, outtimeEditText;
    Button saveButton, cancelButton;
    DatabaseHelper dbHelper;
    int visitorId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_visitor);
        dbHelper = new DatabaseHelper(this);

        // Initialize the views
        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        mobileEditText = findViewById(R.id.mobileEditText);
        intimeEditText = findViewById(R.id.intimeEditText);
        outtimeEditText = findViewById(R.id.outtimeEditText);
        saveButton = findViewById(R.id.saveButton);
        cancelButton = findViewById(R.id.cancelButton);

        // Get the visitor ID passed from the previous activity
        visitorId = getIntent().getIntExtra("visitorId", -1);

        if (visitorId != -1) {
            // Load the visitor's data from the database
            Visitor visitor = dbHelper.getVisitorById(visitorId);
            if (visitor != null) {
                nameEditText.setText(visitor.getName());
                emailEditText.setText(visitor.getEmail());
                mobileEditText.setText(visitor.getMobileNumber());
                intimeEditText.setText(visitor.getInTime());
                outtimeEditText.setText(visitor.getOutTime());
            } else {
                Toast.makeText(this, "Visitor not found", Toast.LENGTH_SHORT).show();
                finish(); // Close the activity if visitor is not found
            }
        }

        // Save button click listener
        saveButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String mobile = mobileEditText.getText().toString().trim();
            String intime = intimeEditText.getText().toString().trim();
            String outtime = outtimeEditText.getText().toString().trim();

            // Validate inputs
            if (name.isEmpty() || email.isEmpty() || mobile.isEmpty() || intime.isEmpty() || outtime.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create a Visitor object with the updated data
            Visitor updatedVisitor = new Visitor(visitorId, name, email, mobile, intime, outtime);

            // Update visitor details in the database
            boolean updated = dbHelper.updateVisitor(updatedVisitor);

            if (updated) {
                Toast.makeText(this, "Visitor updated", Toast.LENGTH_SHORT).show();
                finish(); // Go back to the previous screen
            } else {
                Toast.makeText(this, "Failed to update visitor", Toast.LENGTH_SHORT).show();
            }
        });

        // Cancel button click listener
        cancelButton.setOnClickListener(v -> finish());
    }
}
