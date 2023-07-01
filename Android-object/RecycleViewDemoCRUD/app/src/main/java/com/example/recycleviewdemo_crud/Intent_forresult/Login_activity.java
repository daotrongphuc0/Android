package com.example.recycleviewdemo_crud.Intent_forresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycleviewdemo_crud.R;

public class Login_activity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUser,tvpass ;
    private Button btLogin,btRegis;
    private final static int REQUEST_CODE  = 10000;
    private Account accountUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        btRegis.setOnClickListener(this);
        btLogin.setOnClickListener(this);

    }

    private void init(){
        tvUser =findViewById(R.id.username);
        tvpass = findViewById(R.id.password);
        btLogin = findViewById(R.id.btLogin);
        btRegis = findViewById(R.id.btRegis);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btLogin:
                Intent loginIntent  = new Intent(Login_activity.this,HomeActivity.class);
                Account ac = new Account(tvUser.getText().toString().trim(),tvpass.getText().toString().trim());
                loginIntent.putExtra("account",ac);
                loginIntent.putExtra("user",accountUser);
                startActivity(loginIntent);
                break;
            case R.id.btRegis:
                Intent regisIntent = new Intent(Login_activity.this,register_Activity.class);
                startActivityForResult(regisIntent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if(resultCode ==RESULT_OK){
                if (data ==null){
                    Toast.makeText(this,"Da huy dki",Toast.LENGTH_SHORT).show();
                }
                else {
                    accountUser = (Account) data.getSerializableExtra("data");
                    tvUser.setText(accountUser.getUsername());
                    tvpass.setText(accountUser.getPassword());
                }
            }
        }
    }
}