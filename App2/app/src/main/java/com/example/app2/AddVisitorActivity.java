package com.example.app2;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddVisitorActivity extends AppCompatActivity {

    EditText name, email, mobile, intime, outtime;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_visitor);

        name = findViewById(R.id.visitor_name);
        email = findViewById(R.id.visitor_email);
        mobile = findViewById(R.id.visitor_mobile);
        intime = findViewById(R.id.visitor_intime);
        outtime = findViewById(R.id.visitor_outtime);

        saveButton.setOnClickListener(v ->
        {
            String visitorName = name.getText().toString().trim();
            String visitorEmail = email.getText().toString().trim();
            String visitorMobile = mobile.getText().toString().trim();
            String visitorInTime = intime.getText().toString().trim();
            String visitorOutTime = outtime.getText().toString().trim();

            // Basic validation (optional)
            if (visitorName.isEmpty() || visitorEmail.isEmpty() || visitorMobile.isEmpty() ||
                    visitorInTime.isEmpty() || visitorOutTime.isEmpty()) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
                return;
            }

            // You can handle saving the data here (e.g., save to a database or pass it back to MainActivity)

            Toast.makeText(this, "Visitor added successfully!", Toast.LENGTH_SHORT).show();
            finish(); // Finish the activity and return to the previous screen
        });



    }
}