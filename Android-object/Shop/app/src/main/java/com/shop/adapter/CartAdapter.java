package com.shop.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.R;
import com.shop.model.Shoes;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<Shoes> mShoesList;
    private int totalPrice;
    private TextView tpriceTextView;

    public CartAdapter(List<Shoes> shoesList, TextView priceTextView) {
        mShoesList = shoesList;
        tpriceTextView = priceTextView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Shoes shoes = mShoesList.get(position);

        holder.nameTextView.setText(shoes.getName());
        holder.amountTextView.setText("Số lượng : "+String.valueOf(shoes.getAmount()));
        holder.imageView.setImageResource(shoes.getImage());

        holder.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // remove the item from the list and notify the adapter
                Shoes removedShoes = mShoesList.remove(position);
                int removedQuantity = removedShoes.getQuantity() + removedShoes.getAmount();
                removedShoes.setAmount(0);
                removedShoes.setQuantity(removedQuantity);
                notifyDataSetChanged();
                updateTotalPrice();
            }
        });

        updateTotalPrice();
    }

    @Override
    public int getItemCount() {
        return mShoesList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView nameTextView;
        public TextView amountTextView;
        public Button removeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.c_itemimage);
            nameTextView = itemView.findViewById(R.id.c_itemname);
            amountTextView = itemView.findViewById(R.id.c_itemamount);
            removeButton = itemView.findViewById(R.id.c_bntremove);
        }
    }

    public void updateTotalPrice() {
        totalPrice = 0;
        for (Shoes shoes : mShoesList) {
            totalPrice += shoes.getPrice() * shoes.getAmount();
        }
        tpriceTextView.setText("Tổng giá: $" + String.valueOf(totalPrice));
    }

}

