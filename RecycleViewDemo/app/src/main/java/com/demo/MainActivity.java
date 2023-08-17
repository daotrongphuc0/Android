package com.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.demo.model.Cat;
import com.demo.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  CatAdapter.CatItemListener{
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.rview);
        //adapter = new CatAdapter(this,getList()); c1
        adapter = new CatAdapter(getList());
        adapter.setCatItemListener(this);
        GridLayoutManager manager= new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    private List<Cat> getList(){
        List<Cat> list = new ArrayList<>();
        list.add(new Cat(R.drawable.cat1,"Mèo con 1"));
        list.add(new Cat(R.drawable.cat2,"Mèo con 2"));
        list.add(new Cat(R.drawable.cat3,"Mèo con 3"));
        list.add(new Cat(R.drawable.cat4,"Mèo con 4"));
        list.add(new Cat(R.drawable.cat5,"Mèo con 5"));
        list.add(new Cat(R.drawable.cat6,"Mèo con 6"));

        return list;
    }

    @Override
    public void onItemClick(View view, int position) { //c2
        Cat c = getList().get(position);
        Toast.makeText(this,c.getName(),Toast.LENGTH_SHORT).show();
    }
}