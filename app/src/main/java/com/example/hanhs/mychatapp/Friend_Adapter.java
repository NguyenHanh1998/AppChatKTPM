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
 * Created by Hanhs on 3/26/2018.
 */

public class Friend_Adapter extends RecyclerView.Adapter<Friend_Adapter.ViewHolder> {
    private Context mcontext;
    private ArrayList<ModelFriend> mList;
    Friend_Adapter(Context context, ArrayList<ModelFriend> list){
        mcontext = context;
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(mcontext);
        View view = layoutInflater.inflate(R.layout.friend_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModelFriend friend_item = mList.get(position);
        ImageView image = holder.item_image;
        TextView name,content,time;

        name = holder.item_name;
        content = holder.item_content;
        time = holder.item_time;

        image.setImageResource(friend_item.getImage());
        name.setText(friend_item.getName());
        content.setText(friend_item.getContent());
        time.setText(friend_item.getTime());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView item_image;
        TextView item_name, item_content,item_time;

        public ViewHolder(View itemView) {
            super(itemView);
            item_image = (ImageView) itemView.findViewById(R.id.item_image);
            item_name = (TextView) itemView.findViewById(R.id.item_name);
            item_content = (TextView) itemView.findViewById(R.id.item_content);
            item_time = (TextView) itemView.findViewById(R.id.item_time);
        }
    }
}
