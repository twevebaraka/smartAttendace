package com.example.rabson.ea.Attendance.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rabson.ea.Attendance.StudentAttendanceActivity;
import com.example.rabson.ea.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     final LayoutInflater inflater;
    private  List<String> studentPresents=new ArrayList<>();
    private  List<String> studentAbsents=new ArrayList<>();
    Context c;
    private List<Student> data= Collections.emptyList();
    public MyRecyclerAdapter(Context c,List<Student> data){
        this.c = c;
        inflater= LayoutInflater.from(c);
        this.data=data;
    }
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_row_layout,parent,false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        final MyHolder myHolder= (MyHolder) holder;
      //  myHolder.cb_present.setOnCheckedChangeListener(null);
        final Student current=data.get(position);
        myHolder.nameTxt.setText(current.getStudent_name());
        myHolder.cb_present.setChecked(true); // whethe the checkbox is selected or not
        myHolder.cb_present.setTag(data.get(position));
        myHolder.cb_present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myHolder.cb_present.isChecked()){
                    studentPresents.add(current.getStudent_name());
                    Toast.makeText(c,"CHECKED"+current.getStudent_name(),Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if (!myHolder.cb_present.isChecked()){
                        studentPresents.remove(current.getStudent_name());
                        studentAbsents.add(current.getStudent_name());
                        Toast.makeText(c,"NOT CHECKED"+current.getStudent_name(),Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
//        myHolder.cb_present.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                data.get(myHolder.getAdapterPosition()).setSelected(isChecked);
//            }
//        });

    }
    public List<String>  getStudents(){
       return studentPresents;
       }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
class MyHolder extends RecyclerView.ViewHolder{
    CheckBox cb_present;
    ImageView img;
    TextView nameTxt;
    // create constructor to get widget reference
    public MyHolder(View itemView){
        super(itemView);
        nameTxt = (TextView) itemView.findViewById(R.id.tv_student_name);
        img = (ImageView) itemView.findViewById(R.id.iv_student_image);
        cb_present= (CheckBox) itemView.findViewById(R.id.cb_present);
    }



}