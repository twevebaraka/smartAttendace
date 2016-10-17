package com.example.rabson.ea.Attendance;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.rabson.ea.Attendance.Fragments.EveningFragment;
import com.example.rabson.ea.Attendance.Fragments.MorningFragment;
import com.example.rabson.ea.Attendance.Fragments.MyFragmentPagerAdapter;
import com.example.rabson.ea.R;

public class StudentAttendanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

    }

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
