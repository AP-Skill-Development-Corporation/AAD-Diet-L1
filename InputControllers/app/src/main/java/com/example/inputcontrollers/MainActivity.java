package com.example.inputcontrollers;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*RadioGroup is used to group together one or more  radiobuttons
    * Radio Button has two states either checked or unchecked*/
    RadioGroup rgroup;
    RadioButton rb1,rb2;
    CheckBox cb1,cb2,cb3;
    LinearLayout linearLayout;
    Switch aSwitch;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aSwitch = findViewById(R.id.switch1);
        linearLayout = findViewById(R.id.linear1);
        spinner = findViewById(R.id.spi1);
        cb1=findViewById(R.id.ch1);
        cb2 = findViewById(R.id.ch2);
        cb3 = findViewById(R.id.ch3);
        rgroup = findViewById(R.id.rg1);
        rb1 = findViewById(R.id.rb1);
        rb2= findViewById(R.id.rb2);
        ArrayList<String> weeks = new ArrayList<>();
        weeks.add("SunDay");
        weeks.add("MonDay");
        weeks.add("TuesDay");
        weeks.add("WednesDay");
        weeks.add("ThursDay");
        weeks.add("Friday");
        weeks.add("Saturday");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,weeks);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "You Selected"+weeks.get(i),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1:
                        Toast.makeText(MainActivity.this, "Male",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rb2:
                        Toast.makeText(MainActivity.this, "FeMale",
                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void touch(View view) {
        Toast.makeText(this, "you selected image", Toast.LENGTH_SHORT).show();
    }

    public void submit(View view) {
        if (cb1.isChecked()&&cb2.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb2.getText()+","+cb3.getText(),
                    Toast.LENGTH_SHORT).show();


            }
        else if(cb1.isChecked()&&cb2.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb2.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        else if(cb2.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb2.getText()+","+cb3.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        else if(cb1.isChecked()&&cb3.isChecked()){
            Toast.makeText(this, ""+cb1.getText()+","+cb3.getText(),
                    Toast.LENGTH_SHORT).show();
        }
        else if(cb1.isChecked()){
            Toast.makeText(this, ""+cb1.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb2.isChecked()){
            Toast.makeText(this, ""+cb2.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(cb3.isChecked()){
            Toast.makeText(this, ""+cb3.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    public void changeColor(View view) {
        if (aSwitch.isChecked()){
            linearLayout.setBackgroundColor(Color.GRAY);
        }
        else{
            linearLayout.setBackgroundColor(Color.GREEN);
        }
    }
}