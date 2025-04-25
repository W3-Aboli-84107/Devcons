package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondScreen extends AppCompatActivity {

    TextView dataTextView;
    Button backButton, cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        dataTextView = findViewById(R.id.dataTextView);
        backButton = findViewById(R.id.backButton);
        cancelButton = findViewById(R.id.cancelbtn);

        String visitorData = getIntent().getStringExtra("visitorData");
        dataTextView.setText(visitorData != null ? visitorData : "No data received.");

        backButton.setOnClickListener(v -> finish());

        cancelButton.setOnClickListener(v -> finish()); // Or implement additional logic
    }

    public boolean onCreateOptionenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (item.getItemId() == R.id.add)
        {
            Intent intent = new Intent(SecondScreen.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

