package com.rowsun.kcmit;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    EditText message;
    TextView display;
    Button button;
    RadioButton radio_male, radio_female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        message = (EditText) findViewById(R.id.et_message);
        button = (Button) findViewById(R.id.btnn);
        display = (TextView) findViewById(R.id.display);
        radio_male = (RadioButton) findViewById(R.id.radio_male);
        radio_female = (RadioButton) findViewById(R.id.radio_female);

        radio_female.setOnCheckedChangeListener(this);

        String json = "{\"res\":\"success\",\"data\":{\"id\":\"1\",\"username\":\"kcmit\",\"c_fname\":\"roshan\",\"c_lname\":\"rijal\",\"n_home\":\"\",\"n_mobile\":\"9849316389\",\"n_office\":\"\",\"created\":\"2016-12-29 03:59:23 pm\"}}";
        try {
            JSONObject object = new JSONObject(json);
//            String response = object.optString("res");
//            JSONObject data = object.getJSONObject("data");
//            String username = data.optString("username");
//            display.setText(response + " USER NAME = " +  username);
            SharedPreferences p = PreferenceManager.getDefaultSharedPreferences(this);
//            p.edit().putString("name", username).commit();
            message.setText(p.getString("name", ""));
            p.edit().clear();
//            View  v = LayoutInflater.from(this).inflate(R.layout.row_student, null);
//            new AlertDialog.Builder(this).setView(v).setTitle("Response").setMessage(response).setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Toast.makeText(MainActivity.this, "OK clicked", Toast.LENGTH_LONG).show();
//                }
//            }).setNegativeButton("Cancel", null).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Botton Clicked");
                Toast.makeText(MainActivity.this, "Botton Clicked", Toast.LENGTH_LONG ).show();
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
            }
        });

    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        display.setText("" + isChecked);
        display.setTextColor(isChecked ?    Color.parseColor("#ffffff") : Color.parseColor("#000000"));

    }
}
