package com.example.rabson.ea.AcademicYear;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.rabson.ea.HomeActivity;
import com.example.rabson.ea.R;

import java.util.Calendar;

public class SetAcademicYearActivity extends AppCompatActivity {

    EditText et_from, et_to, et_fTerm_start, et_fTerm_end, et_mdTerm_holiday_start, et_mdTerm_holiday_end, et_longHoliday_start, et_longHoliday_end, et_secondTerm_start, et_secondTerm_end, et_secondMidTermHoliday_start, et_secondMidTermHoliday_end, et_secondMidTermLongHoliday_start, et_secondMidTermLongHoliday_end;
    Button bn_save;
    ImageView iv_academic_start_calendar, iv_academic_end_calendar, iv_fTerm_start_calendar, iv_fTerm_end_calendar, iv_mdTerm_holiday_start_calendar, iv_mdTerm_holiday_end_calendar, iv_longHoliday_start_calendar, iv_longHoliday_end_calendar, iv_secondTerm_start_calendar, iv_secondTerm_end_calendar, iv_secondMidTermHoliday_start_calendar, iv_secondMidTermHoliday_end_calendar, iv_secondMidTermLongHoliday_start_calendar, iv_secondMidTermLongHoliday_end_calendar;
    int year_y, month_y, day_y;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_academic_year);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Academic Year");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(getApplicationContext(), HomeActivity.class);
                startActivity(back);
            }
        });

        initViews();
        showDialogOnClick();
        finish();
        Calendar calendar = Calendar.getInstance();
        year_y = calendar.get(Calendar.YEAR);
        month_y = calendar.get(Calendar.MONTH);
        day_y = calendar.get(Calendar.DAY_OF_MONTH);
    }

    public void initViews() {
        //Initializing calendar
        iv_academic_start_calendar = (ImageView) findViewById(R.id.iv_academic_start_calendar);
        iv_academic_end_calendar = (ImageView) findViewById(R.id.iv_academic_end_calendar);
        iv_fTerm_start_calendar = (ImageView) findViewById(R.id.iv_fTerm_start_calendar);
        iv_fTerm_end_calendar = (ImageView) findViewById(R.id.iv_fTerm_end_calendar);
        iv_mdTerm_holiday_start_calendar = (ImageView) findViewById(R.id.iv_mdTerm_holiday_start_calendar);
        iv_mdTerm_holiday_end_calendar = (ImageView) findViewById(R.id.iv_mdTerm_holiday_end_calendar);
        iv_longHoliday_start_calendar = (ImageView) findViewById(R.id.iv_longHoliday_start_calendar);
        iv_longHoliday_end_calendar = (ImageView) findViewById(R.id.iv_longHoliday_end_calendar);
        iv_secondTerm_start_calendar = (ImageView) findViewById(R.id.iv_secondTerm_start_calendar);
        iv_secondTerm_end_calendar = (ImageView) findViewById(R.id.iv_secondTerm_end_calendar);
        iv_secondMidTermHoliday_start_calendar = (ImageView) findViewById(R.id.iv_secondMidTermHoliday_start_calendar);
        iv_secondMidTermHoliday_end_calendar = (ImageView) findViewById(R.id.iv_secondMidTermHoliday_end_calendar);
        iv_secondMidTermLongHoliday_start_calendar = (ImageView) findViewById(R.id.iv_secondMidTermLongHoliday_start_calendar);
        iv_secondMidTermLongHoliday_end_calendar = (ImageView) findViewById(R.id.iv_secondMidTermLongHoliday_end_calendar);

        et_from = (EditText) findViewById(R.id.et_academic_start);
        et_to = (EditText) findViewById(R.id.et_academic_end);
        et_fTerm_start = (EditText) findViewById(R.id.et_fTerm_start);
        et_fTerm_end = (EditText) findViewById(R.id.et_fTerm_end);
        et_mdTerm_holiday_start = (EditText) findViewById(R.id.et_mdTerm_holiday_start);
        et_mdTerm_holiday_end = (EditText) findViewById(R.id.et_mdTerm_holiday_end);
        et_longHoliday_start = (EditText) findViewById(R.id.et_longHoliday_start);
        et_longHoliday_end = (EditText) findViewById(R.id.et_longHoliday_end);
        et_secondTerm_start = (EditText) findViewById(R.id.et_secondTerm_start);
        et_secondTerm_end = (EditText) findViewById(R.id.et_secondTerm_end);
        et_secondMidTermHoliday_start = (EditText) findViewById(R.id.et_secondMidTermHoliday_start);
        et_secondMidTermHoliday_end = (EditText) findViewById(R.id.et_secondMidTermHoliday_end);
        et_secondMidTermLongHoliday_start = (EditText) findViewById(R.id.et_secondMidTermLongHoliday_start);
        et_secondMidTermLongHoliday_end = (EditText) findViewById(R.id.et_secondMidTermLongHoliday_end);

        bn_save = (Button) findViewById(R.id.bn_save);
    }

    public void showDialogOnClick() {
        iv_academic_start_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_ID)
            return new DatePickerDialog(this, datePickerListener, year_y, month_y, day_y);
            return null;
        }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_y = year;
            month_y = monthOfYear+1;
            day_y = dayOfMonth;
            Toast.makeText(SetAcademicYearActivity.this,year_y+ "/" +month_y +"/"+ day_y,Toast.LENGTH_SHORT).show();
        }
    };

}
