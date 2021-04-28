package com.example.hisab_diary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;


public class Charts extends Fragment {

    String[] months = {"Others", "Food", "Rent", "Travelling","Shopping","Entertainment"
            ,"Medical","Personal Care","Education","Bills","Investments","Taxes","Gifts & Donation"};
    int[] earn = {0,0,0,0,0,0,0,0,0,0,0,0,0};

    String[] payment_methods = {"Cash", "Card", "Others","Wallet","UPI","Cheque"};
    int[] earn1 = {0,0,0,0,0,0};

    AnyChartView anyChartView , anyChartView1;
    MyHelper myHelper;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.charts_1,container,false);


        anyChartView = view.findViewById(R.id.chart_id_1);
        anyChartView1 = view.findViewById(R.id.chart_id_2);


        myHelper = new MyHelper(getContext());



        piechartsetup();

        piechartsetup1();



        return view;




    }
     void piechartsetup(){

        for (int i=0;i<months.length;i++){
            System.out.println(months[i]);
          //  System.out.println(myHelper.food_c("Food"));
            earn[i] = (int) myHelper.food_c(months[i]);
            System.out.println(earn[i]);
        }



        Pie pie = AnyChart.pie();

        List<DataEntry> dara = new ArrayList<>();

        for (int i=0; i <months.length;i++ ){
            dara.add(new ValueDataEntry(months[i],earn[i]));
        }

        pie.data(dara);
        anyChartView.setChart(pie);


    }
     void piechartsetup1(){

        for (int i=0;i<payment_methods.length;i++){
            System.out.println(payment_methods[i]);
          //  System.out.println(myHelper.food_c("Food"));
            earn1[i] = (int) myHelper.food_p(payment_methods[i]);
            System.out.println(earn1[i]);
        }



        Pie pie = AnyChart.pie();

        List<DataEntry> dara = new ArrayList<>();

        for (int i=0; i <payment_methods.length;i++ ){
            dara.add(new ValueDataEntry(payment_methods[i],earn1[i]));
        }

        pie.data(dara);
        anyChartView1.setChart(pie);
    }



}
