package com.example.recycleviewdemo_crud.Intent_forresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.recycleviewdemo_crud.R;

public class HomeActivity extends AppCompatActivity {
    private TextView tv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv = findViewById(R.id.textView2);
        Intent intent = getIntent();
        if(intent.getSerializableExtra("account")!=null&&intent.getSerializableExtra("user")!=null){
            Account ac =  (Account) intent.getSerializableExtra("account");
            Account user =  (Account) intent.getSerializableExtra("user");
            if(ac.getUsername()==user.getUsername() && ac.getPassword()==user.getPassword()){
                tv.setText(ac.getUsername());
            }
            else {
                tv.setText("ERROR");
            }
        }
    }
}