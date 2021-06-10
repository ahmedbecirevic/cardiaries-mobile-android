package com.androidapp.cardiaries;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.login_username);
        password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
    }

    public void onLoginClick (View view) {
        int[] userExists = new int[1];
        User user = new User(username.getText().toString(), password.getText().toString());
        if (validate(user)) {
            CarDiariesDatabase database = CarDiariesDatabase.getCarDiariesDatabase(getApplicationContext());
            UserDao userDao = database.userDao();
            userExists[0] = userDao.login(username.getText().toString(), password.getText().toString());
            Log.d("app", userExists[0] + "  " + username.getText().toString());
            if (userExists[0] == 1) {
                Toast.makeText(getApplicationContext(), "Successfully Logged In!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Try logging in again. Check your credentials!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Some fields are missing!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCreateAccount (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private boolean validate (User user) {
        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }
        return true;
    }
}