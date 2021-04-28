package com.example.hisab_diary;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class budgetAddadapter extends RecyclerView.Adapter<budgetAddadapter.MyviewHolder> {

    Context context;
    ArrayList tag;
    ArrayList amount;
    ArrayList id;
    Activity activity;

    double mi=0,pl=0;
    int position;

    budgetAddadapter(Activity activity,
                   Context context,
                   ArrayList id,
                   ArrayList amount,
                   ArrayList tag){

        this.activity=activity;
        this.context = context;
        this.id=id;
        this.amount = amount;
        this.tag = tag;
    }



    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.budget_row,parent,false);
        return new MyviewHolder(view);


    }




    @Override
    public void onBindViewHolder(@NonNull final budgetAddadapter.MyviewHolder holder, final int position)  {

        this.position = position;
     //   holder.note.setText(String.valueOf(note.get(position)));
       // holder.amount.setText("$"+String.valueOf(amount.get(position)));
       // holder.date.setText(String.valueOf(date.get(position)));

        holder.tag.setText(String.valueOf(tag.get(position)));
        holder.amount.setText(String.valueOf(amount.get(position)));


        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amt = (double) amount.get(position);
                amt =amt-500;
                System.out.println(amt);
                amount.set(position,amt);
                holder.amount.setText(String.valueOf(amt));
                notifyItemChanged(position);
            }
        });
      //  notifyItemChanged(position);

        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double amt = (double) amount.get(position);
                amt =amt+500;
                System.out.println(amt);
                amount.set(position,amt);
                holder.amount.setText(String.valueOf(amt));
                notifyItemChanged(position);

            }
        });


      //  amount.set(position,Double.parseDouble(String.valueOf(holder.amount.getText())));


        if(String.valueOf(tag.get(position)).equals("Food")){
            holder.imageView.setBackgroundResource(R.drawable.food);
        }else if(String.valueOf(tag.get(position)).equals("Shopping")){
            holder.imageView.setBackgroundResource(R.drawable.shopping);
        }else if(String.valueOf(tag.get(position)).equals("Rent")){
            holder.imageView.setBackgroundResource(R.drawable.rent);
        }else if(String.valueOf(tag.get(position)).equals("Education")){
            holder.imageView.setBackgroundResource(R.drawable.education);
        }else if(String.valueOf(tag.get(position)).equals("Medical")){
            holder.imageView.setBackgroundResource(R.drawable.medical);
        }else if(String.valueOf(tag.get(position)).equals("Travelling")){
            holder.imageView.setBackgroundResource(R.drawable.travelling);
        }else if(String.valueOf(tag.get(position)).equals("Personal Care")){
            holder.imageView.setBackgroundResource(R.drawable.personalcare);
        }else if(String.valueOf(tag.get(position)).equals("Others")){
            holder.imageView.setBackgroundResource(R.drawable.other);
        }else if(String.valueOf(tag.get(position)).equals("Taxes")){
            holder.imageView.setBackgroundResource(R.drawable.taxes);
        }else if(String.valueOf(tag.get(position)).equals("Gifts & Donation")){
            holder.imageView.setBackgroundResource(R.drawable.gift);
        }else if(String.valueOf(tag.get(position)).equals("Investments")){
            holder.imageView.setBackgroundResource(R.drawable.investment);
        }else if(String.valueOf(tag.get(position)).equals("Bills")){
            holder.imageView.setBackgroundResource(R.drawable.bills);
        }else if(String.valueOf(tag.get(position)).equals("Rent")){
            holder.imageView.setBackgroundResource(R.drawable.rent);
        }else if(String.valueOf(tag.get(position)).equals("Salary")){
            holder.imageView.setBackgroundResource(R.drawable.salary);
        }else if(String.valueOf(tag.get(position)).equals("Solds")){
            holder.imageView.setBackgroundResource(R.drawable.sold);
        }else if(String.valueOf(tag.get(position)).equals("Lucky Coupons")){
            holder.imageView.setBackgroundResource(R.drawable.coupon);
        }else if(String.valueOf(tag.get(position)).equals("Other")){
            holder.imageView.setBackgroundResource(R.drawable.other);
        }else if(String.valueOf(tag.get(position)).equals("Entertainment")){
            holder.imageView.setBackgroundResource(R.drawable.entertainment);
        }







        //  final String payment_method = payment.toString().trim();

//
//        String[] stockArr = new String[payment.size()];
//        stockArr = payment.toArray(stockArr);
//
//        for(int j =0;j<payment.size();j++){
//            array[j] = (String) payment.get(j);
//        }

    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        EditText amount;
        TextView tag;
        ImageView imageView;
        ImageView minus,plus;



        ConstraintLayout constraintLayout;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            amount = itemView.findViewById(R.id.amonut_1);
            tag = itemView.findViewById(R.id.budget_category_name);
            imageView = itemView.findViewById(R.id.image_budget_id);
            minus = itemView.findViewById(R.id.minus_1);
            plus = itemView.findViewById(R.id.plus_1);

         //   minus.setOnClickListener();

        }
    }
}
