package com.example.myapplication;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class List_view extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView = findViewById(R.id.lView_listview);
        initListView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selection= adapter.getItem(position);
                Toast.makeText(getApplicationContext(),selection,Toast.LENGTH_LONG).show();

            }
        });
    }

    private void initListView() {
        String[] list = getResources().getStringArray(R.array.tech);
        adapter = new ArrayAdapter<>(this,R.layout.item_listview,list);
        listView.setAdapter(adapter);
    }


}