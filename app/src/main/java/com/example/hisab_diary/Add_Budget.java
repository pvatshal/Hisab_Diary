package com.example.hisab_diary;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Add_Budget extends AppCompatActivity {

    ArrayList<Integer> id;
    ArrayList<Double> amounts;
    ArrayList<String> tag;

    RecyclerView recyclerView;
    MyHelper myHelper;
    EditText total_budget;


    budgetAddadapter budgetAddadapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.budget_add);

          myHelper = new MyHelper(Add_Budget.this);


        id =new ArrayList<>();
        amounts =new ArrayList<>();
        tag = new ArrayList<>();

        total_budget = findViewById(R.id.total_budget_id);

        budgetAddadapter = new budgetAddadapter(Add_Budget.this,this,id,amounts,tag);


        recyclerView = findViewById(R.id.recyclerview__);

        DisplayData(myHelper);

        budgetAddadapter = new budgetAddadapter(Add_Budget.this,this,id,amounts,tag);
        recyclerView.setAdapter(budgetAddadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Add_Budget.this));



        FloatingActionButton floatingActionButton = findViewById(R.id.budget_save_id);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             ArrayList dsd =  budgetAddadapter.amount;
                System.out.println(dsd);
                for (int i=0; i<12; i++) {
                    String id = String.valueOf(budgetAddadapter.id.get(i));
                    double amount = (double) budgetAddadapter.amount.get(i);
                    String tag = String.valueOf( budgetAddadapter.tag.get(i));
                    myHelper.updateData_1(id,amount,tag);
                    Toast.makeText(Add_Budget.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Add_Budget.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

        ArrayList total = budgetAddadapter.amount;
        double total_ = sum(total);
        System.out.println(total_);
        total_budget.setText(String.valueOf(total_));

        if(budgetAddadapter.getItemCount()==0){

        }else{
            recyclerView.setBackgroundColor(getResources().getColor(R.color.white_gray));
        }
    }


    void DisplayData(MyHelper myHelper){
        Cursor cursor = myHelper.readAllData_1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id.add(cursor.getInt(0));
                amounts.add(cursor.getDouble(1));
                tag.add(cursor.getString(2));
                System.out.println(cursor.getString(2));
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

    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Discard your changes and quit editing?")
                .setPositiveButton("KEEP EDITING", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).setNegativeButton("DISCARD", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                Add_Budget.super.onBackPressed();

            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    public static double sum(List<Double> list) {
        int sum = 0;
        for (double i: list) {
            sum += i;
        }
        return sum;
    }






}
