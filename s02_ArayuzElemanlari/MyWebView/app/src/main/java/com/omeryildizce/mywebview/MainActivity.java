package com.omeryildizce.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        // goster();
        gosterHtml();
    }

    private void goster() {
        webView.getSettings().setJavaScriptEnabled(true);
        String url = "https://www.google.com";
        webView.loadUrl(url);

    }

    private void gosterHtml() {
        String htmlKod = "<html>" +
                "<head>Webview</head>" +
                "<body>" +
                "<h1>Başlık</h1>"+
                "<p>Webview hml kod gösterimi</p>"+
                "</body>" +
                "</html>";
        webView.loadData(htmlKod, "text/html","UTF-8");
    }

    private void tanimla() {
        webView = findViewById(R.id.webView);
        
    }
}