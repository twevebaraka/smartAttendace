package com.example.rabson.ea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.rabson.ea.HomeReycler.HomeAdapter;

public class HomeActivity extends AppCompatActivity {

    String[] HomeMenu ={"Walimu","Wanafunzi","Mwaka Wa Masomo","Ripoti"};
    int[] HomeImages ={R.drawable.teacher,R.drawable.student,R.drawable.year,R.drawable.report};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("HOME DASHBOARD");

        //referencing our recycler views
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_home);

        //set its properties
        rv.setLayoutManager(new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false));
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());

        //recycler view adapter
        HomeAdapter adapter = new HomeAdapter(this,HomeImages,HomeMenu);
        rv.setAdapter(adapter);
    }
}
