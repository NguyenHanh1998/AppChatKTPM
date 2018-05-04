package com.example.hanhs.mychatapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    private RecyclerView recyclerView_add;
    ArrayList<ModelAddFriend> addList;

    public AddFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add, container, false);

        recyclerView_add = (RecyclerView) view.findViewById(R.id.view_add_fragment);
        addList = new ArrayList<>();
        addList.add(new ModelAddFriend(R.drawable.success,"Success"));
        addList.add(new ModelAddFriend(R.drawable.talent,"Talent"));
        addList.add(new ModelAddFriend(R.drawable.violet_flower,"7"));
        addList.add(new ModelAddFriend(R.drawable.red_flower,"Red flower"));
        addList.add(new ModelAddFriend(R.drawable.grow_up,"Grow up"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView_add.setLayoutManager(rvLayoutManager);

        AddAdapter adapter = new AddAdapter(this.getActivity(),addList);

        recyclerView_add.setAdapter(adapter);
        return view;
    }

}
