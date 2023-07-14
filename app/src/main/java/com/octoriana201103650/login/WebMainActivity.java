package com.octoriana201103650.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebMainActivity extends AppCompatActivity {

    private WebView _webView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_main);

        _webView1 = (WebView) findViewById(R.id.webView1);

        WebViewClient webViewClient = new WebViewClient();
        _webView1.setWebViewClient(webViewClient);

        WebChromeClient webChromeClient = new WebChromeClient();
        _webView1.setWebChromeClient(webChromeClient);

        WebSettings webSettings = _webView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        WebAppInterface webAppInterface = new WebAppInterface(this, WebMainActivity.this);
        _webView1.addJavascriptInterface(webAppInterface, "Android");

        String url = "https://stmikpontianak.net/011100862/webview_lanjutan.html";
        _webView1.loadUrl(url);
    }
}