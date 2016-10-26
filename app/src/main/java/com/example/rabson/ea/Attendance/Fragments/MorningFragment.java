package com.example.rabson.ea.Attendance.Fragments;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import helpers.AppController;

import com.android.volley.toolbox.StringRequest;
import com.example.rabson.ea.Attendance.RecyclerView.MyRecyclerAdapter;
import com.example.rabson.ea.Attendance.RecyclerView.Student;
import com.example.rabson.ea.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by Rabson on 10/11/2016.
 */
public class MorningFragment extends Fragment {
    private  List<Student> data=new ArrayList<>();
    private  List<String> studentPresents=new ArrayList<>();
    private  List<String> studentAbsents=new ArrayList<>();
    private RecyclerView rv;
    private JSONObject present_Json;
    private JSONObject absent_Json;
    private JSONArray takePresent;
    private MyRecyclerAdapter adapter;
    //private Button sendData;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.morning_fragment, null);
        rv = (RecyclerView) v.findViewById(R.id.rv_morning_attendance);
       adapter=new MyRecyclerAdapter(getActivity(),data);
       parseData();
       presentsStudents();
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
     //   sendData= (Button) v.findViewById(R.id.sendData);
     return v;
    }
    public void parseData(){
        String url_search="http://foodly.pe.hu/hype/search.php";
        final JsonArrayRequest jsonArray=new JsonArrayRequest(url_search, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject jsonObj=response.getJSONObject(i);
                        Student mystudent = new Student();
                        mystudent.id=jsonObj.getString("id");
                        mystudent.student_name=jsonObj.getString("surnames");
                        Log.e("names",mystudent.student_name);
                        Log.e("ids",mystudent.id);
                        data.add(mystudent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter=new MyRecyclerAdapter(getActivity(),data);
                rv.setAdapter(adapter);
    }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("no data","no ");
            }
        });
        AppController.getmInstance().addToRequestQue(jsonArray);
   };


    void presentsStudents(){
       List<String> mystudens= adapter.getStudents();
        for (int i=0; i<mystudens.size(); i++){
           String names= mystudens.get(i); // getting all checked and unchecked values
                Log.e("SingeData",names);
            }
                      }




    @Override
    public String toString() {
        return "MORNING";
    }
}
