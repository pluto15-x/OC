package com.example.a1.shixun;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SJTJActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_jtsj,btn_sjtj,btn_jtfx,btn_cxzn,btn_add,btn_update,btn_delete,btn_query;
    private EditText et_name,et_data;
    private TextView tv_show;
    MyHelper myHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sjtj);
        myHelper = new MyHelper(this);
        init();
    }

    private void init(){
        btn_jtsj = (Button)findViewById(R.id.btn_jtsj);
        btn_sjtj = (Button)findViewById(R.id.btn_sjtj);
        btn_jtfx = (Button)findViewById(R.id.btn_jtfx);
        btn_cxzn = (Button)findViewById(R.id.btn_cxzn);
        btn_add = (Button)findViewById(R.id.btn_add);
        btn_query = (Button)findViewById(R.id.btn_query);
        btn_update = (Button)findViewById(R.id.btn_update);
        btn_delete = (Button)findViewById(R.id.btn_delete);
        et_name = (EditText)findViewById(R.id.et_name);
        et_data = (EditText)findViewById(R.id.et_data);
        tv_show = (TextView)findViewById(R.id.tv_show);

        btn_jtsj.setOnClickListener(this);
        btn_sjtj.setOnClickListener(this);
        btn_jtfx.setOnClickListener(this);
        btn_cxzn.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        String name,data;
        SQLiteDatabase db;
        ContentValues values;
        btn_jtsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SJTJActivity.this,JTSJActivity.class);
                startActivity(intent);
            }
        });

        btn_jtfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SJTJActivity.this,JTFXActivity.class);
                startActivity(intent);
            }
        });

        btn_cxzn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SJTJActivity.this,CXZNActivity.class);
                startActivity(intent);
            }
        });

        switch (v.getId()){
            case R.id.btn_add://添加数据
                name = et_name.getText().toString();
                data = et_data.getText().toString();
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("name", name);
                values.put("data", data);
                db.insert("information",null, values);
                Toast.makeText(this,"信息已添加",Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_update://修改数据
                db = myHelper.getWritableDatabase();
                values = new ContentValues();
                values.put("data",data = et_data.getText().toString());
                db.update("information", values, "name=?", new String[]{et_name.getText().toString()});
                Toast.makeText(this, "信息已修改", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_delete://删除数据
                db = myHelper.getWritableDatabase();
                db.delete("information", null, null);
                Toast.makeText(this,"信息已删除",Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.btn_query://查询数据
                db = myHelper.getReadableDatabase();
                Cursor cursor = db.query("information", null, null, null, null, null, null);
                if (cursor.getCount()==0){
                    tv_show.setText("");
                    Toast.makeText(this,"没有数据", Toast.LENGTH_SHORT).show();
                }else {
                    cursor.moveToFirst();
                    tv_show.setText("Name:" + cursor.getString(1) + "; Data:" + cursor.getString(2));
                }while (cursor.moveToNext()){
                    tv_show.append("\n" + "Name:" + cursor.getString(1) + "; Data:" + cursor.getString(2));
            }
            cursor.close();
            db.close();
            break;
        }
    }
    class MyHelper extends SQLiteOpenHelper{
        public MyHelper(Context context){
            super(context, "itcast.db", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db){
            db.execSQL("CREATE TABLE information(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(20), data VARCHAR(20))");
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){ }
    }
}