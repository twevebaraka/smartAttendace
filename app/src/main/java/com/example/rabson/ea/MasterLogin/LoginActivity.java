package com.example.rabson.ea.MasterLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rabson.ea.ClassTeacherDash.ClassTeacherActivity;
import com.example.rabson.ea.HomeActivity;
import com.example.rabson.ea.R;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

import helpers.AppController;
import helpers.Config;

public class LoginActivity extends AppCompatActivity {
    ImageView appIcon;
    EditText et_phone,et_password;
    Button bn_login;
    TextView tv_forget_password;
    String phoneNumber,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        bn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             captureInfo();
            }
        });
    }

    public void initViews(){
        appIcon = (ImageView) findViewById(R.id.app_icon);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_password = (EditText) findViewById(R.id.et_password);
        bn_login = (Button) findViewById(R.id.bn_login);
        tv_forget_password = (TextView) findViewById(R.id.tv_forget_password);
    }

    public void captureInfo(){
        final String login_url = "http://192.168.43.252/test/login.php";
                phoneNumber = et_phone.getText().toString();
                password = et_password.getText().toString();
                StringRequest stringRequest=new StringRequest(Request.Method.POST, login_url,new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("responese",response);
                             if (response.equalsIgnoreCase("teacher")){
                                 startActivity(new Intent(getApplicationContext(), ClassTeacherActivity.class));
                             }
                        else if(response.equalsIgnoreCase("master")){
                                 startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                             }
                        else {
                                 Toast.makeText(getApplication(),"NO ACCESS TO THIS APP",Toast.LENGTH_LONG).show();
                             }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("fuck","down");

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String,String> data=new HashMap<String, String>();
                        data.put(Config.PASSWORD,password);
                        data.put(Config.USERNAME,phoneNumber);
                        return data;
                    }
                };
        AppController.getmInstance().addToRequestQue(stringRequest);
            }

        }

