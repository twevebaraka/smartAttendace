package com.example.rabson.ea.StudentProgress;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.rabson.ea.HomeReycler.ItemClickListener;
import com.example.rabson.ea.R;

/**
 * Created by Rabson on 10/13/2016.
 */
public class ProgressAdapter extends RecyclerView.Adapter<ProgressViewHolder> {

    final Context c;
    int[] studentImage;
    String[] studentName;

    public ProgressAdapter(Context ctx,int[] studentImage,String[] studentName ) {
        this.c = ctx;
        this.studentImage = studentImage;
        this.studentName = studentName;
    }

    @Override
    public ProgressViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_row_layout,null);
        ProgressViewHolder holder = new ProgressViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProgressViewHolder holder, int position) {
        holder.image.setImageResource(studentImage[position]);
        holder.name.setText(studentName[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                }
        });

    }

    @Override
    public int getItemCount() {
        return studentName.length;
    }

}
