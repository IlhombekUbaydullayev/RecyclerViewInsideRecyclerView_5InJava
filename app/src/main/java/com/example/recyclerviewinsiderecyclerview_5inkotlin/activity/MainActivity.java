package com.example.recyclerviewinsiderecyclerview_5inkotlin.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.recyclerviewinsiderecyclerview_5inkotlin.R;
import com.example.recyclerviewinsiderecyclerview_5inkotlin.adapter.CustomAdapter;
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.Member;
import com.example.recyclerviewinsiderecyclerview_5inkotlin.model.MemberSub;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        members.add(new Member());
        for (int i = 0 ; i < 30 ; i++ ) {
            if (i==1||i==10||i==16) {
                members.add(new Member("Ilhombek" + i,"Ubaydullayev" + i , prepareSubMembers()));
            }
            else {
                members.add(new Member("Ilhombek" + i,"Ubaydullayev" + i, null));
            }
        }
        members.add(new Member());
        return members;
    }

    private List<MemberSub> prepareSubMembers() {
        List<MemberSub> members = new ArrayList<>();
        for (int i = 0 ; i < 5 ; i++ ) {
            members.add(new MemberSub());
        }
        return members;
    }

}