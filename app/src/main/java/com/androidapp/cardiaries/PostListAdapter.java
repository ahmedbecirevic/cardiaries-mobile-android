package com.androidapp.cardiaries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PostListAdapter extends BaseAdapter {
    private Context context;
    private List<Post> postList;

    public PostListAdapter(Context context, List<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    @Override
    public int getCount() {
        return postList.size();
    }

    @Override
    public Object getItem(int position) {
        return postList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return postList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.post_list_item, parent, false);

        Post post = postList.get(position);
        TextView carTitle = convertView.findViewById(R.id.car_title_in_list);
        TextView description = convertView.findViewById(R.id.description_in_list);

        carTitle.setText(post.getCarName());
        description.setText(post.getDescription());

        return convertView;
    }
}
