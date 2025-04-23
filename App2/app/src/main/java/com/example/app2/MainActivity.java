package com.example.app2;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mobileno;
    EditText Email;
    EditText intime;
    EditText outtime;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.username);
        mobileno = findViewById(R.id.mobile);
        Email = findViewById(R.id.mail);
        intime = findViewById(R.id.intime);
        outtime = findViewById(R.id.outtime);
        save = findViewById(R.id.submit);

        save.setOnClickListener(v -> {
            String mobilenumber = mobileno.getText().toString().trim();

            if (mobilenumber.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please Enter Mobile Number", Toast.LENGTH_SHORT).show();
            } else if (mobilenumber.length() != 10) {
                Toast.makeText(MainActivity.this, "Enter Valid 10-Digit Number", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Mobile Number: " + mobilenumber, Toast.LENGTH_LONG).show();
            }
        });

        intime.setOnClickListener(v -> showTimePicker(intime));
        outtime.setOnClickListener(v -> showTimePicker(outtime));
    }

    private void showTimePicker(final EditText targetField) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this,
                (TimePicker view, int hourOfDay, int minute1) -> {
                    String time = String.format("%02d:%02d", hourOfDay, minute1);
                    targetField.setText(time);
                },
                hour, minute, true);
        timePickerDialog.show();
    }
}
