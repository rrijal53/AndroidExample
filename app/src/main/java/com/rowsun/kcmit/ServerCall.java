package com.rowsun.kcmit;

import android.os.AsyncTask;

import java.util.HashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by rowsun on 7/18/17.
 */

public class ServerCall  extends AsyncTask<Void, Void, String> {


    interface OnDataReceived{
        void success(String response);
        void error(String message);
    }

    OnDataReceived listener;
    String a ;
    public ServerCall(OnDataReceived listener) {
        this.listener = listener;

this.a = a;
    }

    @Override
    protected String doInBackground(Void... params) {
        String s =  getData();
        return s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s.isEmpty()){
            listener.error("Connection failed");
        }else{
            listener.success(s);
        }

    }

    public String getData(){

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://192.168.1.10/contact.php")
                .get()
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "";
    }
}
