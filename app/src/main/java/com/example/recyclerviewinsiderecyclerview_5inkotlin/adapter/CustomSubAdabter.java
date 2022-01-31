package com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecyclerview_5inkotlin.R;
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub;

import java.util.List;

public class CustomSubAdabter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<MemberSub> memberSubs;
    public CustomSubAdabter(Context context,List<MemberSub> memberSubs){
        this.context = context;
        this.memberSubs = memberSubs;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view_sub,viewGroup,false);
        return new CustomViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MemberSub memberSub = memberSubs.get(position);
    }

    @Override
    public int getItemCount() {
        return memberSubs.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public CustomViewHolder(View v) {
            super(v);
            view = v;
        }
    }
}
