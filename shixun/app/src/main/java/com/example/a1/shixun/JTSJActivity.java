package com.example.a1.shixun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class JTSJActivity extends AppCompatActivity {
    private Button btn_jtsj,btn_sjtj,btn_jtfx,btn_cxzn;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jtsj);

        webView = (WebView)findViewById(R.id.webView);


        btn_jtsj = (Button)findViewById(R.id.btn_jtsj);
        btn_sjtj = (Button)findViewById(R.id.btn_sjtj);
        btn_jtfx = (Button)findViewById(R.id.btn_jtfx);
        btn_cxzn = (Button)findViewById(R.id.btn_cxzn);

        btn_sjtj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JTSJActivity.this,SJTJActivity.class);
                startActivity(intent);
            }
        });

        btn_jtfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JTSJActivity.this,JTFXActivity.class);
                startActivity(intent);
            }
        });

        btn_cxzn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JTSJActivity.this,CXZNActivity.class);
                startActivity(intent);
            }
        });

        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });

        webView.loadUrl("https://map.baidu.com//");
    }
}
