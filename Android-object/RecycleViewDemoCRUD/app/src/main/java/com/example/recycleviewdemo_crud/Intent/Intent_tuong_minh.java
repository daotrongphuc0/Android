package com.example.recycleviewdemo_crud.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recycleviewdemo_crud.MainActivity;
import com.example.recycleviewdemo_crud.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Intent_tuong_minh extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_tuong_minh);
        bt =findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(Intent_tuong_minh.this,SeconndActivity.class);
                t.putExtra("name", "DTP");
                Student s = new Student(0,"DTP",12);
                t.putExtra("sinhVien",s);
                List<Student> list = new ArrayList<>();
                list.add(s);
                t.putExtra("list",(Serializable) list);
                startActivity(t);
            }
        });
    }
}