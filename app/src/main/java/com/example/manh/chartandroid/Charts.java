package com.example.manh.chartandroid;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.LargeValueFormatter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by manh on 21/04/2015.
 */
public class Charts extends Activity{

    private static final String URL_STATIC_PAGE = "http://pancake.vn/api/pages/:page_id/statistic_pages";
    private ArrayList<String> dates = new ArrayList<>();
    private ArrayList<Integer> orders = new ArrayList<>();
    private ArrayList<Integer> new_customers = new ArrayList<>();
    private ArrayList<Integer> likes = new ArrayList<>();
    private ArrayList<Integer> customers = new ArrayList<>();
    private ArrayList<Integer> conversation = new ArrayList<>();
    private ArrayList<Integer> comment = new ArrayList<>();

    private LineData mChartData;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String data = "{ \"test\" :[" +
                "{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 20,\n" +
                "        \"conversation\": 540,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 422,\n" +
                "        \"date\": \"01-01\",\n" +
                "        \"like\": 148,\n" +
                "        \"new_customer\": 121,\n" +
                "        \"order\": 101,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }," +
                "{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 310,\n" +
                "        \"conversation\": 150,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 242,\n" +
                "        \"date\": \"02-01\",\n" +
                "        \"like\": 848,\n" +
                "        \"new_customer\": 121,\n" +
                "        \"order\": 10,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }," +
                "{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 290,\n" +
                "        \"conversation\": 520,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 422,\n" +
                "        \"date\": \"03-01\",\n" +
                "        \"like\": 648,\n" +
                "        \"new_customer\": 122,\n" +
                "        \"order\": 40,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }," +
                "{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 110,\n" +
                "        \"conversation\": 450,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 142,\n" +
                "        \"date\": \"04-01\",\n" +
                "        \"like\": 48,\n" +
                "        \"new_customer\": 112,\n" +
                "        \"order\": 220,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }" +
                ",{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 10,\n" +
                "        \"conversation\": 350,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 422,\n" +
                "        \"date\": \"05-01\",\n" +
                "        \"like\": 84,\n" +
                "        \"new_customer\": 212,\n" +
                "        \"order\": 20,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }," +
                "{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 410,\n" +
                "        \"conversation\": 550,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 412,\n" +
                "        \"date\": \"06-01\",\n" +
                "        \"like\": 8,\n" +
                "        \"new_customer\": 312,\n" +
                "        \"order\": 100,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }," +
                "{\n" +
                "        \"_id\": \"5526446243756ff8a2080000\",\n" +
                "        \"comment\": 510,\n" +
                "        \"conversation\": 510,\n" +
                "        \"created_at\": \"2015-04-09T09:20:36.890Z\",\n" +
                "        \"customer\": 442,\n" +
                "        \"date\": \"07-01\",\n" +
                "        \"like\": 87,\n" +
                "        \"new_customer\": 412,\n" +
                "        \"order\": 10,\n" +
                "        \"page_id\": \"345137015687083\",\n" +
                "        \"updated_at\": \"2015-04-15T02:40:44.132Z\"\n" +
                "    }] }";

        setContentView(R.layout.charts_line);

        try {
            JSONObject jsonObject = new JSONObject(data);
            JSONArray jsonArray = jsonObject.optJSONArray("test");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                orders.add(jsonObject1.getInt("order"));
                likes.add(jsonObject1.getInt("like"));
                new_customers.add(jsonObject1.getInt("new_customer"));
                dates.add(jsonObject1.getString("date"));
                customers.add(jsonObject1.getInt("customer"));
                conversation.add(jsonObject1.getInt("conversation"));
                comment.add(jsonObject1.getInt("comment"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LineChart mLineChart = (LineChart) findViewById(R.id.line_chart);
        setLineChart(mLineChart);
        loadLineChartData(mLineChart);

        BarChart mBarChart = (BarChart) findViewById(R.id.bar_chart);
        setBarChart(mBarChart);
        loadBarChartData(mBarChart);

        CombinedChart mChart = (CombinedChart) findViewById(R.id.bar_line_chart);
        loadLineBarChart(mChart);
    }

    private void loadLineChartData(LineChart chart){
        ArrayList<LineDataSet> allLinesList = new ArrayList<LineDataSet>();
        ArrayList<Entry> entryList = new ArrayList<Entry>();
        for(int i=0; i<orders.size(); i++){
//            Entry(yValue,xIndex);
            entryList.add(new Entry(orders.get(i),i));
        }
        //LineDataSet
        LineDataSet dataSet = new LineDataSet(entryList,"Oder/Ngày");
        dataSet.setLineWidth(2.5f);
        dataSet.setColor(Color.rgb(74, 178, 193));
        dataSet.setHighLightColor(Color.rgb(159, 207, 213));
        dataSet.setCircleColor(Color.rgb(74, 178, 193));
        dataSet.setCircleSize(5f);
        dataSet.setFillColor(Color.rgb(74, 178, 193));
        dataSet.setDrawValues(false);
        allLinesList.add(dataSet);
        mChartData = new LineData(getXDates(), allLinesList);
        // set data
        chart.setData(mChartData);
        chart.animateX(1500);
    }

    private void setLineChart(LineChart chart) {
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker);
        chart.setMarkerView(mv);
        chart.setDrawGridBackground(false);
        chart.setScaleEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setDescription("");
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(6);
        YAxis rightAxis = chart.getAxisRight();
        chart.getLegend().setEnabled(false);
        rightAxis.setDrawAxisLine(true);
        rightAxis.setDrawLabels(true);
    }

    private ArrayList<String> getXDates() {
        ArrayList<String> m = new ArrayList<String>();
        for (int i = 0; i < dates.size(); i++) {
            m.add(dates.get(i));
        }
        return m;
    }

    private void setBarChart(BarChart chart) {
        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker);
        chart.setDrawGridBackground(false);
        chart.setScaleEnabled(false);
        chart.setDescription("");
        chart.setDoubleTapToZoomEnabled(false);
        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.setDrawGridBackground(false);
        chart.setScaleEnabled(false);
        chart.setDrawGridBackground(false);
        chart.setDoubleTapToZoomEnabled(false);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        chart.setMarkerView(mv);
        chart.getLegend().setEnabled(false);
        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.setLabelCount(10);
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setLabelCount(10);
        chart.getAxisRight().setEnabled(true);
    }

    private void loadBarChartData(BarChart chart) {
        ArrayList<BarEntry> yVals1 = new ArrayList<>();
        ArrayList<BarEntry> yVals2 = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            yVals1.add(new BarEntry(customers.get(i), i));
        }
        for (int i = 0; i < new_customers.size(); i++) {
            yVals2.add(new BarEntry(new_customers.get(i), i));
        }
        BarDataSet set1 = new BarDataSet(yVals1, "Customer");
        set1.setDrawValues(false);
        set1.setColor(Color.rgb(57, 181, 74));
        BarDataSet set2 = new BarDataSet(yVals2, "Customer Mới");
        set2.setColor(Color.rgb(255, 139, 2));
        set2.setDrawValues(false);
        ArrayList<BarDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);
        chart.setDrawBarShadow(false);
        BarData mBarData = new BarData(getXDates(),dataSets);
        chart.setData(mBarData);
        chart.invalidate();
    }

    private LineData getLineData() {
        LineData d = new LineData();
        ArrayList<Entry> entries = new ArrayList<Entry>();
        ArrayList<Entry> entries1 = new ArrayList<>();
        for (int i = 0; i < conversation.size(); i++) {
            entries1.add(new Entry(conversation.get(i), i));
        }
        for (int i = 0; i < comment.size(); i++) {
            entries.add(new Entry(comment.get(i), i));
        }
        LineDataSet set = new LineDataSet(entries, "Comment");
        set.setColor(Color.rgb(81, 195, 211));
        set.setLineWidth(2.5f);
        set.setHighLightColor(Color.rgb(81, 195, 211));
        set.setCircleColor(Color.rgb(81, 195, 211));
        set.setCircleSize(5f);
        set.setFillColor(Color.rgb(81, 195, 211));
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setDrawValues(false);
        LineDataSet set1 = new LineDataSet(entries1, "Conversation");
        set1.setColor(Color.rgb(0, 166, 81));
        set1.setLineWidth(2.5f);
        set1.setHighLightColor(Color.rgb(0, 166, 81));
        set1.setCircleColor(Color.rgb(0, 166, 81));
        set1.setCircleSize(5f);
        set1.setFillColor(Color.rgb(0, 166, 81));
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setDrawValues(false);
        d.addDataSet(set);
        d.addDataSet(set1);
        return d;
    }

    private BarData getBarChart() {
        BarData b =new BarData();
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < likes.size(); i++) {
            entries.add(new BarEntry(likes.get(i), i));
        }
        BarDataSet dataSet = new BarDataSet(entries, "Like");
        dataSet.setColor(Color.rgb(237, 28, 36));
        b.addDataSet(dataSet);
        dataSet.setDrawValues(false);
        dataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        return b;
    }

    private void loadLineBarChart(CombinedChart mChart) {
        mChart.setDrawOrder(new CombinedChart.DrawOrder[] {
                CombinedChart.DrawOrder.BAR, CombinedChart.DrawOrder.LINE });
        YAxis rightAxis = mChart.getAxisRight();
        mChart.setDescription("");
        rightAxis.setDrawGridLines(false);
        MyMarkerView myMarkerView = new MyMarkerView(this, R.layout.custom_marker);
        mChart.setMarkerView(myMarkerView);
        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        CombinedData combinedData = new CombinedData(getXDates());
        combinedData.setData(getLineData());
        combinedData.setData(getBarChart());
        mChart.setData(combinedData);
        mChart.setHorizontalScrollBarEnabled(true);
        leftAxis.setLabelCount(10);
        rightAxis.setLabelCount(10);
        mChart.getLegend().setEnabled(false);
        mChart.setDrawValueAboveBar(false);
        mChart.invalidate();
        mChart.setDrawGridBackground(false);
        mChart.setScaleEnabled(false);
        mChart.setDrawGridBackground(false);
        mChart.setDoubleTapToZoomEnabled(false);
    }
}