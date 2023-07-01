package com.example.myapplication.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.R;

public class TechnologyAdapter extends ArrayAdapter<Technology> {
    private Context context;
    private Technology[] mList;

    public TechnologyAdapter(@NonNull Context context, Technology[] mList) {
        super(context, R.layout.item_tech_listview,mList);
        this.context=context;
        this.mList= mList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.item_tech_listview,null,true);
        ImageView img=view.findViewById(R.id.img);
        TextView tName = view.findViewById(R.id.tname);
        TextView tSub = view.findViewById(R.id.tSub);
        TextView tDes = view.findViewById(R.id.tdescribe);
        Technology t = mList[position];
        img.setImageResource(t.getImg());
        tName.setText(t.getName());
        tSub.setText(t.getSub());
        tDes.setText(t.getDescribe());
        return view;
    }

    public Technology getItem(int posi){
        return mList[posi];
    }
}
