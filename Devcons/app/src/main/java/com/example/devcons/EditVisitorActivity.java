package com.example.emp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditVisitorActivity extends AppCompatActivity {

    private EditText editName, editEmail, editPhone, editInTime, editOutTime;
    private Button saveButton;
    private Visitor visitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_visitor);

        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editInTime = findViewById(R.id.editInTime);
        editOutTime = findViewById(R.id.editOutTime);
        saveButton = findViewById(R.id.saveButton);

        visitor = (Visitor) getIntent().getSerializableExtra("visitor");

        editName.setText(visitor.getName());
        editEmail.setText(visitor.getEmail());
        editPhone.setText(visitor.getPhone());
        editInTime.setText(visitor.getInTime());
        editOutTime.setText(visitor.getOutTime());

        saveButton.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String phone = editPhone.getText().toString().trim();
            String inTime = editInTime.getText().toString().trim();
            String outTime = editOutTime.getText().toString().trim();

            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || inTime.isEmpty() || outTime.isEmpty()) {
                Toast.makeText(this, "All fields must be filled", Toast.LENGTH_SHORT).show();
            } else {
                visitor.setName(name);
                visitor.setEmail(email);
                visitor.setPhone(phone);
                visitor.setInTime(inTime);
                visitor.setOutTime(outTime);

                Intent resultIntent = new Intent();
                resultIntent.putExtra("updatedVisitor", visitor);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
