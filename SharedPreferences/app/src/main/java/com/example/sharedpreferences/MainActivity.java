package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.edit1);
        textView = findViewById(R.id.text1);

    }

    public void save(View view) {
        SharedPreferences shapre = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =shapre.edit();
        String txt = name.getText().toString();
        editor.putString("msg",txt);
        editor.apply();
        Toast.makeText(this, "Saved Successfully",
                Toast.LENGTH_SHORT).show();
    }

    public void retrive(View view) {
        SharedPreferences sharedPreferences =
                getSharedPreferences("user",Context.MODE_PRIVATE);
        String message = sharedPreferences.getString("msg","");
        textView.setText("Message "+message);
    }
}