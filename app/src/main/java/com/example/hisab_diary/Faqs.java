package com.example.hisab_diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class Faqs extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faqs);
//
//        Spinner mySpinner = findViewById(R.id.spinner1);
//
//        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.names));
//        mySpinner.setAdapter(myAdapter);
//        TextView theTextView =  findViewById(R.id.textView1);
//        String text = mySpinner.getSelectedItem().toString().trim();
//        System.out.println("TEXT = "+text);
//        theTextView.setText(text);
//
//       // mySpinner.getOnItemClickListener().
//
//        if(text.equals("How to see the balance?")){
//            theTextView.setText("ABCDEF");
//        }else if(text.equals("How to see the balance?")){
//            theTextView.setText("B");
//        }else if(text.equals("How to see weekly analysis?")){
//            theTextView.setText("C");
//        }else if(text.equals("How to see Monthly analysis?")){
//            theTextView.setText("D");
//        }else if(text.equals("How to see Yearly analysis?")){
//            theTextView.setText("E");
//        }else if(text.equals("How to view balance payment methods-wise?")){
//            theTextView.setText("F");
//        }else if(text.equals("How to add transactions?")){
//            theTextView.setText("G");
//        }else if(text.equals("How to edit or create new categories?")){
//            theTextView.setText("H");
//        }else if(text.equals("How to create budgets?")){
//            theTextView.setText("H");
//        }else {
//            theTextView.setText("None");
//        }

      //  return view;
    }



}
