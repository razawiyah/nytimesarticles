package com.razawiyah.nytimesarticles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.razawiyah.nytimesarticles.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdapter viewPagerAdapter;
    ViewPager2 viewPager2;
    BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        viewPager2 = findViewById(R.id.viewPager);

        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                // the old video uses switch. cannot use switch anymore as th R is not a constant so use if else instead
                if (id == R.id.bottom_home) {
                    viewPager2.setCurrentItem(0);
                } else if (id == R.id.bottom_support) { //most viewed
                    viewPager2.setCurrentItem(1);
                } else if (id == R.id.bottom_download) { //most shared
                    viewPager2.setCurrentItem(2);
                } else if (id == R.id.bottom_search) { //most emailed
                    viewPager2.setCurrentItem(3);
                }

                return false;
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_support).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_download).setChecked(true);
                        break;
                    case 3:
                        bottomNavigationView.getMenu().findItem(R.id.bottom_search).setChecked(true);
                        break;
                }

                super.onPageSelected(position);
            }
        });
    }
}