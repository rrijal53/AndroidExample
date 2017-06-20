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
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    RecyclerView rv_test;
    List<Student> studentList;
    AdapterContact mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        studentList = new ArrayList<>();
        Student s = new Student("ROshan", "Abc", "123");
        studentList.add(s);
        studentList.add(new Student("abc", "cde", "234"));
        studentList.add(new Student("abcd", "rrcde", "11234"));

        mAdapter = new AdapterContact(this, studentList);

        rv_test = (RecyclerView) findViewById(R.id.rv);
        rv_test.setLayoutManager(new LinearLayoutManager(this));
        rv_test.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rv_test.setAdapter(mAdapter);


    }

}
