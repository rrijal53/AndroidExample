package com.rowsun.kcmit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    RecyclerView rv_test;
    List<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        studentList = new ArrayList<>();
        Student s= new Student("ROshan", "DHulikhel", "qw42w435r");
        studentList.add(s);
        studentList.add(new Student("rijal", "abc", "qw42w435r"));
        studentList.add(new Student("test", "bcd", "qw42w435r"));

        rv_test = (RecyclerView) findViewById(R.id.rv);
        rv_test.setLayoutManager(new LinearLayoutManager(this));


    }

}
