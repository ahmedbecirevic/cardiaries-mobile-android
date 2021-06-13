package com.androidapp.cardiaries;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class PersonFragment extends Fragment {
    private Button logOutButton;
    private Context context;
//    private static EditText email;
//    private static EditText password;
//    private TextView username;
//    private static EditText numOfPosts;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        return inflater.inflate(R.layout.fragment_person, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        email = view.findViewById(R.id.profile_email);
//        password = view.findViewById(R.id.profile_password);
//        username = view.findViewById(R.id.profile_username);
//        numOfPosts = view.findViewById(R.id.number_of_posts);
//        List<User> users = CarDiariesDatabase.getCarDiariesDatabase(context).userDao().getUser(Login.getUserId());
//        User user = users.get(0);
//        username.setText(user.getUsername());
//        email.setText(user.getEmail());
//        password.setText(user.getPassword());

//        numOfPosts.setText(String.valueOf(CarDiariesDatabase.getCarDiariesDatabase(context).postDao().getNumberOfPosts()));
        logOutButton = view.findViewById(R.id.log_out_button);
        logOutButton.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        });
    }

//    public static EditText getEmail() {
//        return email;
//    }
//
//    public static void setEmail(EditText email) {
//        PersonFragment.email = email;
//    }
//
//    public static EditText getPassword() {
//        return password;
//    }
//
//    public static void setPassword(EditText password) {
//        PersonFragment.password = password;
//    }
//
//    public static EditText getUsername() {
//        return username;
//    }
//
//    public static void setUsername(EditText username) {
//        PersonFragment.username = username;
//    }
//
//    public static EditText getNumOfPosts() {
//        return numOfPosts;
//    }
//
//    public static void setNumOfPosts(EditText numOfPosts) {
//        PersonFragment.numOfPosts = numOfPosts;
//    }
}