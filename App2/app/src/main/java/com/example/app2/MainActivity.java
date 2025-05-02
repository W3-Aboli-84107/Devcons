package com.example.app2;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText name, mobileno, Email, intime, outtime;
    Button save;

    // Static list to store multiple visitor entries
    public static ArrayList<Visitor> visitorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.username);
        mobileno = findViewById(R.id.mobile);
        Email = findViewById(R.id.mail);
        intime = findViewById(R.id.intime);
        outtime = findViewById(R.id.outtime);
        save = findViewById(R.id.submit);

        intime.setOnClickListener(v -> showTimePicker(intime));
        outtime.setOnClickListener(v -> showTimePicker(outtime));

        save.setOnClickListener(v -> {
            String visitorName = name.getText().toString().trim();
            String email = Email.getText().toString().trim();
            String mobileNumber = mobileno.getText().toString().trim();
            String inTime = intime.getText().toString().trim();
            String outTime = outtime.getText().toString().trim();

            // Validation
            if (visitorName.isEmpty() || email.isEmpty() || mobileNumber.isEmpty() || inTime.isEmpty() || outTime.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d{10}")) {
                Toast.makeText(this, "Enter a valid 10-digit mobile number", Toast.LENGTH_SHORT).show();
                return;
            }

            // Create and add visitor entry
            Visitor visitor = new Visitor(visitorName, email, mobileNumber, inTime, outTime);
            visitorList.add(visitor);

            // Go to SecondScreen with the list
            Intent intent = new Intent(MainActivity.this, SecondScreen.class);
            intent.putExtra("visitorDataList", visitorList);
            startActivity(intent);
        });
    }

    private void showTimePicker(final EditText targetField) {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                (TimePicker view, int hourOfDay, int minute1) -> {
                    String time = String.format("%02d:%02d", hourOfDay, minute1);
                    targetField.setText(time);
                },
                hour, minute, true);
        timePickerDialog.show();
    }
}
