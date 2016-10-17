package com.example.rabson.ea.AcademicYear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.rabson.ea.HomeActivity;
import com.example.rabson.ea.R;

import java.util.ArrayList;

public class AcademicActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] title;
    int[] images = {R.drawable.setting,R.drawable.darasa,R.drawable.progress};
    ArrayList<AcademicData> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Mwaka Wa Masomo");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv = (RecyclerView) findViewById(R.id.rv_academic);
        title = getResources().getStringArray(R.array.academic_titles);

        //adding all the data into academic data array
        int i = 0;
        for(String name:title){
            AcademicData academicData = new AcademicData(images[i],name);
            arrayList.add(academicData);
            i++;
        }

        adapter = new AcademicAdapter(arrayList,this);
        rv.setAdapter(adapter);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false));
    }

}
