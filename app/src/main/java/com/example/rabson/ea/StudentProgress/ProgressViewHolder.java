package com.example.rabson.ea.StudentProgress;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabson.ea.HomeReycler.ItemClickListener;
import com.example.rabson.ea.R;

/**
 * Created by Rabson on 10/13/2016.
 */
public class ProgressViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView image;
    TextView name;
    ItemClickListener itemClickListener;

    public ProgressViewHolder(View itemView){
        super(itemView);
        image = (ImageView) itemView.findViewById(R.id.iv_progress_student_image);
        name = (TextView) itemView.findViewById(R.id.tv_progress_student_name);

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
