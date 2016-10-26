package com.example.rabson.ea.Attendance.Fragments;

import android.os.Bundle;
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
public class EveningFragment extends Fragment {
    public List<Student> data=new ArrayList<>();
    private RecyclerView rv;
    private MyRecyclerAdapter adapter;
    private Button sendData;
    private JSONObject present_Json;
    private JSONObject absent_Json;
    private JSONArray takePresent;
    private List <String>studentPresents=new ArrayList<>();
    private List <String>studentAbsents=new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.evening_fragment, null);
        rv = (RecyclerView) v.findViewById(R.id.rv_evening_attendance);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        parseData();
       // presentsStudents();
//        Button sendStudents= (Button) v.findViewById(R.id.sendData);
//        sendStudents.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(),"Succesffuly Saved",Toast.LENGTH_LONG).show();
//            }
//        });

        return v;
    }
    public void parseData(){
        String url_search="http://foodly.pe.hu/hype/search.php";
        JsonArrayRequest jsonArray=new JsonArrayRequest(url_search, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
       for (int i=0; i<response.length(); i++){
                    try {
                        JSONObject jsonObj=response.getJSONObject(i);
                        Student mystudent = new Student();
                        mystudent.id=jsonObj.getString("id");
                        mystudent.student_name=jsonObj.getString("surnames");
                      //  Log.e("names",mystudent.student_name);
                      //  Log.e("ids",mystudent.id);
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

//
//    void presentsStudents() {
//        List<Student> mystudens = adapter.getStudents();
//        for (int i = 0; i < mystudens.size(); i++) {
//            Student students = mystudens.get(i); // getting all checked and unchecked values
//            if (students.isSetselected() == true) {
//                String name = students.getStudent_name();
//                studentPresents.add(name);
//                Log.e("SingeAbsent",studentPresents.get(i));
//            } else {
//                if (students.isSetselected() == false) {
//                    String absents = students.getStudent_name();
//                    studentPresents.remove(i);
//                    studentAbsents.add(absents);
//                }
//            }
//
//        }
//        Log.e("allAData",studentPresents.toString());
 //   }



    @Override
    public String toString() {
        return "EVENING";
    }


}
