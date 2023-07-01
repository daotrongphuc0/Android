package com.example.sqllearning.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqllearning.DAL.SQLiteHelper;
import com.example.sqllearning.R;
import com.example.sqllearning.UpdateDeleteActivity;
import com.example.sqllearning.adapter.RecycleViewAdapter;
import com.example.sqllearning.model.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FragmentHome extends Fragment implements RecycleViewAdapter.ItemListener {
    private RecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private SQLiteHelper db;
    private TextView tvTong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleView);
        tvTong =  view.findViewById(R.id.tvTong);
        adapter =  new RecycleViewAdapter();
        db = new SQLiteHelper(getContext());
        Date  date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("date ------" + format.format(date));
        List<Item> list = db.getByDate(format.format(date));
        System.out.println(list);
        System.out.println("text ----------------");
        adapter.setList(list);
        tvTong.setText("Tong tien:" + tinhTong(list));
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);
        adapter.setItemListener(this);


    }

    private int  tinhTong(List<Item> list){
        int t =0;
        for (Item i:list){
            t += Integer.parseInt(i.getPrice());
        }
        return t;
    }

    @Override
    public void onItemClick(View view, int position) {
        Item item = adapter.getItem(position);
        Intent intent = new Intent(getContext(), UpdateDeleteActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        Date  date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        List<Item> list = db.getByDate(format.format(date));
        adapter.setList(list);
        tvTong.setText("Tong tien:" + tinhTong(list));
    }
}
