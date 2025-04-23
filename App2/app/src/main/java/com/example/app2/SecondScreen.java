package com.example.app2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondScreen extends AppCompatActivity {

    TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_screen);

        displayText = findViewById(R.id.displayText);

        // Get the data from intent
        String visitorsData = getIntent().getStringExtra("visitorsData");

        // Set the data to TextView
        displayText.setText(visitorsData);



    }
}