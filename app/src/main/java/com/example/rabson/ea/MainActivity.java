package com.example.rabson.ea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.rabson.ea.MasterLogin.LoginActivity;

import java.util.HashMap;
import java.util.Map;

import helpers.AppController;
import helpers.Config;
import helpers.prefManager;

public class MainActivity extends AppCompatActivity {

    EditText etFname,etSname,etMname,etPhone;
    Button register;
    String FirstName,Surname,MiddleName,Phone;
    ImageView bn_upload;
    private String tech_name,tech_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i=getIntent();
        String tech_name=i.getStringExtra("name");
        tech_id=i.getStringExtra("id");
        EditText text= (EditText) findViewById(R.id.test);
        if(text != null){
            Toast.makeText(getApplicationContext(),"yes"+tech_name,Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }

        //etSname.setText(tech_id);
        Log.e("Nuller",tech_name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Mwalimu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        initViews();
//        //register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                captureData();
//            }
//        });

    }

    public void initViews(){
////        etFname = (EditText) findViewById(R.id.et_fname);
////        etSname = (EditText) findViewById(R.id.tv_sname);
////        etMname = (EditText) findViewById(R.id.tv_mname);
////        etPhone = (EditText) findViewById(R.id.tv_phone);
////        register = (Button) findViewById(R.id.bn_register);
////        bn_upload = (ImageView) findViewById(R.id.bn_upload_image);
//    }
//
//    public void captureData(){
//                 // test setting names
//                 etFname.setText(tech_name);
//                 etSname.setText(tech_id);
//                 tech_name= etFname.getText().toString();
//                 tech_id= etSname.getText().toString();
                //MiddleName = etMname.getText().toString();
                //Phone = etPhone.getText().toString();
//         if (!validate()){
//            onSignupFailed();
//            return;
//        }
       // updateTeachers();


    }

    private void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Creating Account failed", Toast.LENGTH_LONG).show();

    }
 //   public boolean validate(){
//        boolean valid = true;
//
//        if (FirstName.isEmpty() || FirstName.length() < 3) {
//            etFname.setError("at least 3 characters");
//            valid = false;
//        } else {
//            etFname.setError(null);
//        }
//
//        if (Phone.isEmpty() || Phone.length() < 11 ) {
//            etPhone.setError("Short Password");
//            valid = false;
//        } else {
//            etPhone.setError(null);
//        }
//
//        return valid;

    //}
    public void radioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        // This check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_male:
                if (checked)
                    //Do something when radio button is clicked
                    Toast.makeText(getApplicationContext(), "Male Selected", Toast.LENGTH_SHORT).show();
                break;

            case R.id.rb_female:
                //Do something when radio button is clicked
                Toast.makeText(getApplicationContext(), "Female Selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    void updateTeachers(){
        String url_update= "http://192.168.43.252/test/update.php";
        StringRequest stringDelete=new StringRequest(Request.Method.POST, url_update, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.equalsIgnoreCase("yes")){
                    Log.e("ce",response);
                    Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"NOt Updated",Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> headers=new HashMap<>();
                headers.put("id",tech_id);
                headers.put("name",tech_name);
                return headers;
            }
        };
        AppController.getmInstance().addToRequestQue(stringDelete);


    }



}
