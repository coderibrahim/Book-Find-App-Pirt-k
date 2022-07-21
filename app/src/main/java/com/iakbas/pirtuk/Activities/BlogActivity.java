package com.iakbas.pirtuk.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.iakbas.pirtuk.R;

public class BlogActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);
        webView = findViewById(R.id.webView);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}