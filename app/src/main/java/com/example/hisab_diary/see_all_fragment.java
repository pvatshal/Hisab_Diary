package com.example.hisab_diary;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class see_all_fragment extends Fragment {

    ArrayList<Integer> id;
    ArrayList<Double> amounts;
    ArrayList<String> transaction_type;
    ArrayList<String> tag;
    ArrayList<String> date;
    ArrayList<String> note;
    ArrayList<String> created_at;
    ArrayList<String> payment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.all_transactions_layout,container,false);


        MyHelper myHelper = new MyHelper(getContext());

        customeAdapter customeAdapter;

        id =new ArrayList<>();
        amounts =new ArrayList<>();
        transaction_type =new ArrayList<>();
        tag = new ArrayList<>();
        date =new ArrayList<>();
        note =new ArrayList<>();
        created_at =new ArrayList<>();
        payment =new ArrayList<>();


        RecyclerView recyclerView = view.findViewById(R.id.recyclerview_1);

        DisplayData(myHelper);

        customeAdapter = new customeAdapter(getActivity(),getContext(),id,amounts,transaction_type,tag,date,note,created_at,payment);
        recyclerView.setAdapter(customeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        if(customeAdapter.getItemCount()==0){


        }else{
            recyclerView.setBackgroundColor(getResources().getColor(R.color.white_gray));
        }


     return view;


    }


    void DisplayData(MyHelper myHelper){
        Cursor cursor = myHelper.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(getActivity(), "There is no DATA", Toast.LENGTH_SHORT);
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





}
