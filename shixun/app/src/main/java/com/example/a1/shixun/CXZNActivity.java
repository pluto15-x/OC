package com.example.a1.shixun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CXZNActivity extends AppCompatActivity {
    private Button btn_jtsj,btn_sjtj,btn_jtfx,btn_cxzn;
    private TextView tv_cxzn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cxzn);
        btn_jtsj = (Button)findViewById(R.id.btn_jtsj);
        btn_sjtj = (Button)findViewById(R.id.btn_sjtj);
        btn_jtfx = (Button)findViewById(R.id.btn_jtfx);
        btn_cxzn = (Button)findViewById(R.id.btn_cxzn);
        tv_cxzn = (TextView)findViewById(R.id.tv_cxzn);

        tv_cxzn.setMovementMethod(ScrollingMovementMethod.getInstance());

        btn_jtsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CXZNActivity.this,JTSJActivity.class);
                startActivity(intent);
            }
        });

        btn_sjtj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CXZNActivity.this,SJTJActivity.class);
                startActivity(intent);
            }
        });

        btn_jtfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CXZNActivity.this,JTFXActivity.class);
                startActivity(intent);
            }
        });
    }
}
