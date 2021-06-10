package com.androidapp.cardiaries;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PostDataActivity extends AppCompatActivity {
    private EditText carName, description;
    private Button addButton, deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_list_adapter);

        carName = findViewById(R.id.car_title);
        description = findViewById(R.id.description_of_post);
    }
}
