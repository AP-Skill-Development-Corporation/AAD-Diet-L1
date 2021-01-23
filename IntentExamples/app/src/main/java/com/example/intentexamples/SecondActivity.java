package com.example.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.text1);
        Bundle bundle = getIntent().getExtras();
        String data =bundle.getString("KEY");
        textView.setText(""+data);
    }
}