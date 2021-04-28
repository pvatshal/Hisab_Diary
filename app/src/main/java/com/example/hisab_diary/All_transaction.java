package com.example.hisab_diary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class All_transaction extends AppCompatActivity {


    ArrayList<Integer> id;
    ArrayList<Double> amounts;
    ArrayList<String> transaction_type;
    ArrayList<String> tag;
    ArrayList<String> date;
    ArrayList<String> note;
    ArrayList<String> created_at;
    ArrayList<String> payment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_transactions_layout);



        MyHelper myHelper = new MyHelper(All_transaction.this);

        customeAdapter customeAdapter;

        id =new ArrayList<>();
        amounts =new ArrayList<>();
        transaction_type =new ArrayList<>();
        tag = new ArrayList<>();
        date =new ArrayList<>();
        note =new ArrayList<>();
        created_at =new ArrayList<>();
        payment =new ArrayList<>();


        RecyclerView recyclerView = findViewById(R.id.recyclerview_1);

        DisplayData(myHelper);

        customeAdapter = new customeAdapter(All_transaction.this,this,id,amounts,transaction_type,tag,date,note,created_at,payment);
        recyclerView.setAdapter(customeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        if(customeAdapter.getItemCount()==0){


        }else{
            recyclerView.setBackgroundColor(getResources().getColor(R.color.white_gray));
        }





    }


    void DisplayData(MyHelper myHelper){
        Cursor cursor = myHelper.readAllData();
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




}
