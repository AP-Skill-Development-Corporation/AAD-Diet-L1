package com.example.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et3;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.edit1);
        et3 =findViewById(R.id.edit3);
        webView = findViewById(R.id.web1);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https:www.google.com");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    public void navigate(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }

    public void browser(View view) {
        String data = et1.getText().toString();
        Uri uri = Uri.parse("https://www."+data);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);


    }

    public void passData(View view) {
        String data = et3.getText().toString();
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra("KEY",data);
        startActivity(intent);
    }
}