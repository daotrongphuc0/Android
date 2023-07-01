package com.shop.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.shop.R;
import com.shop.adapter.CartAdapter;
import com.shop.model.Shoes;

import java.util.ArrayList;
import java.util.List;

public class FragmentCart extends Fragment  {

    private List<Shoes> mShoesList = null;

    private Shoes shoes;
    private CartAdapter mAdapter;
    private int totalPrice;
    private TextView tpriceTextView;

    ArrayList<Shoes> shoesList = new ArrayList<>();


    public FragmentCart() {
        mShoesList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        Bundle bundle = getArguments();
        if(bundle != null){
            shoes = (Shoes) getArguments().getSerializable("shoes");
            addShoes(shoes);
        }

        tpriceTextView = view.findViewById(R.id.c_tonggia);
        RecyclerView recyclerView = view.findViewById(R.id.viewCart);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CartAdapter(mShoesList,tpriceTextView);
        recyclerView.setAdapter(mAdapter);

        Button bnt_buy = view.findViewById(R.id.btn_buy);
        if(mShoesList != null){
            bnt_buy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Tạo dialog xác nhận mua
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("Xác nhận mua");
                    builder.setMessage("Bạn có muốn tiến hành đặt hàng?");
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // Chuyển sang fragment Order
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("shoes", shoes);

                            BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.navigation);
                            bottomNavigationView.setSelectedItemId(R.id.mOrders);

                            Fragment fragment = new Fragment();
                            fragment.setArguments(bundle);

                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_container,fragment);
                            transaction.addToBackStack(null);
                            transaction.commit();
                        }
                    });
                    builder.setNegativeButton("Không", null);
                    builder.show();
                }
            });
        }

        return view;
    }
    public void addShoes(Shoes shoes) {
        boolean isExisting = false;
        for (int i = 0; i < mShoesList.size(); i++) {
            Shoes existingShoes = mShoesList.get(i);
            if (existingShoes.getName().equals(shoes.getName())) {
                shoes.setAmount(existingShoes.getAmount()+shoes.getAmount());
                mShoesList.set(i,shoes);
                isExisting = true;
                break;
            }
        }
        if (!isExisting) {
            mShoesList.add(shoes);
        }
        if (mAdapter != null) {
            mAdapter.updateTotalPrice();
        }
    }
}