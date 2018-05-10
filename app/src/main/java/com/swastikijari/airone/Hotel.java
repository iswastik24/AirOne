package com.swastikijari.airone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Hotel extends AppCompatActivity {
   WebView hotel_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        hotel_view = (WebView)findViewById(R.id.webview1);
        hotel_view.setWebViewClient(new MyBrowser());
        hotel_view.loadUrl("https://www.trivago.in");
        hotel_view.getSettings().setJavaScriptEnabled(true);
    }
    public class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
