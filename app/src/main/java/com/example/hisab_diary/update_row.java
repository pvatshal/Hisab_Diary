package com.example.hisab_diary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class update_row extends AppCompatActivity {

    TextView dtv;
    //Button dbt1;
    Calendar c;
    Calendar c1;
    RadioButton rbt;
    RadioButton rbt1;
    DatePickerDialog dpd;
    Spinner s1, s2;
    LinearLayout l, l1;
    int radiobutton_seletion = 1;
    ImageView imageView;
    EditText amount, note_id;
    String Transaction_Type = "Income";
    String date;
    double d;

    Button delete_id;



    String id_1,amount_1,transaction_Type_1,tag_1,date_1,note_1,created_at_1,payment_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_row_);

        imageView = findViewById(R.id.imv1_up);
        amount = findViewById(R.id.amet_up);
        note_id = findViewById(R.id.note_id_up);
        dtv = (TextView) findViewById(R.id.dtv2_up);
        rbt = (RadioButton) findViewById(R.id.rb1_up);
        rbt1 = (RadioButton) findViewById(R.id.rb2_up);
        l = (LinearLayout) findViewById(R.id.lay2_up);
        l1 = (LinearLayout) findViewById(R.id.lay1_up);
        s1 = (Spinner) findViewById(R.id.spn1_up);
        s2 = (Spinner) findViewById(R.id.spn3_up);
        c1 = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String currentdate = format1.format(c1.getTime());
        //dtv.setText(currentdate);


        delete_id = findViewById(R.id.delete_id);



        dtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                //    String cud = DateFormat.getDateInstance().format(c.getTime());
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int dayofmonth = c.get(Calendar.DAY_OF_MONTH);
                dpd = new DatePickerDialog(update_row.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int day) {
                                c.set(year, month, day);
                                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                                String strDate = format.format(c.getTime());
                                date = strDate;
                                dtv.setText(" " + strDate);
                            }
                        }, year, month, dayofmonth);
                dpd.show();


            }
        });


        rbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // l.setBackground();
                l.setBackgroundColor(Color.rgb(63, 85, 134));
                //l1.setBackgroundColor(Color.GRAY);
                List<String> cate = Arrays.asList("Others", "Salary", "Solds", "Lucky Coupons");

                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                radiobutton_seletion = 0;
                s1.setAdapter(adapter);
                s1.setSelection(0);
            }
        });
        rbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l.setBackgroundColor(Color.rgb(117, 117, 117));
                List<String> cate = Arrays.asList("Others", "Food", "Rent", "Travelling","Shopping","Entertainment"
                        ,"Medical","Personal Care","Education","Bills","Investments","Taxes","Gifts & Donation");
                radiobutton_seletion = 1;
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                s1.setAdapter(adapter);
            }
        });


        List<String> cate = Arrays.asList("Others", "Food", "Rent", "Travelling","Shopping","Entertainment"
                ,"Medical","Personal Care","Education","Bills","Investments","Taxes","Gifts & Donation");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        s1.setAdapter(adapter);
        List<String> mat = Arrays.asList("Cash", "Card", "Others","Wallet","UPI","Cheque");

        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, mat);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown);
        s2.setAdapter(adapter1);




        getIntentData();

        MyHelper myHelper = new MyHelper(this);
       // myHelper.updateData(id_1,am);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHelper myHelper=new MyHelper(update_row.this);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
                String format = simpleDateFormat.format(new Date());

                String am = (amount.getText().toString().trim());
                if (am.isEmpty()) {
                    d = 0;
                } else {
                    d = Double.parseDouble(am);
                }

                if (radiobutton_seletion == 0) {
                    Transaction_Type = "Income";
                } else {
                    Transaction_Type = "Expense";
                }


                System.out.println("D = " + d + "\n Transaction_type =" + Transaction_Type +
                        "\n Date = " + dtv.getText().toString().trim() + "\n Note " + note_id.getText().toString().trim() + "\n Format = " + format + "\n Payment " + s2.getSelectedItem());

                String current_selected_date = dtv.getText().toString().trim();
                String tag_category = s1.getSelectedItem().toString().trim();
                String notes = note_id.getText().toString().trim();
                if (note_id.getText().toString().equals("")){
                    notes = "Not Specified";
                    System.out.println(notes);
                }

                System.out.println("Notes === "+notes);

                String Payment_method = s2.getSelectedItem().toString().trim();

                float amount_final = (float) d;
                String titel = "TTT";

                System.out.println("Amount in float = " + amount_final);






                myHelper.updateData(
                        id_1,
                        amount_final,
                        Transaction_Type,
                        tag_category,
                        current_selected_date,
                        notes,
                        format,
                        Payment_method);


                Intent intent = new Intent(update_row.this,MainActivity.class);
                startActivity(intent);
                finish();





            }
        });



        delete_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyHelper myHelper = new MyHelper(update_row.this);
                myHelper.deleteOneRow(id_1);

                Intent intent = new Intent(update_row.this, MainActivity.class);
                startActivity(intent);


            }
        });




    }

    void getIntentData(){
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("amount") &&
                getIntent().hasExtra("transaction_type") &&
                getIntent().hasExtra("tag") &&
                getIntent().hasExtra("date") &&
                getIntent().hasExtra("note") &&
                getIntent().hasExtra("created_at") &&
                getIntent().hasExtra("payment")){


            id_1 = getIntent().getStringExtra("id");
            amount_1 = getIntent().getStringExtra("amount");
            transaction_Type_1 = getIntent().getStringExtra("transaction_type");
            tag_1 = getIntent().getStringExtra("tag");
            date_1 = getIntent().getStringExtra("date");
            note_1 = getIntent().getStringExtra("note");
            created_at_1 = getIntent().getStringExtra("created_at");
            payment_1 = getIntent().getStringExtra("payment");


            if (transaction_Type_1.equals("Income")){
                rbt.setChecked(true);
                l.setBackgroundColor(Color.rgb(63, 85, 134));
                List<String> cate = Arrays.asList("Others", "Salary", "Solds", "Lucky Coupons");

                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                radiobutton_seletion = 0;
                s1.setAdapter(adapter);
                if (tag_1.equals("Others")){
                    s1.setSelection(0);
                }else if (tag_1.equals("Salary")){
                    s1.setSelection(1);
                }
                else if (tag_1.equals("Solds")){
                    s1.setSelection(2);
                }
                else if (tag_1.equals("Lucky Coupons")){
                    s1.setSelection(3);
                }else{
                    s1.setSelection(0);
                }

               // s1.setSelection(0);
            }else{
                rbt1.setChecked(true);
                l.setBackgroundColor(Color.rgb(117, 117, 117));
                List<String> cate = Arrays.asList("Others", "Food", "Rent", "Travelling","Shopping","Entertainment"
                        ,"Medical","Personal Care","Education","Bills","Investments","Taxes","Gifts & Donation");
                radiobutton_seletion = 1;
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                s1.setAdapter(adapter);
                if (tag_1.equals("Others")){
                    s1.setSelection(0);
                }else if (tag_1.equals("Food")){
                    s1.setSelection(1);
                }else if (tag_1.equals("Rent")){
                    s1.setSelection(2);
                }else if (tag_1.equals("Travelling")){
                    s1.setSelection(3);
                }else if (tag_1.equals("Shopping")){
                    s1.setSelection(4);
                }else if (tag_1.equals("Entertainment")){
                    s1.setSelection(5);
                }else if (tag_1.equals("Medical")){
                    s1.setSelection(6);
                }else if (tag_1.equals("Personal Care")){
                    s1.setSelection(7);
                }else if (tag_1.equals("Education")){
                    s1.setSelection(8);
                }else if (tag_1.equals("Bills")){
                    s1.setSelection(9);
                }else if (tag_1.equals("Investments")){
                    s1.setSelection(10);
                }else if (tag_1.equals("Taxes")){
                    s1.setSelection(11);
                }else if (tag_1.equals("Gifts & Donation")){
                    s1.setSelection(12);
                }else{
                    s1.setSelection(0);
                }
            }


                List<String> mat = Arrays.asList("Cash", "Card", "Others","Wallet","UPI","Cheque");

                ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, mat);
                adapter1.setDropDownViewResource(R.layout.spinner_dropdown);
                s2.setAdapter(adapter1);

                if(payment_1.equals("Cash")){
                    s2.setSelection(0);
                }else if(payment_1.equals("Card")){
                    s2.setSelection(1);
                }else if(payment_1.equals("Others")){
                    s2.setSelection(2);
                }else if(payment_1.equals("Wallet")){
                    s2.setSelection(3);
                }else if(payment_1.equals("UPI")){
                    s2.setSelection(4);
                }else if(payment_1.equals("Cheque")){
                    s2.setSelection(5);
                }else{
                    s2.setSelection(0);
                }



                dtv.setText(date_1);
            amount.setText(amount_1);
            note_id.setText(note_1);





        }else{
            Toast.makeText(this, "No DATA, Sorry!!!!", Toast.LENGTH_SHORT).show();
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