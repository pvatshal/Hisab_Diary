package com.example.hisab_diary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Month_Analysis extends AppCompatActivity {

    ArrayList<Integer> id;
    ArrayList<Double> amounts;
    ArrayList<String> transaction_type;
    ArrayList<String> tag;
    ArrayList<String> date;
    ArrayList<String> note;
    ArrayList<String> created_at;
    ArrayList<String> payment;

    TextView income,expense;

    TextView no_of_transaction, per_day, per_transaction;
    TextView h1,h2;


    String[] months = {"Others", "Food", "Rent", "Travelling","Shopping","Entertainment"
            ,"Medical","Personal Care","Education","Bills","Investments","Taxes","Gifts & Donation"};
    int[] earn = {0,0,0,0,0,0,0,0,0,0,0,0,0};

    AnyChartView anyChartView;
    MyHelper myHelper;
    float no;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_report);

        anyChartView = findViewById(R.id.chart_id);
        h1 = findViewById(R.id.heading_1_id);
        h2 = findViewById(R.id.heading_2_id);


        income = findViewById(R.id.income_id_1);
        expense = findViewById(R.id.expense_id_1);
        no_of_transaction = findViewById(R.id.no_of_trans_id_1);
        per_day = findViewById(R.id.per_day_id_1);
        per_transaction = findViewById(R.id.per_transaction_id_1);


        myHelper = new MyHelper(this);

        h1.setText("Month Analysis");
        h2.setText("April");




        customeAdapter customeAdapter;

        id =new ArrayList<>();
        amounts =new ArrayList<>();
        transaction_type =new ArrayList<>();
        tag = new ArrayList<>();
        date =new ArrayList<>();
        note =new ArrayList<>();
        created_at =new ArrayList<>();
        payment =new ArrayList<>();




        RecyclerView recyclerView = findViewById(R.id.recyclerview_2);

        DisplayData(myHelper);

        customeAdapter = new customeAdapter(Month_Analysis.this,this,id,amounts,transaction_type,tag,date,note,created_at,payment);
        recyclerView.setAdapter(customeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        no_of_transaction.setText(String.valueOf(customeAdapter.getItemCount()));
        per_transaction.setText(myHelper.GetCurrency()+String.valueOf(no/customeAdapter.getItemCount()));


        if(customeAdapter.getItemCount()==0){


        }else{
            recyclerView.setBackgroundColor(getResources().getColor(R.color.white1));
        }


        piechartsetup();



    }

    void DisplayData(MyHelper myHelper){

        Calendar cal = Calendar.getInstance();
        int res = cal.getActualMaximum(Calendar.DATE);
    //    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Today's Date = " + cal.getTime());

        System.out.println("Last Date of the current month = " + res);
        int k =1;
        String da1 = String.valueOf((k));
        String da2 = String.valueOf((res));
        da1 = "01-04-2021";
        da2 = "30-04-2021";

        System.out.println(da1+" DA "+da2);
        expense.setText(myHelper.GetCurrency()+String.valueOf(myHelper.sumTheExpenseWeek(da1,da2)));
      //  expense.setText(myHelper.GetCurrency()+String.valueOf(myHelper.sumTheExpenseWeek(da1,da2)));
        income.setText(myHelper.GetCurrency()+String.valueOf(myHelper.sumTheIncomeWeek(da1,da2)));

        float e = myHelper.sumTheExpenseWeek(da1,da2);
        float i = myHelper.sumTheIncomeWeek(da1,da2);

            no = i-e;
            per_day.setText(myHelper.GetCurrency()+String.valueOf(e/7));

        Cursor cursor = myHelper.readAllData_week(da1,da2);
        if(cursor.getCount()==0){
            Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id.add(cursor.getInt(0));
                amounts.add(cursor.getDouble(1));
                transaction_type.add((cursor.getString(2)));
                tag.add(cursor.getString(3));
                date.add((cursor.getString(4)));
                note.add((cursor.getString(5)));
                created_at.add((cursor.getString(6)));
                payment.add((cursor.getString(7)));




            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }


    public void piechartsetup(){

        for (int i=0;i<months.length;i++){
            System.out.println(months[i]);
            System.out.println(myHelper.food_c("Food"));
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

}


