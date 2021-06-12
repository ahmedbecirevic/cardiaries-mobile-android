package com.androidapp.cardiaries;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PostDataActivity extends AppCompatActivity {
    private EditText carName, description;
    private Button updateButton, deleteButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cardiaries_data_activity);

        carName = findViewById(R.id.car_title);
        description = findViewById(R.id.description_of_post);
        updateButton = findViewById(R.id.update_post_button);
        deleteButton = findViewById(R.id.delete_post_button);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            long id = extras.getLong(HomeFragment.POST_ID);
            Post post = CarDiariesDatabase.getCarDiariesDatabase(this).postDao().getPostById(id);
            carName.setText(post.getCarName());
            description.setText(post.getDescription());
            updateButton.setText("UPDATE POST");
            deleteButton.setText("DELETE POST");
        }
    }

    public void onRightButton (View view) {
        Post post = new Post(description.getText().toString(), carName.getText().toString());
        if (deleteButton.getText().toString() == "UPDATE POST") {
            long id = getIdFromExtras();
            CarDiariesDatabase.getCarDiariesDatabase(this).postDao().updatePost(post.getCarName(), post.getDescription(), id);
        } else {
            CarDiariesDatabase.getCarDiariesDatabase(this).postDao().makeNewPost(post);
        }
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    public void onLeftButton (View view) {
        if (deleteButton.getText().toString() == "DELETE POST") {
            long id = getIdFromExtras();
            CarDiariesDatabase.getCarDiariesDatabase(this).postDao().deletePost(id);
        }
        Intent intent = new Intent(this, Home.class);
        startActivity(intent);
    }

    private long getIdFromExtras() {
        return getIntent().getExtras().getLong(HomeFragment.POST_ID);
    }
}
