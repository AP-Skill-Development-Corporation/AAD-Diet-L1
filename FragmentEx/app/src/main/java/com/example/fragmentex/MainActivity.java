package com.example.fragmentex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    boolean status=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {
        if(!status){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1,
                    new AFragment()).commit();
            status=true;

        } else{
            getSupportFragmentManager().beginTransaction().replace(R.id.frame1,
                    new BFragment()).commit();
            status=false;

        }
    }
}