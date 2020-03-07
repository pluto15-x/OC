package com.example.a1.shixun;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

public class JTFXActivity extends AppCompatActivity {
    private Button btn_jtsj,btn_sjtj,btn_jtfx,btn_cxzn;
    public static final float MAX = 12,MIN = 1f;
    public static final int NB_QUALITIES = 8;
    private RadarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jtfx);

        btn_jtsj = (Button)findViewById(R.id.btn_jtsj);
        btn_sjtj = (Button)findViewById(R.id.btn_sjtj);
        btn_jtfx = (Button)findViewById(R.id.btn_jtfx);
        btn_cxzn = (Button)findViewById(R.id.btn_cxzn);

        btn_jtsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JTFXActivity.this,JTSJActivity.class);
                startActivity(intent);
            }
        });

        btn_sjtj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JTFXActivity.this,SJTJActivity.class);
                startActivity(intent);
            }
        });

        btn_cxzn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(JTFXActivity.this,CXZNActivity.class);
                startActivity(intent);
            }
        });

        chart = findViewById(R.id.chart);
        chart.setBackgroundColor(Color.rgb(60,65,82));
        chart.getDescription().setEnabled(false);
        chart.setWebLineWidth(1f);
        chart.setWebColor(Color.WHITE);
        chart.setWebLineWidth(1f);
        chart.setWebColorInner(Color.WHITE);
        chart.setWebAlpha(100);

        setData();

        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0);
        xAxis.setXOffset(0);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(){
            private String[] qualities = new String[]{"Communication", "Technical Knowledge", "Problem Solving", "Punctuality", "Team Player"};

            @Override
            public String getFormattedValue(float value, AxisBase axis){
                return qualities[(int) value % qualities.length];
            }
        });

        xAxis.setTextColor(Color.WHITE);

        YAxis yAxis = chart.getYAxis();
        yAxis.setLabelCount(NB_QUALITIES,false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinimum(MIN);
        yAxis.setAxisMaximum(MAX);
        yAxis.setDrawLabels(false);

        Legend l = chart.getLegend();
        l.setTextSize(15f);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);
        l.setTextColor(Color.WHITE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.radar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.refreshValues:
                setData();
                chart.invalidate();
                break;
            case R.id.toggleValues:
                for (IDataSet<?> set : chart.getData().getDataSets()){
                    set.setDrawValues(!set.isDrawValuesEnabled());
                }
                chart.invalidate();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setData(){
        ArrayList<RadarEntry> employee1 = new ArrayList<>();
        ArrayList<RadarEntry> employee2 = new ArrayList<>();

        for (int i = 0;i < NB_QUALITIES; i++){
            if(i == 0){
                float val1 =  1;
                employee1.add(new RadarEntry(val1));
            }else {
                float val1 = (int) (Math.random() * MAX) + MIN;
                employee1.add(new RadarEntry(val1));
            }
            float val2 = (int) (Math.random() * MAX) + MIN;
            employee2.add(new RadarEntry(val2));
        }

        RadarDataSet set1 = new RadarDataSet(employee1,"Employee A");
        set1.setColor(Color.RED);
        set1.setFillColor(Color.RED);
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightIndicators(false);
        set1.setDrawHighlightCircleEnabled(true);

        RadarDataSet set2 = new RadarDataSet(employee2,"Employee B");
        set2.setColor(Color.GREEN);
        set2.setFillColor(Color.GREEN);
        set2.setDrawFilled(true);
        set2.setFillAlpha(180);
        set2.setLineWidth(2f);
        set2.setDrawHighlightIndicators(false);
        set2.setDrawHighlightCircleEnabled(true);

        ArrayList<IRadarDataSet> sets = new ArrayList<>();
        sets.add(set1);
        sets.add(set2);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.WHITE);

        chart.setData(data);
        chart.invalidate();
    }
}
