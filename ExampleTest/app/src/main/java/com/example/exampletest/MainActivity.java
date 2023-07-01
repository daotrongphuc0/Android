package com.example.exampletest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button addSv,addClass, dsSv,dsClass,dki;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        addSv =  findViewById(R.id.addSv);
        addClass =  findViewById(R.id.addClass);
        dsSv =  findViewById(R.id.dsSv);
        dsClass =  findViewById(R.id.dsClass);
        dki =  findViewById(R.id.dki);
    }

    @Override
    public void onClick(View v) {
        if(v == addSv){
            Intent intent = new Intent(MainActivity.this,);
        }
    }
}