package com.example.hanhs.mychatapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FriendsFragment extends Fragment {

    private  RecyclerView recyclerView;
    ArrayList<ModelFriend> friendList;
    public FriendsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friends, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        friendList = new ArrayList<>();
        friendList.add(new ModelFriend(R.drawable.success,"Success","Try hard","4"));
        friendList.add(new ModelFriend(R.drawable.talent,"Talent","Learning","6"));
        friendList.add(new ModelFriend(R.drawable.violet_flower,"Violet Flower","Dreaming","7"));
        friendList.add(new ModelFriend(R.drawable.red_flower,"Red flower","Twinkle","4"));
        friendList.add(new ModelFriend(R.drawable.grow_up,"Grow up","your youth","3"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView.setLayoutManager(rvLayoutManager);

        Friend_Adapter adapter = new Friend_Adapter(this.getActivity(),friendList);

        recyclerView.setAdapter(adapter);
        return view;
    }

}
