package com.example.a1.shixun;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_jtsj,btn_sjtj,btn_jtfx,btn_cxzn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_jtsj = (Button)findViewById(R.id.btn_jtsj);
        btn_sjtj = (Button)findViewById(R.id.btn_sjtj);
        btn_jtfx = (Button)findViewById(R.id.btn_jtfx);
        btn_cxzn = (Button)findViewById(R.id.btn_cxzn);

        btn_jtsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,JTSJActivity.class);
                startActivity(intent);
            }
        });

        btn_sjtj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SJTJActivity.class);
                startActivity(intent);
            }
        });

        btn_jtfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,JTFXActivity.class);
                startActivity(intent);
            }
        });

        btn_cxzn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CXZNActivity.class);
                startActivity(intent);
            }
        });
    }
}
