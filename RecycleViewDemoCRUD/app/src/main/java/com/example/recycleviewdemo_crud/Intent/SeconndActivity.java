package com.example.recycleviewdemo_crud.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.recycleviewdemo_crud.R;

public class SeconndActivity extends AppCompatActivity {
    private Button btBack;
    private TextView tvName ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seconnd);
        btBack = findViewById(R.id.btBack);
        tvName =  findViewById(R.id.tvName);
        Intent t = getIntent();
        Student s = (Student) t.getSerializableExtra("sinhVien");
        String s1 = t.getStringExtra("name");
        tvName.setText(s.toString());
//        tvName.setText(t.getIntExtra("name", 30));
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}