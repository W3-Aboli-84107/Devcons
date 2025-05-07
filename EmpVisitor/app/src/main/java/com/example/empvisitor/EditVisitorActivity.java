//package com.example.empvisitor;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class EditVisitorActivity extends AppCompatActivity {
//
//    private EditText editName, editEmail, editPhone, editInTime, editOutTime;
//    private Button saveButton;
//    private Visitor visitor;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_edit_visitor);
//
//        // Initialize the views
//        editName = findViewById(R.id.editName);
//        editEmail = findViewById(R.id.editEmail);
//        editPhone = findViewById(R.id.editPhone);
//        editInTime = findViewById(R.id.editInTime);
//        editOutTime = findViewById(R.id.editOutTime);
//        saveButton = findViewById(R.id.saveButton);
//
//        // Get the visitor object passed from the RecyclerView
//        Intent intent = getIntent();
//        visitor = (Visitor) intent.getSerializableExtra("visitor");
//
//        // Set the existing data into the EditText fields
//        editName.setText(visitor.getName());
//        editEmail.setText(visitor.getEmail());
//        editPhone.setText(visitor.getPhone());
//        editInTime.setText(visitor.getInTime());
//        editOutTime.setText(visitor.getOutTime());
//
//        // Set listener for Save Button
//        saveButton.setOnClickListener(v -> {
//            String name = editName.getText().toString().trim();
//            String email = editEmail.getText().toString().trim();
//            String phone = editPhone.getText().toString().trim();
//            String inTime = editInTime.getText().toString().trim();
//            String outTime = editOutTime.getText().toString().trim();
//
//            if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || inTime.isEmpty() || outTime.isEmpty()) {
//                Toast.makeText(EditVisitorActivity.this, "All fields must be filled", Toast.LENGTH_SHORT).show();
//            } else {
//                // Update the visitor object with new values
//                visitor.setName(name);
//                visitor.setEmail(email);
//                visitor.setPhone(phone);
//                visitor.setInTime(inTime);
//                visitor.setOutTime(outTime);
//
//                // Return the updated visitor to the calling activity
//                Intent resultIntent = new Intent();
//                resultIntent.putExtra("updatedVisitor", visitor);
//                setResult(RESULT_OK, resultIntent);
//                finish();
//            }
//        });
//    }
//}

package com.example.empvisitor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.empvisitor.model.Visitor;

public class EditVisitorActivity extends AppCompatActivity {

    private EditText editName, editEmail, editMobile, editInTime, editOutTime;
    private Button saveButton, cancelButton;
    private Visitor visitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_visitor);

        // Initialize views
        editName = findViewById(R.id.edit_name);
        editEmail = findViewById(R.id.edit_email);
        editMobile = findViewById(R.id.edit_mobile);
        editInTime = findViewById(R.id.edit_intime);
        editOutTime = findViewById(R.id.edit_outtime);
        saveButton = findViewById(R.id.save_button);
        //cancelButton = findViewById(R.id.cancelButton);

        // Get visitor data passed from the previous activity
        visitor = (Visitor) getIntent().getSerializableExtra("visitor");

        // Set the visitor data to EditText fields
        editName.setText(visitor.getName());
        editEmail.setText(visitor.getEmail());
        editMobile.setText(visitor.getMobile());
        editInTime.setText(visitor.getInTime());
        editOutTime.setText(visitor.getOutTime());

        // Save changes
        saveButton.setOnClickListener(v -> {
            String updatedName = editName.getText().toString().trim();
            String updatedEmail = editEmail.getText().toString().trim();
            String updatedMobile = editMobile.getText().toString().trim();
            String updatedInTime = editInTime.getText().toString().trim();
            String updatedOutTime = editOutTime.getText().toString().trim();

            if (updatedName.isEmpty() || updatedEmail.isEmpty() || updatedMobile.isEmpty() ||
                    updatedInTime.isEmpty() || updatedOutTime.isEmpty()) {
                Toast.makeText(EditVisitorActivity.this, "All fields must be filled.", Toast.LENGTH_SHORT).show();
            } else {
                // Update the visitor object
                visitor.setName(updatedName);
                visitor.setEmail(updatedEmail);
                visitor.setMobile(updatedMobile);
                visitor.setInTime(updatedInTime);
                visitor.setOutTime(updatedOutTime);

                // Create the Intent to send updated visitor data back
                Intent resultIntent = new Intent();
                resultIntent.putExtra("updatedVisitor", visitor);
                setResult(RESULT_OK, resultIntent);

                // Show a toast message
                Toast.makeText(EditVisitorActivity.this, "Visitor details updated successfully.", Toast.LENGTH_SHORT).show();

                // Close the activity
                finish();
            }
        });

        // Cancel the editing
        cancelButton.setOnClickListener(v -> new AlertDialog.Builder(EditVisitorActivity.this)
                .setMessage("Are you sure you want to discard changes?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();  // Close the activity without making changes
                    }
                })
                .setNegativeButton("No", null)
                .show());
    }
}

