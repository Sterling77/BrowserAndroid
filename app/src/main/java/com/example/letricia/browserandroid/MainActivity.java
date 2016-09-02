package com.example.letricia.browserandroid;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText addressBar;
    Button backButton;
    Button forwardButton;
    Button goButton;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addressBar = (EditText) findViewById(R.id.textView);
        backButton = (Button) findViewById(R.id.button);
        forwardButton = (Button) findViewById(R.id.button2);
        goButton = (Button) findViewById(R.id.button3);
        webView = (WebView) findViewById(R.id.webView);

        backButton.setOnClickListener(this);
        forwardButton.setOnClickListener(this);
        goButton.setOnClickListener(this);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                addressBar.setText(url);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == backButton) {
            webView.goBack();
        } else if (v == forwardButton) {
            webView.goForward();
        } else if (v == goButton) {
            String address = addressBar.getText().toString();
            if (!address.startsWith("http")) {
                address = "http://" + address;
            }
            webView.loadUrl(address);
        }

    }
}
