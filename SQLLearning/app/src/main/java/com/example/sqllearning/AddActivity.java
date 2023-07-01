package com.example.sqllearning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sqllearning.DAL.SQLiteHelper;
import com.example.sqllearning.model.Item;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner sp;
    private EditText eTitle, ePrice, eDate;
    private Button btUpdate,btCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();
        btUpdate.setOnClickListener(this);
        btCancel.setOnClickListener(this);
        eDate.setOnClickListener(this);
    }

    private void initView() {
        sp = findViewById(R.id.spCategory);
        eTitle = findViewById(R.id.tvTitle);
        ePrice = findViewById(R.id.tvPrice);
        eDate = findViewById(R.id.tvDate);
        btUpdate = findViewById(R.id.btUpdate);
        btCancel = findViewById(R.id.btCancel);
        sp.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spiner,
                getResources().getStringArray(R.array.category)));

    }

    @Override
    public void onClick(View v) {
        if(v == eDate){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(AddActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    String date = "";
                    if(month>8){
                        date = dayOfMonth + "/"+(month+1)+"/"+year;
                    }
                    else {
                        date  = dayOfMonth + "/0"+(month+1)+"/"+year;
                    }
                    eDate.setText(date);
                }
            },year,month,day);
            dialog.show();
        }
        if (v == btCancel){
            finish();
        }
        if (v == btUpdate){
            String t = eTitle.getText().toString();
            String c = sp.getSelectedItem().toString();
            String p = ePrice.getText().toString();
            String d = eDate.getText().toString();
            if(!t.isEmpty()&& p.matches("\\d+")){
                Item  item = new Item(t,c,p,d);
                SQLiteHelper db = new SQLiteHelper(this);
                db.addItem(item);
                finish();
            }
        }

    }
}