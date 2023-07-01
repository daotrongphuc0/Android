package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.model.Technology;
import com.example.myapplication.model.TechnologyAdapter;

public class Technology_listview extends AppCompatActivity {
    private ListView listView;
    TechnologyAdapter adapter;
    private Technology[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        listView = findViewById(R.id.lView_listview);
        initdata();
        adapter = new TechnologyAdapter(this,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j=0;j<listView.getAdapter().getCount();j++){
                    listView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);
                }
                listView.getChildAt(i).setBackgroundColor(Color.GREEN);
                Technology t =adapter.getItem(i);
                Toast.makeText(getApplicationContext(),t.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initdata() {
        Integer[] imgs= {R.drawable.android_icon,R.drawable.ios_icon,
                                R.drawable.java_icon,R.drawable.py_icon};
        String[] names={"Android","Ios","java","Python"};
        String[] subs={"SUB Android","SUB Ios","SUB java","SUB Python"};
        String[] dess={"MT Android","MT Ios","MT java","MT Python"};
        list= new Technology[imgs.length];
        for (int i=0;i<list.length;i++){
            list[i] = new Technology(imgs[i],names[i],subs[i],dess[i]);
        }
    }

}