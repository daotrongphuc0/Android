package com.example.bottomnavi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnavi.R;
import com.example.bottomnavi.adapter.MessageAdapter;
import com.example.bottomnavi.model.Message;

import java.util.ArrayList;
import java.util.List;

public class FragmentNotification extends Fragment {
    MessageAdapter messageAdapter;
    RecyclerView recyclerView;
    List<Message> list;

    public FragmentNotification() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view = inflater.inflate(R.layout.fragment_noti ,container,false);
        list =  new ArrayList<>();
        list.add(new Message(R.drawable.ic_cat,"Phuc","hello","16:20"));
        list.add(new Message(R.drawable.ic_b,"Bao","Em an com chua","13:20"));
        list.add(new Message(R.drawable.ic_cat,"Thao","Em an com chua","12:20"));
        list.add(new Message(R.drawable.ic_b,"Hung","Em an com chua","16:20"));
        list.add(new Message(R.drawable.ic_cat,"Viet","Em an com chua","5:20"));
        list.add(new Message(R.drawable.ic_cat,"Quan","Em an com chua","7:20"));
        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        messageAdapter= new MessageAdapter(view.getContext(),list);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(messageAdapter);
        return view;


    }
}
