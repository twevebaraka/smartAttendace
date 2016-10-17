package com.example.rabson.ea.ClassTeacherDash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.rabson.ea.HomeReycler.HomeAdapter;
import com.example.rabson.ea.R;
public class ClassTeacherActivity extends AppCompatActivity {
    String[] teacherMenuName ={"Mahudhurio","Ripoti"};
    int[] teacherMenuImage ={R.drawable.attendance,R.drawable.report};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CLASS TEACHER DASHBOARD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //referencing our recycler views
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_class_teacher);
        //set its properties
        rv.setLayoutManager(new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false));
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());
        //recycler view adapter
        ClassTeacherAdapter adapter = new ClassTeacherAdapter(this,teacherMenuImage,teacherMenuName);
        rv.setAdapter(adapter);
    }
}
