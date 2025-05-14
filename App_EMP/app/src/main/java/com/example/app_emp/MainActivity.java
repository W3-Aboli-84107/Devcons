package com.example.app_emp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_emp.dao.UserDao;
import com.example.app_emp.database.AppDatabase;
import com.example.app_emp.model.User;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btnLogin;
    TextView tvForgetPassword, tvRegister;
    CheckBox rememberMeCheckBox;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("LoginPrefs",MODE_PRIVATE);

        String savedEmail = sharedPreferences.getString("email", "");
        String savedPassword = sharedPreferences.getString("password", "");
        boolean isRemembered = sharedPreferences.getBoolean("rememberMe", false);

        if(isRemembered)
        {
            etUsername.setText(savedEmail);
            etPassword.setText(savedPassword);
            rememberMeCheckBox.setChecked(true);
        }

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgetPassword = findViewById(R.id.tvForgotPassword);
        tvRegister = findViewById(R.id.tvRegister);

        btnLogin.setOnClickListener(view ->
        {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty())
            {
                Toast.makeText(this,"Please Enter All Fields", Toast.LENGTH_SHORT).show();

            }
            else {
               // Toast.makeText(this, "Logging in ...", Toast.LENGTH_SHORT).show();
                User user = AppDatabase.getInstance(this).userDao().login(username, password);
                if (user != null)
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    if (rememberMeCheckBox.isChecked())
                    {
                        editor.putString("email",username);
                        editor.putString("password", password);
                        editor.putBoolean("rememberMe", true);
                    }
                    else
                    {
                        editor.clear();
                    }
                    editor.apply();

                    Toast.makeText(this, "Login Successful !",Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, RegisterPage.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "Invalid Email or Password" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        //1.tvRegister.setOnClickListener(View ->
                //Toast.makeText(this,"Go To Registration Screen", Toast.LENGTH_SHORT).show());

        tvRegister.setOnClickListener(view ->
        {
            Intent intent = new Intent(MainActivity.this, RegisterPage.class);
            startActivity(intent);
        });

        tvForgetPassword.setOnClickListener(View ->
                Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show());

        btnLogin.setOnClickListener(view -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
            } else {
                User user = AppDatabase.getInstance(this).userDao().login(username, password);
                if (user != null) {
                    Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show();
                    // Navigate to HomeActivity or Dashboard
                } else {
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvForgetPassword.setOnClickListener(View ->
        {
            Intent intent = new Intent(MainActivity.this, ResetPassword.class);
            startActivity(intent);
        });




    }
}