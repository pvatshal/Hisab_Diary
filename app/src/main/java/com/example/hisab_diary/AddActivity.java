package com.example.hisab_diary;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddActivity extends AppCompatActivity {
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
    FloatingActionButton actionButton;
    // DatePickerDialog dpd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_transaction);

        actionButton = findViewById(R.id.imv1);
        amount = findViewById(R.id.amet);
        note_id = findViewById(R.id.note_id);
        dtv = (TextView) findViewById(R.id.dtv2);
        rbt = (RadioButton) findViewById(R.id.rb1);
        rbt1 = (RadioButton) findViewById(R.id.rb2);
        l = (LinearLayout) findViewById(R.id.lay2);
        l1 = (LinearLayout) findViewById(R.id.lay1);
        s1 = (Spinner) findViewById(R.id.spn1);
        s2 = (Spinner) findViewById(R.id.spn3);
        c1 = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
        String currentdate = format1.format(c1.getTime());
        dtv.setText(currentdate);

        dtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                //    String cud = DateFormat.getDateInstance().format(c.getTime());
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int dayofmonth = c.get(Calendar.DAY_OF_MONTH);
                dpd = new DatePickerDialog(AddActivity.this,
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
                List<String> cate = Arrays.asList("Others", "Food", "Rent", "Travelling", "Shopping", "Entertainment"
                        , "Medical", "Personal Care", "Education", "Bills", "Investments", "Taxes", "Gifts & Donation");
                radiobutton_seletion = 1;
                ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown);
                s1.setAdapter(adapter);
            }
        });


        List<String> cate = Arrays.asList("Others", "Food", "Rent", "Travelling", "Shopping", "Entertainment"
                , "Medical", "Personal Care", "Education", "Bills", "Investments", "Taxes", "Gifts & Donation");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, cate);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        s1.setAdapter(adapter);
        List<String> mat = Arrays.asList("Cash", "Card", "Others", "Wallet", "UPI", "Cheque");

        ArrayAdapter adapter1 = new ArrayAdapter(getApplicationContext(), R.layout.spinner_item_select, mat);
        adapter1.setDropDownViewResource(R.layout.spinner_dropdown);
        s2.setAdapter(adapter1);






        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String email = amount.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    amount.setError("Please Enter the Amount!!");
                } else {


                    MyHelper mydb = new MyHelper(AddActivity.this);
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
                    String Payment_method = s2.getSelectedItem().toString().trim();

                    if (note_id.getText().toString().equals("")) {
                        notes = "Not Specified";
                        System.out.println(notes);
                    }

                    System.out.println("Notes === " + notes);


                    float amount_final = (float) d;
                    String titel = "TTT";

                    System.out.println("Amount in float = " + amount_final);


                    mydb.insertData(
                            amount_final,
                            Transaction_Type,
                            tag_category,
                            current_selected_date,
                            notes,
                            format,
                            Payment_method);


                    Intent intent = new Intent(AddActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }


}