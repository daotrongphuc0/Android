package com.example.sqllearning;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class UpdateDeleteActivity extends AppCompatActivity  implements View.OnClickListener {
    private Spinner sp;
    private EditText eTitle, ePrice, eDate;
    private Button btUpdate, btBack,btRemove;
    private Item item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initView();
        btUpdate.setOnClickListener(this);
        btBack.setOnClickListener(this);
        eDate.setOnClickListener(this);
        btRemove.setOnClickListener(this);
        Intent intent = getIntent();
        item = (Item) intent.getSerializableExtra("item");
        eTitle.setText(item.getTitle());
        ePrice.setText(item.getPrice());
        eDate.setText(item.getDate());
        int p = 0;
        for (int i =0 ;i<sp.getCount();i++){
            if(sp.getItemAtPosition(i).toString().equals(item.getCategory())){
                p = i;
                break;
            }

        }
        sp.setSelection(p);
    }

    private void initView() {
        sp = findViewById(R.id.spCategory);
        eTitle = findViewById(R.id.tvTitle);
        ePrice = findViewById(R.id.tvPrice);
        eDate = findViewById(R.id.tvDate);
        btUpdate = findViewById(R.id.btUpdate);
        btRemove = findViewById(R.id.btRemove);
        btBack = findViewById(R.id.btBack);
        sp.setAdapter(new ArrayAdapter<String>(this,R.layout.item_spiner,
                getResources().getStringArray(R.array.category)));
    }

    @Override
    public void onClick(View v) {
        SQLiteHelper db = new SQLiteHelper(this);
        if(v == eDate){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(UpdateDeleteActivity.this, new DatePickerDialog.OnDateSetListener() {
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
        if (v == btBack){
            finish();
        }
        if (v == btUpdate){
            String t = eTitle.getText().toString();
            String c = sp.getSelectedItem().toString();
            String p = ePrice.getText().toString();
            String d = eDate.getText().toString();
            if(!t.isEmpty()&& p.matches("\\d+")){

                Item  i = new Item(item.getId(),t,c,p,d);
                db.update(i);
                finish();
            }
        }
        if(v==btRemove){
            int id = item.getId();
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Ban co muon xoa "+ item.getTitle() + " khong ?");
            builder.setIcon(R.drawable.remove_24);
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    db.delete(id);
                    finish();
                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}