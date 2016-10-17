package com.example.rabson.ea.ListViewHandler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabson.ea.R;
import com.example.rabson.ea.TeacherDummyData.Teacher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Rabson on 10/6/2016.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    List<Teacher> teachers= Collections.emptyList();
    LayoutInflater inflater;

    public CustomAdapter(Context c, List<Teacher> teachers) {
        this.c = c;
        this.teachers = teachers;
        inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return teachers.size();
    }

    @Override
    public Object getItem(int position) {
        return teachers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_layout, parent, false);
        }

        ImageView teacherImage = (ImageView) convertView.findViewById(R.id.iv_image);
        TextView teacherName = (TextView) convertView.findViewById(R.id.tv_tName);
            Teacher myteacher =teachers.get(position);
                  teacherName.setText(myteacher.getTeacherName());




//
//       // final int image = teachers.get(position).getImage();
//        final String name = teachers.get(position).getTeacherName();

        //binding the data
        //teacherImage.setImageResource(image);
//        teacherName.setText(name);
        return convertView;
    }

//    //opening the basic landing activity and passing data
//    private void openMainActivity(int image,String name){
//        Intent i = new Intent(c, MainActivity.class);
//        //packing our data
//        i.putExtra("TEACHER_IMAGE",image);
//        i.putExtra("TEACHER_NAME",name);
//
//        //open our new activity
//        c.startActivity(i);
//
//    }

}
