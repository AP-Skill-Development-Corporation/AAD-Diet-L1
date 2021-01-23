package com.example.recyclerview_ex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler1);
        int images[]={R.drawable.ara,R.drawable.b,R.drawable.ch,
        R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
        R.drawable.hap,R.drawable.i,R.drawable.jalsa};
        String names[]={"Aravindha Sametha","Bahubali",
        "Chandramukhi","Darling","Eega","Fida","Galimar","HappyDays",
        "I","Jalsa"};
        myAdapter = new MyAdapter(this,images,names);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
    }
}