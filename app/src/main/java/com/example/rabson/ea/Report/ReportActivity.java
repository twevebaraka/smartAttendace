package com.example.rabson.ea.Report;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabson.ea.R;

public class ReportActivity extends AppCompatActivity {

    ImageView iv_day_present_logo,iv_day_absent_logo,iv_day_sick_logo;
    CardView cv_daily_report;
    TextView tv_report_date,tv_report_type,tv_day_registered,tv_day_total,tv_day_present,tv_day_total_present,tv_day_total_absent,tv_day_sick,tv_day_total_sick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        iv_day_present_logo = (ImageView) findViewById(R.id.iv_day_present_logo);
        iv_day_absent_logo = (ImageView) findViewById(R.id.iv_day_absent_logo);
        iv_day_sick_logo = (ImageView) findViewById(R.id.iv_day_sick_logo);

        tv_report_date = (TextView) findViewById(R.id.tv_report_date);
        tv_report_type = (TextView) findViewById(R.id.tv_report_type);
        tv_day_registered = (TextView) findViewById(R.id.tv_day_registered);
        tv_day_total = (TextView) findViewById(R.id.tv_day_total);
        tv_day_present = (TextView) findViewById(R.id.tv_day_present);
        tv_day_total_present = (TextView) findViewById(R.id.tv_day_total_present);
        tv_day_total_absent = (TextView) findViewById(R.id.tv_day_total_absent);
        tv_day_sick = (TextView) findViewById(R.id.tv_day_sick);
        tv_day_total_sick = (TextView) findViewById(R.id.tv_day_total_sick);
        cv_daily_report = (CardView) findViewById(R.id.cv_daily_report);
    }
}
