package com.example.bottomnavi;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import com.example.bottomnavi.adapter.ViewPageAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView navigationView;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =findViewById(R.id.viewPage);
        navigationView= findViewById(R.id.navigation);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager(),4);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: navigationView.getMenu().findItem(R.id.mHome).setCheckable(true);
                        break;
                    case 1: navigationView.getMenu().findItem(R.id.mNoti).setCheckable(true);
                        break;
                    case 2: navigationView.getMenu().findItem(R.id.mSearch).setCheckable(true);
                        break;
                    case 3: navigationView.getMenu().findItem(R.id.mCafe).setCheckable(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.mHome){
                    viewPager.setCurrentItem(0);
                } else if (item.getItemId() == R.id.mNoti) {
                    viewPager.setCurrentItem(1);
                } else if (item.getItemId() == R.id.mSearch) {
                    viewPager.setCurrentItem(2);
                }else{
                    viewPager.setCurrentItem(3);
                }
//                switch (item.getItemId()){
//                    case R.id.mHome:viewPager.setCurrentItem(0);
//                    break;
//                    case R.id.mNoti:viewPager.setCurrentItem(1);
//                        break;
//                    case R.id.mSearch:viewPager.setCurrentItem(2);
//                        break;
//                    case R.id.mCafe:viewPager.setCurrentItem(3);
//                        break;
//                }

                return true;
            }
        });

    }
}