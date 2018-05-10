package com.swastikijari.airone;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Restaurants extends AppCompatActivity {
    WebView resturant_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        resturant_view = (WebView)findViewById(R.id.webview2);
        resturant_view.setWebViewClient(new MyBrowser1());
        resturant_view.loadUrl("https://www.resdiary.com/");
        resturant_view.getSettings().setJavaScriptEnabled(true);
    }
    public class MyBrowser1 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
