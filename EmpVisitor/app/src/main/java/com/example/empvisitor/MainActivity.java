
package com.example.empvisitor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.empvisitor.dao.VisitorDao;
import com.example.empvisitor.data.VisitorDatabase;
import com.example.empvisitor.model.Visitor;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText editName, editMobile, editEmail, editPurpose;
    Button submitButton;
    ArrayList<Visitor> visitorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VisitorDatabase db = VisitorDatabase.getInstance(this);
        VisitorDao visitorDao = db.visitorDao();

        // Initialize Views
        editName = findViewById(R.id.editName);
        editMobile = findViewById(R.id.editMobile);
        editEmail = findViewById(R.id.editEmail);
        editPurpose = findViewById(R.id.editPurpose);
        submitButton = findViewById(R.id.buttonSubmit);

        submitButton.setOnClickListener(v -> {
            String name = editName.getText().toString().trim();
            String mobile = editMobile.getText().toString().trim();
            String email = editEmail.getText().toString().trim();
            String purpose = editPurpose.getText().toString().trim();
            String inTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

            if (TextUtils.isEmpty(name) || TextUtils.isEmpty(mobile) || TextUtils.isEmpty(email) || TextUtils.isEmpty(purpose)) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
                return;
            }

            Visitor visitor = new Visitor(name, email,mobile, inTime, "", purpose );

            // Insert into DB asynchronously
            Executors.newSingleThreadExecutor().execute(() -> {
                visitorDao.insert(visitor); // Insert visitor into database
            });

            // Add to list
            visitorList.add(visitor);

            // Pass visitor list to second screen
            Intent intent = new Intent(MainActivity.this, Second_Screen.class);
            intent.putExtra("visitorList", visitorList);
            startActivity(intent);
        });
    }
}
