package com.example.rabson.ea.StudentProgress;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rabson.ea.HomeReycler.HomeAdapter;
import com.example.rabson.ea.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class ProgressActivity extends AppCompatActivity {

    int[] studentImage ={R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar,R.drawable.avatar};
    String[] studentName = {"Jackline Sylvester",
            "Jack Vester","Line Lester",
            "Jumol Mester","Rambo Von",
            "Dabby Don","Raphael Kalongo",
            "Hamadi Kizigo","Jackline Sylvester",
            "Mwl.Vanessa Mdee","Shaaban Ally",
            "Ngawaje Bungaya","Jafari Mpili",
            "Happy Nation","Chill Mix",
            "Mbaga","Salome Daimondo"};
    TextView tv_display_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Student Progress");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tv_display_class = (TextView) findViewById(R.id.tv_display_class)
        ;
        //referencing our recycler views
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv_student_progress);
        //set its properties
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.setItemAnimator(new DefaultItemAnimator());

        //recycler view adapter
        ProgressAdapter adapter = new ProgressAdapter(this, studentImage, studentName);
        rv.setAdapter(adapter);

        showBottomSheet(); //this method has to be called once check box is clicked

    }

        private void showBottomSheet(){

            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this);
            View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
            bottomSheetDialog.setContentView(bottomSheetView);

            LinearLayout bn_continue = (LinearLayout) bottomSheetDialog.findViewById(R.id.bn_continue);
            LinearLayout bn_repeat = (LinearLayout) bottomSheetDialog.findViewById(R.id.bn_repeat);
            LinearLayout bn_drop = (LinearLayout) bottomSheetDialog.findViewById(R.id.bn_drop);

        bn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Anaendelea");
            }
        });

        BottomSheetBehavior behavior = BottomSheetBehavior.from((View) bottomSheetView.getParent());
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == BottomSheetBehavior.STATE_HIDDEN){
                    showToast("Iam hidden");
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        bn_repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Anarudia");
            }
        });

        bn_drop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Ameacha");
            }
        });

            bottomSheetDialog.show();
    }

    private void showToast(String text){
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }

    }

