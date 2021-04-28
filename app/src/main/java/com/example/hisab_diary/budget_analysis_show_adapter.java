package com.example.hisab_diary;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class budget_analysis_show_adapter extends RecyclerView.Adapter<budget_analysis_show_adapter.MyviewHolder>{

    Context context;
    ArrayList tag;
    ArrayList amount;
    ArrayList id;
    Activity activity;

    MyHelper myHelper;
    double mi=0,pl=0;
    int position;

    budget_analysis_show_adapter(Activity activity,
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
        View view = inflater.inflate(R.layout.budget_cate_row,parent,false);
        myHelper = new MyHelper(context);
        return new MyviewHolder(view);


    }




    @Override
    public void onBindViewHolder(@NonNull final budget_analysis_show_adapter.MyviewHolder holder, final int position)  {

        this.position = position;
        //   holder.note.setText(String.valueOf(note.get(position)));
        // holder.amount.setText("$"+String.valueOf(amount.get(position)));
        // holder.date.setText(String.valueOf(date.get(position)));

        holder.tag.setText(String.valueOf(tag.get(position)));
        //  holder.amount.setText(String.valueOf(amount.get(position)));



        double amount1 = myHelper.food_c(String.valueOf(tag.get(position)));

        double sum = ( amount1*100)/((double)amount.get(position));

        int IntValue = (int) Math. round(sum);
        holder.progressBar.setProgress(IntValue);

        double re = ((double)amount.get(position)) - amount1;

        String str = "You are "+re+" under limit.";

        holder.text.setText(str);
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




        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Category.class);
                intent.putExtra("id",String.valueOf(id.get(position)));
                intent.putExtra("amount",String.valueOf(amount.get(position)));
                intent.putExtra("tag",String.valueOf(tag.get(position)));

                Toast.makeText(context, String.valueOf(id.get(position)), Toast.LENGTH_SHORT).show();

                activity.startActivityForResult(intent,1);
            }
        });




    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {

        EditText amount;
        TextView tag;
        ImageView imageView;
        ProgressBar progressBar;

        TextView text;
        LinearLayout layout;


        ConstraintLayout constraintLayout;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            //     amount = itemView.findViewById(R.id.amonut_1);
            tag = itemView.findViewById(R.id.tag_id_2);
            imageView = itemView.findViewById(R.id.image_view_2_id);
            progressBar = itemView.findViewById(R.id.progress_id_4);
            text = itemView.findViewById(R.id.text_id_2);
            layout = itemView.findViewById(R.id.row_id_2);

            //   minus.setOnClickListener();

        }
    }
}
