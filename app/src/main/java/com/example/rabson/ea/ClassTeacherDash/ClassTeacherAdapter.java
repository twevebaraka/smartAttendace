package com.example.rabson.ea.ClassTeacherDash;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rabson.ea.Attendance.StudentAttendanceActivity;
import com.example.rabson.ea.R;
import com.example.rabson.ea.Report.ReportActivity;

/**
 * Created by Rabson on 10/14/2016.
 */
public class ClassTeacherAdapter extends RecyclerView.Adapter<ClassTeacherHolder> {

    final Context c;
    int[] dashImage;
    String[] dashName;
    private Intent i;

    public ClassTeacherAdapter(Context ctx,int[] dashImage,String[] dashName) {
        this.c = ctx;
        this.dashImage = dashImage;
        this.dashName = dashName;
    }

    @Override
    public ClassTeacherHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_teacher_card_layout,null);
        ClassTeacherHolder holder = new ClassTeacherHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ClassTeacherHolder holder, int position) {
        holder.image.setImageResource(dashImage[position]);
        holder.name.setText(dashName[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position){
                    case 0:
                        i = new Intent(c,StudentAttendanceActivity.class);
                        break;
                    case 1:
                        i = new Intent(c,ReportActivity.class);
                        break;
                }

                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dashName.length;
    }

}
