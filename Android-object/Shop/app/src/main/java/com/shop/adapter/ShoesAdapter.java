package com.shop.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.shop.R;
import com.shop.fragment.FragmentDetail;
import com.shop.model.Shoes;

import java.util.ArrayList;
import java.util.List;

public class ShoesAdapter extends RecyclerView.Adapter<ShoesAdapter.ShoeViewHolder> implements Filterable {

    private ShoesAdapter shoesAdapter;
    private List<Shoes> mListShoes;
    private List<Shoes> mListShoesOld;
    private Context context;


    public ShoesAdapter(List<Shoes> mListShoes, Context context) {
        this.mListShoes = mListShoes;
        this.mListShoesOld = mListShoes;
        this.context = context;

    }

    @NonNull
    @Override
    public ShoeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shoes,parent,false);
        return new ShoeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoeViewHolder holder, int position) {
        final Shoes shoes = mListShoesOld.get(position);
        if (shoes == null) {
            return;
        }
        holder.image.setImageResource(shoes.getImage());
        holder.name.setText(shoes.getName());
        holder.price.setText("$ "+String.valueOf(shoes.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo fragment mới
                Bundle bundle = new Bundle();
                bundle.putSerializable("shoes", shoes);
                Fragment fragment = new FragmentDetail();
                fragment.setArguments(bundle);

                // Thay thế fragment hiện tại bằng fragment mới
                FragmentManager fragmentManager = ((AppCompatActivity) context).getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frame_container, fragment);
                transaction.addToBackStack(null); // Cho phép quay lại fragment trước đó nếu cần
                transaction.commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        if (mListShoesOld != null){
            return mListShoesOld.size();
        }
        return 0;
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                List<Shoes> list;
                FilterResults filterResults = null;

                if(strSearch.isEmpty()){
                    mListShoesOld = mListShoes;
                }
                else {
                    list = new ArrayList<>();
                    for (Shoes shoes : mListShoes) {
                        if (shoes.getName().toLowerCase().contains(strSearch.toLowerCase())) {
                            list.add(shoes);
                        }
                    }

                    filterResults = new FilterResults();
                    filterResults.values = list;
                    filterResults.count = list.size();

                }
                return  filterResults;

            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.values != null) {
                    mListShoesOld = (List<Shoes>) results.values;
                    notifyDataSetChanged();
                }
            }
        };
    }


    public class ShoeViewHolder extends RecyclerView.ViewHolder{

        private TextView id;
        private TextView name;
        private TextView price;
        private ImageView image;
        private TextView brand;
        private TextView quantity;
        private TextView soldNumber;
        private TextView status;
        private CardView layoutItem;

        public ShoeViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutItem = itemView.findViewById(R.id.layoutItem);
            image = itemView.findViewById(R.id.image1);
            name = itemView.findViewById(R.id.name1);
            price = itemView.findViewById(R.id.price1);
        }
    }
}
