package com.example.hanhs.mychatapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hanhs on 4/30/2018.
 */

public class AddAdapter extends RecyclerView.Adapter<AddAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<ModelAddFriend> mList;
    AddAdapter(Context context, ArrayList<ModelAddFriend> list){
        mcontext = context;
        mList = list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.add_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModelAddFriend friend_item = mList.get(position);
        ImageView image = holder.item_image;
        TextView name;

        name = holder.item_name;
        //time = holder.item_check;

        image.setImageResource(friend_item.getImage());
        name.setText(friend_item.getName());
        //time.setText(friend_item.getTime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name;
        public ViewHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.item_image_add);
            item_name = (TextView) itemView.findViewById(R.id.item_name_add);
            //item_check = (TextView) itemView.findViewById(R.id.item_check_add);
        }
    }
}
