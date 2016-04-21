package com.bigbang.bastolasushil.lab10;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview=(WebView)findViewById(R.id.webview);
        Intent intent = getIntent();
        Uri data = intent.getData();
        URL url = null;

        try {
            url = new URL(data.getScheme(), data.getHost(),
                    data.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.loadUrl(url.toString());
        webview.setWebViewClient(new HelloWebViewClient());
    }
    private class HelloWebViewClient extends WebViewClient

    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView webview, String url){
            webview.loadUrl(url);
            return true;


}

    }


    }


