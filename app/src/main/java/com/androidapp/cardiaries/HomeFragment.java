package com.androidapp.cardiaries;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.List;

public class HomeFragment extends Fragment {
    public static final String POST_ID = "Home/POST_ID";
    private static ListView listView;
    private Context context;
    private Button addPost;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated (View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = view.findViewById(R.id.list_view_container);
        addPost = view.findViewById(R.id.add_post_button);
        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setUpListAdapter();
    }

    public void setUpListAdapter () {
        Post post = new Post("First post for this app testing", "test1");
        CarDiariesDatabase.getCarDiariesDatabase(context).postDao().makeNewPost(post);
        List<Post> todos = CarDiariesDatabase.getCarDiariesDatabase(context).postDao().getAll();
        PostListAdapter adapter = new PostListAdapter(context, todos);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            long todoId = parent.getItemIdAtPosition(position);
            Intent intent = new Intent(context, PostDataActivity.class);
            intent.putExtra(POST_ID, todoId);
            startActivity(intent);
        });
    }


}
