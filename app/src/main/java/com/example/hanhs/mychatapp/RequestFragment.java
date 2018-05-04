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
public class RequestFragment extends Fragment {

    private RecyclerView recyclerView_request;
    ArrayList<ModelRequest> requestList;

    public RequestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_request, container, false);
        recyclerView_request = (RecyclerView) view.findViewById(R.id.view_request_fragment);
        requestList = new ArrayList<>();
        requestList.add(new ModelRequest(R.drawable.success,"Success"));
        requestList.add(new ModelRequest(R.drawable.talent,"Talent"));
        requestList.add(new ModelRequest(R.drawable.violet_flower,"7"));
        requestList.add(new ModelRequest(R.drawable.red_flower,"Red flower"));
        requestList.add(new ModelRequest(R.drawable.grow_up,"Grow up"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        RecyclerView.LayoutManager rvLayoutManager = layoutManager;
        recyclerView_request.setLayoutManager(rvLayoutManager);

        RequestAdapter adapter = new RequestAdapter(this.getActivity(),requestList);

        recyclerView_request.setAdapter(adapter);
        return view;
    }

}
