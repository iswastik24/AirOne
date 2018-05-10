package com.swastikijari.airone;



        import android.app.Activity;
        import android.content.Context;
        import android.os.AsyncTask;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.inputmethod.InputMethodManager;
        import android.webkit.WebView;
        import android.webkit.WebViewClient;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.net.URLEncoder;

public class Weather extends AppCompatActivity {


    WebView hotel_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        hotel_view = (WebView)findViewById(R.id.webview11);
        hotel_view.setWebViewClient(new MyBrowser11());
        hotel_view.loadUrl("https://www.accuweather.com/en/in/bengaluru/204108/weather-forecast/204108");
        hotel_view.getSettings().setJavaScriptEnabled(true);
    }
    public class MyBrowser11 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

    }







