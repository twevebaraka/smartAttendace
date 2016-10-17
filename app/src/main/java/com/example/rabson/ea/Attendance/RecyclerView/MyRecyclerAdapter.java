package com.example.rabson.ea.Attendance.RecyclerView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rabson.ea.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
     final LayoutInflater inflater;
    Context c;
    private List<String> students_present=Collections.emptyList();
    private List<String> students_absent=Collections.emptyList();
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
        // Get current position of item in RecyclerView to bind data and assign values from list
        final MyHolder myHolder= (MyHolder) holder;
        final Student current=data.get(position);
        myHolder.nameTxt.setText(current.student_name);
        myHolder.cb_present.setChecked(true);
        myHolder.cb_present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (myHolder.cb_present.isChecked()){
                  //  students_present.add(current.id);
                    Toast.makeText(c,current.student_name+" "+"yupo " ,Toast.LENGTH_LONG).show();
                }
                else {
                   // students_absent.add(current.student_name);
                    Toast.makeText(c, current.student_name+ " "+"hayupo", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
    public void  getStudents(){
       for (int i=0; i<students_present.size(); i++){
           String names=students_present.get(i);
           Log.e("give mes",names);
       }
           }
// return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }
}
class MyHolder extends RecyclerView.ViewHolder{
    CheckBox cb_present;
    ImageView img;
    TextView nameTxt;
    ItemClickListener itemClickListener;
    // create constructor to get widget reference
    public MyHolder(View itemView){
        super(itemView);
        nameTxt = (TextView) itemView.findViewById(R.id.tv_student_name);
        img = (ImageView) itemView.findViewById(R.id.iv_student_image);
        cb_present= (CheckBox) itemView.findViewById(R.id.cb_present);
    }



}