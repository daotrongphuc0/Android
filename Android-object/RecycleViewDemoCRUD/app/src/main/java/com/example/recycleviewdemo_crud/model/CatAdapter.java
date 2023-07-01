package com.example.recycleviewdemo_crud.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleviewdemo_crud.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private Context context;
    private List<Cat> mList;

    private List<Cat> listBackup;

    private CatItemListener mCatItem;
    public CatAdapter(Context context){
        this.context =context;
        this.mList = new ArrayList<>();
        this.listBackup = new ArrayList<>();
    }
    public List<Cat> getBackup(){
        return this.listBackup;
    }

    public void setmList(List<Cat> mList) {
        this.mList = mList;
    }

    public void filterList(List<Cat> filterList){
        mList=filterList;
        notifyDataSetChanged();
    }
    public void setClickListener(CatItemListener mCatItem){
        this.mCatItem= mCatItem;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    public Cat getItem(int position){
        return mList.get(position);
    }
    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat =mList.get(position);
        if(cat==null)
            return;
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvDes.setText(cat.getDes());
        holder.tvPrice.setText(cat.getPrice()+"");
        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao");
                builder.setMessage("Bạn có chắc chắn xoá " + cat.getName() + " này không?");
                builder.setIcon(R.drawable.remove);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listBackup.remove(position);
                        mList.remove(position);
                        notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    public void add(Cat cat){
        listBackup.add(cat);
        mList.add(cat);
        notifyDataSetChanged();
    }

    public void update(int positon, Cat cat){
        listBackup.set(positon,cat);
        mList.set(positon,cat);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if(mList!=null)
            return mList.size();
        return 0 ;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvName, tvDes,tvPrice;
        private Button btRemove;
        public CatViewHolder(@NonNull View view) {
            super(view);
            img =view.findViewById(R.id.img);
            tvName = view.findViewById(R.id.txtName);
            tvDes = view.findViewById(R.id.txtDes);
            tvPrice = view.findViewById(R.id.txtPrice);
            btRemove = view.findViewById(R.id.btRemove);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mCatItem!=null){
                mCatItem.onItemClick(view,getAdapterPosition());
            }
        }
    }
    public interface CatItemListener{
        void onItemClick(View view, int position);
    }
}
