package com.example.recycleviewdemo_crud.Intent_forresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.recycleviewdemo_crud.R;

public class register_Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvUser,tvpass ;
    private Button btCancel,btRegis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        btCancel.setOnClickListener(this);
        btRegis.setOnClickListener(this);
    }
    private void init(){
        tvUser =findViewById(R.id.username);
        tvpass = findViewById(R.id.password);
        btCancel = findViewById(R.id.btCancel);
        btRegis = findViewById(R.id.btRegis);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btRegis:
                Account ac = new Account(tvUser.getText().toString().trim(),tvpass.getText().toString().trim());
                Intent intent = new Intent();
                intent.putExtra("data",ac);
                setResult(RESULT_OK,intent);
                finish();
                break;

            case R.id.btCancel:
                setResult(RESULT_CANCELED,null);
                finish();
                break;
        }
    }
}