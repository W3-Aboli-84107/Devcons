package com.example.empvisitor;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.empvisitor.model.Visitor;
import java.util.ArrayList;

public class Second_Screen extends AppCompatActivity {

    RecyclerView recyclerView;
    VisitorAdapter adapter;
    ArrayList<Visitor> visitorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);



        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewSecond);

        // Get the visitor list passed from MainActivity
        visitorList = (ArrayList<Visitor>) getIntent().getSerializableExtra("visitorList");

        if (visitorList == null) {
            visitorList = new ArrayList<>();
            Toast.makeText(this, "No visitors found", Toast.LENGTH_SHORT).show();
        }
        if (visitorList != null)
        {
            Log.d("Second_Screen","Data received: " + visitorList.size() + "visitord");
        }

        // Set up the RecyclerView with the Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VisitorAdapter(this, visitorList);
        recyclerView.setAdapter(adapter);
    }
}
