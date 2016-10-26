package com.example.rabson.ea.AcademicYear;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.rabson.ea.Attendance.RecyclerView.Student;
import com.example.rabson.ea.Attendance.morningAdapter;
import com.example.rabson.ea.ClassTeacherDash.ClassTeacherActivity;
import com.example.rabson.ea.HomeActivity;
import com.example.rabson.ea.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import helpers.AppController;
import helpers.Config;

public class SetAcademicYearActivity extends AppCompatActivity implements View.OnClickListener {
    EditText et_from, et_to, et_fTerm_start, et_fTerm_end, et_mdTerm_holiday_start, et_mdTerm_holiday_end,
            et_longHoliday_start, et_longHoliday_end, et_secondTerm_start, et_secondTerm_end,
            et_secondMidTermHoliday_start, et_secondMidTermHoliday_end, et_secondMidTermLongHoliday_start,
            et_secondMidTermLongHoliday_end;
    Button bn_save;
    ImageView iv_academic_start_calendar, iv_academic_end_calendar, iv_fTerm_start_calendar, iv_fTerm_end_calendar,
            iv_mdTerm_holiday_start_calendar, iv_mdTerm_holiday_end_calendar, iv_longHoliday_start_calendar,
            iv_longHoliday_end_calendar, iv_secondTerm_start_calendar, iv_secondTerm_end_calendar,
            iv_secondMidTermHoliday_start_calendar, iv_secondMidTermHoliday_end_calendar,
            iv_secondMidTermLongHoliday_start_calendar, iv_secondMidTermLongHoliday_end_calendar;

    int year_y, month_y, day_y;
    static final int DIALOG_ID = 0;
    private DatePickerDialog start,end,ftermStart,ftermEnd,mtermStart,mtermEnd,longStart,longEnd;
    private String year2,month2,day2;

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
        getCalender();
        bn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"SUCCESSFULLY SAVED",Toast.LENGTH_LONG).show();
            }
        });
        getTime();
//        this.showDialogOnClick();
        //finish();

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
        iv_academic_start_calendar.setOnClickListener(this);
        iv_academic_end_calendar.setOnClickListener(this);
           bn_save = (Button) findViewById(R.id.bn_save);
    }

//    public void showDialogOnClick() {
//        iv_academic_start_calendar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                showDialog(DIALOG_ID);
//
//            }
//        });
//    }


//    @Override
//    protected Dialog onCreateDialog(int id) {
//        if (id == DIALOG_ID)
//            return new DatePickerDialog(this, datePickerListener, year_y, month_y, day_y);
//        return null;
//    }
//
//    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
//        @Override
//        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//            year_y = year;
//            month_y = monthOfYear + 1;
//            day_y = dayOfMonth;
//            et_from.setText(day_y + "/" + month_y + "/" + year_y);
//        }
//    };



//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.muhula);
//        findViewByID();
//        sendMuhula1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                sendMuhula();
//            }
//        });
//        getCalender();
//        getTime();
//    }
    public static String getTime(){
        Calendar calTime=Calendar.getInstance();
        SimpleDateFormat simpleTime=new SimpleDateFormat("hh:mm:ss");
        String currentTime=simpleTime.format(calTime.getTime());
        Log.e("MYTIME:", currentTime);
        return currentTime;
    }
    public  void getCalender(){
        final SimpleDateFormat simpleCalendar=new SimpleDateFormat("dd-mm-yyy", Locale.US);
        final Calendar calendar=Calendar.getInstance();
        start=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                 year2=String.valueOf(year);
                month2=String.valueOf(month+1);
                day2=String.valueOf(day);
                Log.e("Today",simpleCalendar.format(calendar.getTime()));
                et_from.setText(day2+ "/"+  month2+ " /"+  year2);
            }
        }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        end=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                String year3=String.valueOf(year);
                String month3=String.valueOf(month+1);
                String day3=String.valueOf(day);
                Log.e("Today",simpleCalendar.format(calendar.getTime()));
                et_to.setText(day3+"/"+ month3+" /"+ year3);
            }
        },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Override
    public void onClick(View view) {
        if (view== iv_academic_start_calendar ){

            Toast.makeText(getApplicationContext(),"SUCCESSFULLY SAVED",Toast.LENGTH_LONG).show();
         //start.show();
        }
        else if (view== iv_academic_start_calendar){

            Toast.makeText(getApplicationContext(),"SUCCESSFULLY SAVED",Toast.LENGTH_LONG).show();
           //end.show();
        }

    }
//    public void findViewByID(){
//        fromDateEtxt = (EditText) findViewById(R.id.bn_start);
//        fromDateEtxt.setInputType(InputType.TYPE_NULL);
//         sendMuhula1= (Button) findViewById(R.id.sendMuhula);
//        toDateEtxt = (EditText) findViewById(R.id.bn_end);
//        toDateEtxt.setInputType(InputType.TYPE_NULL);
//        fromDateEtxt.setOnClickListener(this);
//        toDateEtxt.setOnClickListener(this);
//
//    }


    // sending muhula
//    public void sendMuhula(){
//        String url_muhula="http://foodly.pe.hu/hype/test.php";
//        StringRequest stringRequest=new StringRequest(Request.Method.POST, url_muhula,new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                Log.e("success",response);
//                Toast.makeText(getApplication(),"Successfully!!",Toast.LENGTH_LONG).show();
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("network error","down");
//                Toast.makeText(getApplication(),"Failed!!!",Toast.LENGTH_LONG).show();
//
//
//            }
//        }){
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                HashMap<String,String> data=new HashMap<String, String>();
//                data.put("from",fromDateEtxt.getText().toString());
//                data.put("toDate",toDateEtxt.getText().toString());
//                return data;
//            }
//        };
//        AppController.getmInstance().addToRequestQue(stringRequest);
//    }
//
//    void showMuhula(){
//        String url_muhula="http://foodly.pe.hu/hype/getmuhula.php";
//        final JsonArrayRequest jsonArray=new JsonArrayRequest(url_muhula, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                Log.e("Muhula",response.toString());
//                for (int i=0; i<response.length(); i++){
//                    try {
//                        JSONObject jsonObj=response.getJSONObject(i);
//                        String startDate=jsonObj.getString("start_Date");
//                        String endDate=jsonObj.getString("end_Date");
//
//                        Log.e("start",startDate);
//                        Log.e("end",endDate);
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                     }
//
//        },new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.e("no data","no ");
//            }
//        });
//
//        AppController.getmInstance().addToRequestQue(jsonArray);
//}
}
//
