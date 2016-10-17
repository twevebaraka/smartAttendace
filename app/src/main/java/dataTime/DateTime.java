package dataTime;

/**
 * Created by Rabson on 10/15/2016.
 */

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.rabson.ea.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTime extends AppCompatActivity implements View.OnClickListener {

        private EditText fromDateEtxt,toDateEtxt;
        private DatePickerDialog fromDate,toDate;


        @Override
        public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
            super.onCreate(savedInstanceState, persistentState);
            //setContentView(R.layout.muhula);
            findViewByID();
            getCalender();
        }

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
            fromDate=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    calendar.set(year,month,day);
                    Log.e("Today",simpleCalendar.format(calendar.getTime()));
                    EditText fromDate=null;
                    fromDate.setText(simpleCalendar.format(calendar.getTime()));
                }
            }, calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
            DatePickerDialog toDate=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    calendar.set(year,month,day);
                }
            },calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
        }

        @Override
        public void onClick(View view) {
            if (view==fromDateEtxt){
                fromDate.show();
            }
            else if (view==toDateEtxt){
                toDate.show();
            }

        }
        public void findViewByID(){
//            fromDateEtxt = (EditText) findViewById(R.id.bn_register);
//            fromDateEtxt.setInputType(InputType.TYPE_NULL);
//            //fromDateEtxt.requestFocus();
//
//            toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
//            toDateEtxt.setInputType(InputType.TYPE_NULL);
        }

    }
