package com.example.rabson.ea.HomeReycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabson.ea.R;

/**
 * Created by Rabson on 10/7/2016.
 */
public class HomeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img;
    TextView name;
    ItemClickListener itemClickListener;

    public HomeHolder(View itemView){
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.iv_logo);
        name = (TextView) itemView.findViewById(R.id.tv_name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic){
        this.itemClickListener = ic;
    }
}
