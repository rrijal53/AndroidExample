

package com.rowsun.kcmit;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.AsyncTask;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText fullname, uname, password, submit;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pd = new ProgressDialog(this);
        pd.setTitle("Title");
        pd.setMessage("Please wait");
        final ServerRequest sh = new ServerRequest(this);

        fullname = (EditText) findViewById(R.id.fullname);
        uname = (EditText) findViewById(R.id.uname);
        password = (EditText) findViewById(R.id.password);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname = fullname.getText().toString();
                final String name = uname.getText().toString();
                final String pwd = password.getText().toString();
                if (!sh.isNetworkConnected(MainActivity.this)) {
                    Toast.makeText(MainActivity.this, "No internet", Toast.LENGTH_LONG).show();
                    return;
                }


                pd.show();
                new AsyncTask<Void, Void, String>() {


                    @Override
                    protected String doInBackground(Void... params) {
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("action", "register");
                        map.put("uname", name);
                        map.put("fullname", fname);
                        map.put("password", pwd);


                        return  sh.httpPostData("http://192.168.1.11/contact/abc.php", map);
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        try {
                            JSONObject object = new JSONObject(s);
                          String re =  object.optString("res");
                            if(re.equals("success")){

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }.execute();
            }
        });
    }


    @Override
    protected void onPause() {
        super.onPause();


    }
}
