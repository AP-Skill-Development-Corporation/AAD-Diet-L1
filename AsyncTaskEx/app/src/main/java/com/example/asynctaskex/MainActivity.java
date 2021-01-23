package com.example.asynctaskex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text1);
        progressBar = findViewById(R.id.progress1);
        progressBar.setVisibility(View.GONE);
    }

    public void submit(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new News(this,textView,progressBar).execute();

    }
}