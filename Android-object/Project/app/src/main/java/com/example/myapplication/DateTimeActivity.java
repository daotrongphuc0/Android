package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et,ed;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);
        et=findViewById(R.id.eTime);
        ed= findViewById(R.id.eDate);
        et.setOnClickListener(this);
        ed.setOnClickListener(this);
        tv= findViewById(R.id.tv);
        registerForContextMenu(tv); // gắn menu ngữ cảnh vào tv
    }

    @Override
    public void onClick(View view) {
        if(view==et){
            Calendar c=Calendar.getInstance();
            int hh = c.get(Calendar.HOUR_OF_DAY);
            int mm = c.get(Calendar.MINUTE);
            TimePickerDialog timedialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int h, int m) {
                    et.setText(h+":"+m);
                }
            },hh,mm,false);
            timedialog.show();
        }
        if(view==ed){
            Calendar c = Calendar.getInstance();
            int y = c.get(Calendar.YEAR);
            int m = c.get(Calendar.MONTH);
            int d = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog Datedialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int yy, int mm, int dd) {
                    ed.setText(dd+"/"+(mm+1)+"/"+yy );
                }
            },y,m,d);
            Datedialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);  // gắn menu vào layout
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mFile:
                Toast.makeText(this,"File",Toast.LENGTH_LONG).show();
                break;
            case R.id.mExit:
                System.exit(0);
                break;
            case R.id.mEmail:
                Toast.makeText(this,"Mail",Toast.LENGTH_LONG).show();
                break;
            case R.id.mPhone:
                Toast.makeText(this,"Phone",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.color_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mRed:
                tv.setTextColor(Color.RED);
                break;
            case R.id.mBlue:
                tv.setTextColor(Color.BLUE);
                break;
            case R.id.mGreen:
                tv.setTextColor(Color.GREEN);
                break;

        }
        return super.onContextItemSelected(item);
    }
}