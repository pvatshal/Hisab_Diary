package com.example.hisab_diary;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class customeAdapter extends RecyclerView.Adapter<customeAdapter.MyviewHolder>{

    private Context context;
    private ArrayList tag;
    private ArrayList amount;
    private ArrayList transaction_type;
    private ArrayList date;
    private ArrayList note;
    private ArrayList created_at;
    private ArrayList payment;
    private ArrayList id;
    Activity activity;

    int position;
MyHelper myHelper;
    customeAdapter(Activity activity,
                   Context context,
                   ArrayList id,
                   ArrayList amount,
                   ArrayList transaction_type,
                   ArrayList tag,
                   ArrayList date,
                   ArrayList note,
                   ArrayList created_at,
                   ArrayList payment){
        this.activity=activity;
        this.context = context;
        this.id=id;
        this.amount = amount;
        this.transaction_type = transaction_type;
        this.tag = tag;
        this.date = date;
        this.note = note;
        this.created_at = created_at;
        this.payment = payment;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row,parent,false);
        myHelper = new MyHelper(context);
        return new MyviewHolder(view);
    }




    @Override
    public void onBindViewHolder(@NonNull customeAdapter.MyviewHolder holder, final int position) {

        this.position = position;
        holder.note.setText(String.valueOf(note.get(position)));
        holder.amount.setText(myHelper.GetCurrency()+String.valueOf(amount.get(position)));
        holder.date.setText(String.valueOf(date.get(position)));

        if(String.valueOf(payment.get(position)).equals("Card")){
            holder.payment.setBackgroundResource(R.drawable.creditcard);
        }else if(String.valueOf(payment.get(position)).equals("Cash")){
            holder.payment.setBackgroundResource(R.drawable.money);
        }else if(String.valueOf(payment.get(position)).equals("Wallet")){
            holder.payment.setBackgroundResource(R.drawable.wallet);
        }else if(String.valueOf(payment.get(position)).equals("UPI")){
            holder.payment.setBackgroundResource(R.drawable.upi);
        }else if(String.valueOf(payment.get(position)).equals("Cheque")){
            holder.payment.setBackgroundResource(R.drawable.cheque);
        }else if(String.valueOf(payment.get(position)).equals("Others")){
            holder.payment.setBackgroundResource(R.drawable.more);
        }

        if(String.valueOf(tag.get(position)).equals("Food")){
            holder.tag.setBackgroundResource(R.drawable.food);
        }else if(String.valueOf(tag.get(position)).equals("Shopping")){
            holder.tag.setBackgroundResource(R.drawable.shopping);
        }else if(String.valueOf(tag.get(position)).equals("Rent")){
            holder.tag.setBackgroundResource(R.drawable.rent);
        }else if(String.valueOf(tag.get(position)).equals("Education")){
            holder.tag.setBackgroundResource(R.drawable.education);
        }else if(String.valueOf(tag.get(position)).equals("Medical")){
            holder.tag.setBackgroundResource(R.drawable.medical);
        }else if(String.valueOf(tag.get(position)).equals("Travelling")){
            holder.tag.setBackgroundResource(R.drawable.travelling);
        }else if(String.valueOf(tag.get(position)).equals("Personal Care")){
            holder.tag.setBackgroundResource(R.drawable.personalcare);
        }else if(String.valueOf(tag.get(position)).equals("Others")){
            holder.tag.setBackgroundResource(R.drawable.other);
        }else if(String.valueOf(tag.get(position)).equals("Taxes")){
            holder.tag.setBackgroundResource(R.drawable.taxes);
        }else if(String.valueOf(tag.get(position)).equals("Gifts & Donation")){
            holder.tag.setBackgroundResource(R.drawable.gift);
        }else if(String.valueOf(tag.get(position)).equals("Investments")){
            holder.tag.setBackgroundResource(R.drawable.investment);
        }else if(String.valueOf(tag.get(position)).equals("Bills")){
            holder.tag.setBackgroundResource(R.drawable.bills);
        }else if(String.valueOf(tag.get(position)).equals("Rent")){
            holder.tag.setBackgroundResource(R.drawable.rent);
        }else if(String.valueOf(tag.get(position)).equals("Salary")){
            holder.tag.setBackgroundResource(R.drawable.salary);
        }else if(String.valueOf(tag.get(position)).equals("Solds")){
            holder.tag.setBackgroundResource(R.drawable.sold);
        }else if(String.valueOf(tag.get(position)).equals("Lucky Coupons")){
            holder.tag.setBackgroundResource(R.drawable.coupon);
        }else if(String.valueOf(tag.get(position)).equals("Other")){
            holder.tag.setBackgroundResource(R.drawable.other);
        }else if(String.valueOf(tag.get(position)).equals("Entertainment")){
            holder.tag.setBackgroundResource(R.drawable.entertainment);
        }



        //  final String payment_method = payment.toString().trim();

//
//        String[] stockArr = new String[payment.size()];
//        stockArr = payment.toArray(stockArr);
//
//        for(int j =0;j<payment.size();j++){
//            array[j] = (String) payment.get(j);
//        }

        System.out.println(payment);
    //   final String tag__ = tag.toString().trim();
//        if (payment.contains("Cash")){
//            holder.payment.setBackgroundResource(R.drawable.ic__credit_card);
//        }


        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,update_row.class);
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("amount",String.valueOf(amount.get(position)));
                intent.putExtra("transaction_type",String.valueOf(transaction_type.get(position)));
                intent.putExtra("tag",String.valueOf(tag.get(position)));
                intent.putExtra("note",String.valueOf(note.get(position)));
                intent.putExtra("date",String.valueOf(date.get(position)));
                intent.putExtra("payment",String.valueOf(payment.get(position)));
                intent.putExtra("created_at",String.valueOf(created_at.get(position)));

                Toast.makeText(context, String.valueOf(id.get(position)), Toast.LENGTH_SHORT).show();

                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tag.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        TextView amount;
        TextView note;
        ImageView tag;
        TextView date;
        ImageView payment;

        ConstraintLayout constraintLayout;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            note = itemView.findViewById(R.id.note);
            amount = itemView.findViewById(R.id.amount);
            tag = itemView.findViewById(R.id.tag_1);
            date = itemView.findViewById(R.id.date);
            payment = itemView.findViewById(R.id.payment);


            constraintLayout = itemView.findViewById(R.id.mainlauout);


        }
    }
}
