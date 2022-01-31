package com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewinsiderecyclerview_5inkotlin.R;
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.Member;
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM_VIEW = 0;
    private static final int TYPE_ITEM_List = 1;
    private Context context;
    private List<Member> members;
    public CustomAdapter(Context context,List<Member> members){
        this.context = context;
        this.members = members;
    }

    public int getItemViewType(int position) {
        Member member = members.get(position);

        if (member.getMemberSubs() != null) return TYPE_ITEM_List;
        return TYPE_ITEM_VIEW;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        if (viewType == TYPE_ITEM_List) {
            View header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_list,viewGroup,false);
            return new CustomListHolder(header);
        }
        View footer = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout_view,viewGroup,false);
        return new CustomViewHolder(footer);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
        if (holder instanceof CustomViewHolder) {

        }
        if (holder instanceof CustomListHolder) {
            RecyclerView recyclerView = ((CustomListHolder)holder).recyclerView;
            recyclerView.setLayoutManager(new GridLayoutManager(context,1));
            List<MemberSub> memberSubs = member.getMemberSubs();
            refreshSubAdabter(recyclerView,memberSubs);
        }
    }

    private void refreshSubAdabter(RecyclerView recyclerView,List<MemberSub> memberSubs){
        CustomSubAdabter adapter = new CustomSubAdabter(context,memberSubs);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public CustomViewHolder(View v) {
            super(v);
            view = v;
        }
    }

    private class CustomListHolder extends RecyclerView.ViewHolder {
        public View view;
        public RecyclerView recyclerView;
        public CustomListHolder(View v) {
            super(v);
            view = v;
            recyclerView = view.findViewById(R.id.recyclerView);
        }
    }
}
