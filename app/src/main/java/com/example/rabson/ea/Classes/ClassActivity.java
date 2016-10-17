package com.example.rabson.ea.Classes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rabson.ea.R;

public class ClassActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    String[] clasTeachers = {"1A - Mwl.Jackline Sylvester",
            "1B - Mwl.Jack Vester","2A - Mwl.Line Lester",
            "2B - Mwl.Jumol Mester","3A - Mwl.Rambo Von",
            "3B - Mwl.Dabby Don","4A - Mwl.Raphael Kalongo",
            "4B - Mwl.Hamadi Kizigo","5A - Mwl.Jackline Sylvester",
            "5B - Mwl.Vanessa Mdee","5C - Mwl.Shaaban Ally",
            "6A - Mwl.Ngawaje Bungaya","6B - Mwl.Jafari Mpili",
            "7A - Mwl.Happy Nation","7B - Mwl.Chill Mix",
            "7C - Mwl.Ivan Mbaga","7D - Mwl.Salome Daimondo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.lv_classes);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,clasTeachers);
        listView.setAdapter(adapter);
    }
}
