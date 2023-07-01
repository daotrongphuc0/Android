package com.shop;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shop.adapter.ShoesAdapter;
import com.shop.fragment.FragmentCart;
import com.shop.fragment.FragmentHome;
import com.shop.fragment.FragmentOrders;
import com.shop.fragment.FragmentPerson;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private RecyclerView view1;
    private ShoesAdapter shoesAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadHomeFragment();
        toolbar = getSupportActionBar();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        toolbar.setTitle("Shop");

    }

    private void loadHomeFragment() {
        Fragment fragment0;
        fragment0 = new FragmentHome();
        loadFragment(fragment0);
    }

    //Chose bottom navigation
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.mHome:
                    toolbar.setTitle("Shop");
                    fragment = new FragmentHome();
                    loadFragment(fragment);
                    return true;
                case R.id.mCart:
                    toolbar.setTitle("My Cart");
                    fragment = new FragmentCart();
                    loadFragment(fragment);
                    return true;
                case R.id.mOrders:
                    toolbar.setTitle("My Order");
                    fragment = new FragmentOrders();
                    loadFragment(fragment);
                    return true;
                case R.id.mAccout:
                    toolbar.setTitle("My Account");
                    fragment = new FragmentPerson();
                    loadFragment(fragment);
                    return true;
            }
            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}

