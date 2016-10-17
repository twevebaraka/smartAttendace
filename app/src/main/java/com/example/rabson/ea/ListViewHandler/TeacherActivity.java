package com.example.rabson.ea.ListViewHandler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.rabson.ea.MainActivity;
import com.example.rabson.ea.R;
import com.example.rabson.ea.TeacherDummyData.Teacher;
import com.example.rabson.ea.TeacherDummyData.TeacherCollection;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helpers.AppController;

public class TeacherActivity extends AppCompatActivity {
    public static String url_search="http://192.168.43.252/test/search.php";
    ListView listView;
    List<Teacher> data=new ArrayList<>();

    public FloatingActionMenu fam;
    public FloatingActionButton fabEdit, fabDelete, fabAdd;
    private Teacher myites;
    private String teacher_id;
    private String name;
    private String id;
    private String teacher_name;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Walimu");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView = (ListView) findViewById(R.id.lv_teacher);
        parseData();
        final CustomAdapter adapter= new CustomAdapter(this, data);
        listView.setAdapter(adapter);
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                   myites= data.get(position);
                   teacher_id=myites.getId();
                   teacher_name =myites.getTeacherName();
                     openDialog(); // deleter and edit

                  Log.e("myTesta",teacher_id);
//                if (view.getId()==techerId){
//                    Log.e("test",teacher_id);
                    Toast.makeText(getApplicationContext(),""+teacher_id,Toast.LENGTH_LONG).show();

       //         }
              //  Intent next_intent=new Intent(context,getDetails.class);
//                next_intent.putExtra("id",current.id);
//                context.startActivity(next_intent);

                //openDialog();
            }
        });


    }

//    public void setUpFloatingActionMenu(){
//        //Floating action menu (FAM)
//        fabAdd = (FloatingActionButton) findViewById(R.id.fab2);
//        fabDelete = (FloatingActionButton) findViewById(R.id.fab3);
//        fabEdit = (FloatingActionButton) findViewById(R.id.fab1);
//        fam = (FloatingActionMenu) findViewById(R.id.fab_menu);
//
//        //handling menu status (open or close)
//        fam.setOnMenuToggleListener(new FloatingActionMenu.OnMenuToggleListener() {
//            @Override
//            public void onMenuToggle(boolean opened) {
//                if (opened) {
//                    showToast("Menu is opened");
//                } else {
//                    showToast("Menu is closed");
//                }
//            }
//        });
//
//        //handling each floating action button clicked
//        fabDelete.setOnClickListener(onButtonClick());
//        fabEdit.setOnClickListener(onButtonClick());
//        fabAdd.setOnClickListener(onButtonClick());
//
//        fam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (fam.isOpened()) {
//                    fam.close(true);
//                }
//            }
//        });
//
//    }

    private View.OnClickListener onButtonClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view == fabAdd) {
                    showToast("Class Teacher");
                } else if (view == fabDelete) {
                    showToast("TOD");
                } else {
                    showToast("Register Teacher");
                }
                fam.close(true);
            }
        };
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    private void openDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(TeacherActivity.this);
        builder.setTitle("EDIT OR REMOVE");
        builder.setMessage("You Can Remove Or Edit Teacher");
        builder.setNegativeButton("EDIT TEACHER",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.putExtra("name",teacher_name);
                        i.putExtra("id",teacher_id);
                        startActivity(i);
                                      }
                });
        builder.setPositiveButton("REMOVE TEACHER",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        deleteData();
                        refresh();
                    }
                });
        builder.show();
    }

    public  void parseData(){
        JsonArrayRequest jsonArray=new JsonArrayRequest(url_search, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //Log.e("resut",response.toString());

                for (int i=0; i<response.length(); i++){
                    myites=new Teacher();

                    try {
                        JSONObject jsonObj=response.getJSONObject(i);
                         id=jsonObj.getString("id");
                       name=jsonObj.getString("name");
                        myites.setTeacherName(name);
                        myites.setId(id);
                        data.add(myites);
                        Log.e("names",name);
                        Log.e("ids",id);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }





            }
        },new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("no data","no ");
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String,String> queryData=new HashMap<>();
                queryData.put("delete",teacher_id);
                return queryData;
            }
        };
        AppController.getmInstance().addToRequestQue(jsonArray);
    }
    void deleteData(){
        String url_delete= "http://192.168.43.252/test/delete.php";
        StringRequest stringDelete=new StringRequest(Request.Method.POST, url_delete, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                 if(response.equalsIgnoreCase("yes")){
                     Log.e("ce",response);
                     Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                 }
                else{
                     Toast.makeText(getApplicationContext(),"NO",Toast.LENGTH_LONG).show();
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
                headers.put("id",teacher_id);
                return headers;
            }
        };
        AppController.getmInstance().addToRequestQue(stringDelete);


    }

    public void refresh(){
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}
