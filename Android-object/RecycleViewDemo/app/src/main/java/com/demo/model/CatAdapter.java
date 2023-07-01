package com.demo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.demo.R;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{

    // private Context context; c1
    private List<Cat> mList;

    private CatItemListener catItemListener;  //c2

//    public CatAdapter(Context context, List<Cat> mList) {  c1
//        this.context = context;
//        this.mList = mList;
//    }

    public CatAdapter(List<Cat> mList) {
        this.mList = mList;
    }

    public void setCatItemListener(CatItemListener catItemListener) { //c2
        this.catItemListener = catItemListener;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {  // tra ve cai view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position)   {
        Cat cat =mList.get(position);
        if(cat==null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tv.setText(cat.getName());
//        holder.cardView.setOnClickListener(new View.OnClickListener() {   c1
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context.getApplicationContext(),cat.getName(),Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        if(mList!= null) return mList.size();
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tv;
        //private CardView cardView;   c1
        public CatViewHolder(@NonNull View view) {
            super(view);
            img =view.findViewById(R.id.img);
            tv= view.findViewById(R.id.tname);
            view.setOnClickListener(this);
            // cardView=view.findViewById(R.id.cview); c1
        }

        @Override
        public void onClick(View view) {//c2
            if(catItemListener!=null){
                catItemListener.onItemClick(view,getAdapterPosition());
            }
        }
    }

    public interface CatItemListener{    //c2
        public void onItemClick(View view,int position);
    }
}
