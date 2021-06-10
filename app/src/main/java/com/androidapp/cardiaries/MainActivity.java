package com.androidapp.cardiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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


    }

    private boolean validate (User user) {
        if (user.getEmail().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }

    public void onGoToLoginClick (View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void onRegisterClick (View view) {
        int[] userExists = new int[1];
        User user = new User(email.getText().toString(), username.getText().toString(), password.getText().toString());
        if (validate(user)) {
            CarDiariesDatabase database = CarDiariesDatabase.getCarDiariesDatabase(getApplicationContext());
            UserDao userDao = database.userDao();
            UserDao userDaoTemp = database.userDao();
            userExists[0] = userDaoTemp.checkAccount(username.getText().toString());
            Log.d("app", userExists[0] + "  " + username.getText().toString());
            if (userExists[0] == 0) {
                Toast.makeText(getApplicationContext(), "Successfully registered!", Toast.LENGTH_SHORT).show();
                userDao.register(user);
                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Account already exists!", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Some fields are missing!", Toast.LENGTH_SHORT).show();
        }
    }
}