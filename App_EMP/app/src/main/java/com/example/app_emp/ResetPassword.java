package com.example.app_emp;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.app_emp.database.AppDatabase;
import com.example.app_emp.model.User;

public class ResetPassword extends AppCompatActivity {

    EditText etEmail, etOtp, etNewPassword;
    Button btnSendOtp, btnReset;
    String generatedOtp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reset_password);


        etEmail = findViewById(R.id.etEmail);
        etOtp = findViewById(R.id.etOtp);
        etNewPassword = findViewById(R.id.etNewPassword);
        btnSendOtp = findViewById(R.id.btnSendOtp);
        btnReset = findViewById(R.id.btnReset);

        btnSendOtp.setOnClickListener(view -> {
            String email = etEmail.getText().toString().trim();
            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Email required");
                return;
            }

            User user = AppDatabase.getInstance(this).userDao().findUserByEmail(email);
            if (user == null) {
                Toast.makeText(this, "Email not found!", Toast.LENGTH_SHORT).show();
            } else {
                // Mock OTP generation
                generatedOtp = String.valueOf((int) (Math.random() * 9000) + 1000);
                Toast.makeText(this, "OTP (Mock): " + generatedOtp, Toast.LENGTH_LONG).show();
            }
        });

        btnReset.setOnClickListener(view -> {
            String email = etEmail.getText().toString().trim();
            String otp = etOtp.getText().toString().trim();
            String newPassword = etNewPassword.getText().toString();

            if (!otp.equals(generatedOtp)) {
                Toast.makeText(this, "Invalid OTP!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (newPassword.length() < 6) {
                etNewPassword.setError("Password must be at least 6 characters");
                return;
            }

            AppDatabase.getInstance(this).userDao().updatePassword(email, newPassword);
            Toast.makeText(this, "Password reset successful!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
