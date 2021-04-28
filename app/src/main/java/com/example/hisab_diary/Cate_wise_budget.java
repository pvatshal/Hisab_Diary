package com.example.hisab_diary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

public class Cate_wise_budget extends AppCompatActivity {


    String id_1, amount_1, tag_1;
    TextView category_name;
    ArrayList<Integer> id;
    ArrayList<Double> amounts;
    ArrayList<String> transaction_type;
    ArrayList<String> tag;
    ArrayList<String> date;
    ArrayList<String> note;
    ArrayList<String> created_at;
    ArrayList<String> payment;
    MyHelper myHelper;
    TextView amount;
    double budget_;
    ProgressBar progressBar;
    TextView text1;
    TextView no_of_transaction, per_day, per_transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_wise_layout);

        category_name = findViewById(R.id.caregory_name_id_1);
              amount        = findViewById(R.id.amount_category_1);
              progressBar = findViewById(R.id.progress_id_3);
                text1 = findViewById(R.id.text_category_1);
                no_of_transaction = findViewById(R.id.no_of_trans_id);
                per_day = findViewById(R.id.per_day_id);
                per_transaction = findViewById(R.id.per_transaction_id);


        if (getIntent().hasExtra("id") &&
                getIntent().hasExtra("amount") &&
                getIntent().hasExtra("tag")) {


            id_1 = getIntent().getStringExtra("id");
            amount_1 = getIntent().getStringExtra("amount");
            tag_1 = getIntent().getStringExtra("tag");


            category_name.setText(tag_1);
            myHelper = new MyHelper(this);




            double amt = myHelper.food_c(tag_1);
            amount.setText(String.valueOf(amt));

            budget_ = Double.parseDouble(amount_1);

            double sum = ( amt*100)/budget_;

            int IntValue = (int) Math. round(sum);
                progressBar.setProgress(IntValue);
            double re = budget_ - amt;

            String str = "You are "+re+" under limit.";

            text1.setText(str);


            {

                customeAdapter customeAdapter;

                id = new ArrayList<>();
                amounts = new ArrayList<>();
                transaction_type = new ArrayList<>();
                tag = new ArrayList<>();
                date = new ArrayList<>();
                note = new ArrayList<>();
                created_at = new ArrayList<>();
                payment = new ArrayList<>();


                RecyclerView recyclerView = findViewById(R.id.recyclerview_3);

                DisplayData(myHelper);

                customeAdapter = new customeAdapter(Cate_wise_budget.this, this, id, amounts, transaction_type, tag, date, note, created_at, payment);
                recyclerView.setAdapter(customeAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true));

                no_of_transaction.setText(String.valueOf(customeAdapter.getItemCount()));
                per_transaction.setText(myHelper.GetCurrency()+String.valueOf(amt/customeAdapter.getItemCount()));

                Date d=new Date();
                System.out.println("day of the week is : "+d.getDay());
                per_day.setText(myHelper.GetCurrency()+String.valueOf(amt/d.getDate()));

                if (customeAdapter.getItemCount() == 0) {
                } else {
                    recyclerView.setBackgroundColor(getResources().getColor(R.color.white1));
                }


            }


        }


    }


    void DisplayData(MyHelper myHelper) {
        Cursor cursor = myHelper.readCategorData(tag_1);
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
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

}
