package com.shop.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.R;
import com.shop.model.Shoes;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<Shoes> mShoesList;
    public OrderAdapter(List<Shoes> shoesList) {
        mShoesList = shoesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       final Shoes shoes = mShoesList.get(position);

        holder.itemImageView.setImageResource(R.drawable.ic_bill);
        holder.itemNameTextView.setText(shoes.getName());
        holder.itemAmountTextView.setText("Số lượng : "+String.valueOf(shoes.getAmount()));
        holder.itemPriceTextView.setText(String.valueOf("Thành tiền : "+shoes.getPrice()*shoes.getAmount()));
        holder.purchaseDateTextView.setText("Ngày đặt : 22/04/2023" );
    }

    @Override
    public int getItemCount() {
        return mShoesList != null ? mShoesList.size() : 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemImageView;
        private TextView itemNameTextView;
        private TextView itemAmountTextView;
        private TextView itemPriceTextView;
        private TextView purchaseDateTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            itemImageView = itemView.findViewById(R.id.image1);
            itemNameTextView = itemView.findViewById(R.id.name1);
            itemAmountTextView = itemView.findViewById(R.id.amount1);
            itemPriceTextView = itemView.findViewById(R.id.totalprice1);
            purchaseDateTextView = itemView.findViewById(R.id.totalprice1);
        }
    }
}