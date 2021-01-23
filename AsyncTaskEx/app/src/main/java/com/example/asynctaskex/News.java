package com.example.asynctaskex;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class News  extends AsyncTask<String,Void,String> {
    Context context;
    TextView textView;
    ProgressBar progressBar;
    private static final String Url_link=
            "https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=bb9a588a4d92431ab2af9afa89c2a73e";
    public News(Context context, TextView textView, ProgressBar progressBar) {
        this.context = context;
        this.textView = textView;
        this.progressBar = progressBar;
    }



    @Override
    protected String doInBackground(String... strings) {
        try{
            URL url = new URL(Url_link);
            HttpsURLConnection uconnection = (HttpsURLConnection)
                    url.openConnection();
            InputStream inputStream =uconnection.getInputStream();
            if(inputStream!=null){
                BufferedReader br = new BufferedReader
                        (new InputStreamReader(inputStream));
                StringBuilder sb = new StringBuilder();
                String line;
                while((line = br.readLine())!=null){
                    sb.append(line);
                }
                return sb.toString();
            }
            else{
                Log.d("Info","Input Stream is null");
            }
        }catch (Exception e){
        }
        return null;


    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        textView.setText(s);
        try{
            JSONObject object1 = new JSONObject(s);
            JSONArray arr1= object1.getJSONArray("articles");
            for (int i=0;i<arr1.length();i++){
                JSONObject object2 = arr1.getJSONObject(i);
                String data =object2.getString("title");
                textView.setText(data+"\n\n");
            }


        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
