package com.androidapp.cardiaries;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class Home extends AppCompatActivity {
    public static final String POST_ID = "Home/POST_ID";
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        viewPager = findViewById(R.id.fragment_container);

//        listView = findViewById(R.id.list_view_container);

        setUpAdapter(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
//        setUpListAdapter();
    }

    private void setUpAdapter (ViewPager viewPager) {
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPageAdapter.addFragments(new HomeFragment());
        viewPageAdapter.addFragments(new MapViewFragment());
        viewPageAdapter.addFragments(new PersonFragment());
        viewPager.setAdapter(viewPageAdapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.d("DEBUG", "Item clicked" + item.getItemId());
            switch (item.getItemId()) {
                case R.id.nav_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.nav_dashboard:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.nav_person:
                    viewPager.setCurrentItem(2);
                    return true;
                default:
                    return false;
            }
        }
    };

//    private void setUpListAdapter () {
//        List<Post> todos = CarDiariesDatabase.getCarDiariesDatabase(this).postDao().getAll();
//        PostListAdapter adapter = new PostListAdapter(this, todos);
//
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener((parent, view, position, id) -> {
//            long todoId = parent.getItemIdAtPosition(position);
//            Intent intent = new Intent(Home.this, PostDataActivity.class);
//            intent.putExtra(POST_ID, todoId);
//            startActivity(intent);
//        });
//    }
}