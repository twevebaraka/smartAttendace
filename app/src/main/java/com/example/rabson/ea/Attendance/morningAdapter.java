package com.example.rabson.ea.Attendance;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.rabson.ea.Attendance.RecyclerView.Student;
import com.example.rabson.ea.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
public class morningAdapter extends RecyclerView.Adapter<morningAdapter.ViewHolder> {
   private List<Student> stList=Collections.emptyList();
    public morningAdapter(List<Student> students) {
        this.stList=students;
    }
    // Create new views
    @Override
    public morningAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);
        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        viewHolder.chkSelected.setOnCheckedChangeListener(null);
        final int pos = position;
        viewHolder.tvName.setText(stList.get(position).getStudent_name());
        //viewHolder.tvEmailId.setText(stList.get(position).getEmailId());
        viewHolder.chkSelected.setChecked(stList.get(position).isSetselected());
        // viewHolder.chkSelected.setChecked(true);
        viewHolder.chkSelected.setTag(stList.get(position));
        viewHolder.chkSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                stList.get(viewHolder.getAdapterPosition()).setSelected(isChecked);
            }
        });
 }
    // Return the size arraylist
    @Override
    public int getItemCount() {
        return stList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvEmailId;
        public CheckBox chkSelected;
        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvName = (TextView) itemLayoutView.findViewById(R.id.tv_student_name);
         //   tvEmailId = (TextView) itemLayoutView.findViewById(R.id.tvEmailId);
            chkSelected = (CheckBox) itemLayoutView
                    .findViewById(R.id.cb_present);
        }
    }
    // method to access in activity after updating selection
    public List<Student> getStudentist() {
        return stList;
    }
}
