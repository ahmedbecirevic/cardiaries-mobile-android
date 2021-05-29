package com.androidapp.cardiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button register;
    EditText username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        register = findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(email.getText().toString(), username.getText().toString(), password.getText().toString());
                if (validate(user)) {
                    CarDiariesDatabase database = CarDiariesDatabase.getCarDiariesDatabase(getApplicationContext());
                    UserDao userDao = database.userDao();
                    new Thread(() -> {
                        userDao.register(user);
                        runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_SHORT).show());
                    }).start();
                } else {
                    Toast.makeText(getApplicationContext(), "Some fields are missing!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validate (User user) {
        if (user.getEmail().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()) return false;
        return true;
    }
}