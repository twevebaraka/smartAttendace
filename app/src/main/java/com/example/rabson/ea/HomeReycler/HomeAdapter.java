package com.example.rabson.ea.HomeReycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rabson.ea.Attendance.StudentAttendanceActivity;
import com.example.rabson.ea.ClassTeacherDash.ClassTeacherActivity;
import com.example.rabson.ea.ListViewHandler.TeacherActivity;
import com.example.rabson.ea.R;
import com.example.rabson.ea.Report.ReportActivity;
import com.example.rabson.ea.StudentProgress.ProgressActivity;
import com.example.rabson.ea.Students.StudentActivity;

/**
 * Created by Rabson on 10/7/2016.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeHolder> {

    final Context c;
    int[] homeLogo;
    String[] homeName;
    private Intent i;

    public HomeAdapter(Context ctx,int[] homeLogo,String[] homeName ) {
        this.c = ctx;
        this.homeLogo = homeLogo;
        this.homeName = homeName;
    }

    @Override
    public HomeHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_card_layout,null);
        HomeHolder holder = new HomeHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeHolder holder, int position) {
        holder.img.setImageResource(homeLogo[position]);
        holder.name.setText(homeName[position]);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position){
                    case 0:
                         i = new Intent(c,TeacherActivity.class);
                        break;
                    case 1:
                        i = new Intent(c,StudentAttendanceActivity.class);
                        break;
                    case 2:
                        i = new Intent(c,ClassTeacherActivity.class);
                        break;
                   case 3:i = new Intent(c, ReportActivity.class);
                       break;
                }

                c.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeName.length;
    }

}
