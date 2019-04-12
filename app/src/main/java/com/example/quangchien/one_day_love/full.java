package com.example.quangchien.one_day_love;
import android.support.v4.app.Fragment;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.ViewFlipper;

import com.example.quangchien.one_day_love.Fragment.HomeFragment;
import com.example.quangchien.one_day_love.Fragment.InfoFragment;
import com.example.quangchien.one_day_love.Fragment.MessengerFragment;
import com.example.quangchien.one_day_love.Fragment.SeachFragment;

public class full extends AppCompatActivity {
    ViewFlipper viewFlipper;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);

        anhxa();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navList);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
    }

    private void anhxa() {
        viewFlipper = (ViewFlipper) findViewById(R.id.viewfp);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_info);
    }


    private  BottomNavigationView.OnNavigationItemSelectedListener navList = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectd =null;
                switch (item.getItemId()){
                    case R.id.nv_home:
                        selectd = new HomeFragment();
                    break;

                    case R.id.nv_ms:
                        selectd = new MessengerFragment();
                        break;
                    case R.id.nv_seach:
                        selectd = new SeachFragment();
                        break;
                    case R.id.nv_info:
                        selectd = new InfoFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,selectd).commit();
                return true;
            }
        };






}
