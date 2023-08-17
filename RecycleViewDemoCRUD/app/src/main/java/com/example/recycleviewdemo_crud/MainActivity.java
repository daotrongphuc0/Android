package com.example.recycleviewdemo_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.recycleviewdemo_crud.model.Cat;
import com.example.recycleviewdemo_crud.model.CatAdapter;
import com.example.recycleviewdemo_crud.model.SpinerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener,
                                SearchView.OnQueryTextListener{
    private Spinner sp;
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private EditText eName,eDes,ePrice;
    private Button btAdd,btUdate;
    private SearchView searchView;
    private int posiCurr;
    private int[] imgs= {R.drawable.cat1,R.drawable.cat2,R.drawable.cat3,R.drawable.cat4,
            R.drawable.cat5,R.drawable.cat6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        adapter = new CatAdapter(this);
        LinearLayoutManager manager =  new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
        searchView.setOnQueryTextListener(this);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String desc = eDes.getText().toString();
                String p = ePrice.getText().toString();
                int img  = R.drawable.cat1;
                double price=0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price= Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDes(desc);
                    cat.setPrice(price);
                    adapter.add(cat);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhập lại",Toast.LENGTH_SHORT).show();
                }

            }
        });

        btUdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cat cat = new Cat();
                String i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String desc = eDes.getText().toString();
                String p = ePrice.getText().toString();
                int img  = R.drawable.cat1;
                double price=0;
                try {
                    img = imgs[Integer.parseInt(i)];
                    price= Double.parseDouble(p);
                    cat.setImg(img);
                    cat.setName(name);
                    cat.setDes(desc);
                    cat.setPrice(price);
                    adapter.update(posiCurr,cat);
                    btAdd.setEnabled(true);
                    btUdate.setEnabled(false);
                }catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Nhập lại",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void initView() {
        sp=findViewById(R.id.img);
        SpinnerAdapter adapter = new SpinerAdapter(this);
        sp.setAdapter(adapter);
        recyclerView = findViewById(R.id.recycleView);
        eName = findViewById(R.id.name);
        eDes = findViewById(R.id.des);
        ePrice = findViewById(R.id.price);
        btAdd =findViewById(R.id.btAdd);
        btUdate = findViewById(R.id.btUpdate);
        btUdate.setEnabled(false);
        searchView= findViewById(R.id.search);
    }

    @Override
    public void onItemClick(View view, int position) {
        btAdd.setEnabled(false);
        btUdate.setEnabled(true);
        posiCurr=position;
        Cat cat =adapter.getItem(position);
        int img = cat.getImg();
        int p =0;
        for (int i =0;i<imgs.length;i++){
            if(img==imgs[i]){
                p=i;
                break;
            }
        }
        sp.setSelection(p);
        eName.setText(cat.getName());
        eDes.setText(cat.getDes());
        ePrice.setText(cat.getPrice()+"");
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }

    private void filter(String s) {
        List<Cat> filterList = new ArrayList<>();
        for (Cat i:adapter.getBackup()){
            if(i.getName().toLowerCase().contains(s.toLowerCase())){
                filterList.add(i);
            }
        }
        if(filterList.isEmpty()){
            Toast.makeText(this,"No data found",Toast.LENGTH_SHORT).show();
        }else {
            adapter.filterList(filterList);
        }
    }
}