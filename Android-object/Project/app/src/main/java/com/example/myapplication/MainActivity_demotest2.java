package com.example.myapplication;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity_demotest2 extends AppCompatActivity {


    private Spinner sp,sp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_test2);
        sp = findViewById(R.id.sp2);
        sp1 = findViewById(R.id.sp1);
        String[] list = {"PTIT","HUST","NEU","FTU"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.text, list);
        sp.setAdapter(adapter);

        String[] list1 = getResources().getStringArray(R.array.country);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this,R.layout.text,list1);
        sp1.setAdapter(adapter1);
    }


}