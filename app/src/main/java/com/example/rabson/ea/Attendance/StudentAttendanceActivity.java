package com.example.rabson.ea.Attendance;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.rabson.ea.Attendance.Fragments.EveningFragment;
import com.example.rabson.ea.Attendance.Fragments.MorningFragment;
import com.example.rabson.ea.Attendance.Fragments.MyFragmentPagerAdapter;
import com.example.rabson.ea.Attendance.RecyclerView.MyRecyclerAdapter;
import com.example.rabson.ea.Attendance.RecyclerView.Student;
import com.example.rabson.ea.R;
import com.example.rabson.ea.Students.StudentRegistrationActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceActivity extends AppCompatActivity {

    private MyRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       List<Student> data=new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_attendance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Attendance");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.attendance_tab);
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
        ViewPager vp = (ViewPager) findViewById(R.id.attendance_viewpager);
        this.addPgaes(vp);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(listener(vp));
        Button sendData= (Button) findViewById(R.id.sendData);

        adapter=new MyRecyclerAdapter(getApplicationContext(),data);


        if (sendData!=null){
            sendData.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    List<String> names=adapter.getStudents();

                    Toast.makeText(getApplicationContext(),"Successfully Saved",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    void presentsStudents(){
        List<String> mystudens= adapter.getStudents();
        for (int i=0; i<mystudens.size(); i++){
            String names= mystudens.get(i); // getting all checked and unchecked values
            Log.e("SingeData",names);
        }
    }

//
//
////        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_add);
////        if (fab != null) {
////            fab.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View view) {
////                    // Click action
////                    Toast.makeText(getApplicationContext(),"Successfully Saved",Toast.LENGTH_SHORT).show();
////                }
////            });
////        }
//
//    }

    public void addPgaes(ViewPager pager){
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        adapter.addPage(new MorningFragment());
        adapter.addPage(new EveningFragment());
        pager.setAdapter(adapter);
    }

    private TabLayout.OnTabSelectedListener listener(final ViewPager pager){
        return new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                 pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        };
    }
}
