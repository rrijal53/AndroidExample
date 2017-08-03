package com.rowsun.kcmit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    RecyclerView rv_test;
    List<Doctor> doctorList;
    AdapterDoctor mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        doctorList = new ArrayList<>();

        doctorList.add(new Doctor("1", "roshan", "dhulikhel", "fjdsfs", "m" ));
        doctorList.add(new Doctor("1", "roshan rijal", "dhulikhel", "fjdsfs", "m" ));

        mAdapter = new AdapterDoctor(this, doctorList);

        rv_test = (RecyclerView) findViewById(R.id.rv);
        rv_test.setLayoutManager(new LinearLayoutManager(this));
//        rv_test.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv_test.setAdapter(mAdapter);


    }

}
