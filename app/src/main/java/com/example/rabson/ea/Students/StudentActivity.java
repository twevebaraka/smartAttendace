package com.example.rabson.ea.Students;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rabson.ea.MainActivity;
import com.example.rabson.ea.R;

public class StudentActivity extends AppCompatActivity {

    ListView listView;
    TextView tv_form;
    ArrayAdapter<String> adapter;

    String[] classStudents = {"Jackline Sylvester",
            "Jack Vester","Line Lester",
            "Jumol Mester","Rambo Von",
            "Dabby Don","Raphael Kalongo",
            "Hamadi Kizigo","Jackline Sylvester",
            "Mwl.Vanessa Mdee","Shaaban Ally",
            "Ngawaje Bungaya","Jafari Mpili",
            "Happy Nation","Chill Mix",
            "Mbaga","Salome Daimondo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Wanafunzi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_form = (TextView) findViewById(R.id.tv_form);

        listView = (ListView) findViewById(R.id.lv_student);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,classStudents);
        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(StudentActivity.this,StudentRegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

}
