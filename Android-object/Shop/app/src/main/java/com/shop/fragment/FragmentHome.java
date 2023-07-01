package com.shop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.R;
import com.shop.adapter.ShoesAdapter;
import com.shop.model.Shoes;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment  {
    ShoesAdapter shoesAdapter;
    RecyclerView recyclerView;
    SearchView searchView;
    public FragmentHome() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container,false);

        searchView = view.findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                shoesAdapter.getFilter().filter(query);
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                shoesAdapter.getFilter().filter(newText);
                return false;
            }
        });


        recyclerView  = view.findViewById(R.id.viewHome);
        RecyclerView.LayoutManager manager = new GridLayoutManager(view.getContext(),2);
        shoesAdapter = new ShoesAdapter(getListShoes(), getContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(shoesAdapter);
        return view;
    }


    private List<Shoes> getListShoes() {
        List<Shoes> list = new ArrayList<>();
        list.add(new Shoes(1,"Giày một",100,R.drawable.g1,"Thể thao",10,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(2,"Giày hai",125,R.drawable.g2,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(3,"Giảy ba",130,R.drawable.g3,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(4,"Giày bốn",110,R.drawable.g4,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(5,"Giày năm",120,R.drawable.g5,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(6,"Giày sáu",122,R.drawable.g6,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(7,"Giày bảy",100,R.drawable.g7,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(8,"Giày tám",100,R.drawable.g8,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(9,"giày chín",130,R.drawable.g9,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        list.add(new Shoes(10,"giày mười",200,R.drawable.g10,"Thể thao",20,"1","Giày thể thao dành cho nam giới",0));
        return list;
    }

}
