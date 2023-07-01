package com.shop.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.R;
import com.shop.adapter.OrderAdapter;
import com.shop.model.Shoes;

import java.util.List;

public class FragmentOrders extends Fragment  {

    Shoes shoes;
    private List<Shoes> mShoesList = null;
    OrderAdapter orderAdapter;
    public FragmentOrders() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_orders, container, false);

        Bundle bundle = getArguments();
        if(bundle != null){
            shoes = (Shoes) getArguments().getSerializable("shoes");
            mShoesList.add(shoes);
        }

        RecyclerView recyclerView = view.findViewById(R.id.viewOrders);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        orderAdapter = new OrderAdapter(mShoesList);
        recyclerView.setAdapter(orderAdapter);

        return view;
    }
}
