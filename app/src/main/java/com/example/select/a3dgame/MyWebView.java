package com.example.select.a3dgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MyWebView extends AppCompatActivity implements View.OnClickListener{

    private EditText mEditText;
    private Button mButton;
    private WebView mWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        initView();
        initListener();
    }

    private void initListener() {
        mButton.setOnClickListener(this);
    }

    private void initView() {
        mEditText= (EditText) findViewById(R.id.et_webview);
        mButton= (Button) findViewById(R.id.btn_webview);
        mWebView= (WebView) findViewById(R.id.wv_webview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_webview:
                String str=mEditText.getText().toString().trim();
                WebSettings setting=mWebView.getSettings();
                setting.setBuiltInZoomControls(true);
                setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
                mWebView.loadUrl(str);
                mWebView.setWebViewClient(new WebViewClient(){
                    @Override
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        view.loadUrl(url);
                        return true;
                    }
                });
                break;
        }

    }
}
