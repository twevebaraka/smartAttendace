package com.example.rabson.ea.ClassTeacherDash;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabson.ea.HomeReycler.*;
import com.example.rabson.ea.R;

/**
 * Created by Rabson on 10/14/2016.
 */
public class ClassTeacherHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView image;
    TextView name;
    ItemClickListener itemClickListener;

    public ClassTeacherHolder(View itemView){
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.iv_cTeacher_logo);
        name = (TextView) itemView.findViewById(R.id.tv_cTeacher_name);

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
