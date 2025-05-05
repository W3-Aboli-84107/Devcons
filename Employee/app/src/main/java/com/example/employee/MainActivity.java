package com.example.employee;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name, mobileno, email, intime, outtime;
    Button save;
    RecyclerView recyclerView;
    VisitorAdapter adapter;
    List<Visitor> visitorList;
    ActivityResultLauncher<Intent> editLauncher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.username);
        email = findViewById(R.id.mail);
        mobileno = findViewById(R.id.mobile);
        intime = findViewById(R.id.intime);
        outtime = findViewById(R.id.outtime);
        save = findViewById(R.id.submit);
        recyclerView = findViewById(R.id.recyclerView);

        intime.setOnClickListener(v -> showTimePicker(intime));
        outtime.setOnClickListener(v -> showTimePicker(outtime));

        visitorList = new ArrayList<>();

        // ✅ Initialize the launcher for editing visitor data
        editLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Visitor updatedVisitor = (Visitor) result.getData().getSerializableExtra("updatedVisitor");
                        if (updatedVisitor != null) {
                            for (int i = 0; i < visitorList.size(); i++) {
                                if (visitorList.get(i).getName().equals(updatedVisitor.getName())) {
                                    visitorList.set(i, updatedVisitor);
                                    adapter.notifyItemChanged(i);
                                    break;
                                }
                            }
                            Toast.makeText(this, "Visitor updated", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

        adapter = new VisitorAdapter(this, visitorList, editLauncher);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        save.setOnClickListener(v -> {
            String visitorName = name.getText().toString().trim();
            String emailText = email.getText().toString().trim();
            String mobileNumber = mobileno.getText().toString().trim();
            String inTime = intime.getText().toString().trim();
            String outTime = outtime.getText().toString().trim();

            if (visitorName.isEmpty() || emailText.isEmpty() || mobileNumber.isEmpty() || inTime.isEmpty() || outTime.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) {
                Toast.makeText(this, "Enter a valid email", Toast.LENGTH_SHORT).show();
                return;
            }

            if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d{10}")) {
                Toast.makeText(this, "Enter a valid 10-digit mobile number", Toast.LENGTH_SHORT).show();
                return;
            }

            // Add visitor to list and update UI
            Visitor visitor = new Visitor(visitorName, emailText, mobileNumber, inTime, outTime);
            visitorList.add(visitor);
            adapter.notifyItemInserted(visitorList.size() - 1);

            // Clear form
            name.setText("");
            email.setText("");
            mobileno.setText("");
            intime.setText("");
            outtime.setText("");

            // Navigate to second screen with full list
            Intent intent = new Intent(MainActivity.this, Second_Screen.class);
            intent.putExtra("visitorList", new ArrayList<>(visitorList)); // Visitor must implement Serializable
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
