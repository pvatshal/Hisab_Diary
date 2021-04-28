package com.example.hisab_diary;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Settings_123 extends AppCompatActivity {



    Spinner currency;

    String[] c1 = new String[]{"₹", "$", "£", "€"};
    TextView cu;
    public static final String SHARED_PREFS = "SharedPrefs";
    public static final String TEXT = "text";

    MyHelper myHelper;

    ArrayList<String> country_name;
    ArrayList<String> country_currency;
    FloatingActionButton save;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_currency);



        myHelper = new MyHelper(this);

        save = findViewById(R.id.save_id_1);

        currency = findViewById(R.id.spinner_123);

        cu =findViewById(R.id.cu_id_1);

        country_name =new ArrayList<>();
        country_currency = new ArrayList<>();

        DisplayData(myHelper);


        System.out.println(country_name);

        {
            //   List<String> cate = Arrays.asList(objects);
            List<String> cate1 = country_name;

        //       ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item_select, names);
            List<String> cate = Arrays.asList("Others", "Salary", "Solds", "Lucky Coupons", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds", "Solds");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, country_name);
          //  ArrayAdapter adapter = new ArrayAdapter(this, R.layout.spinner_item_select, cate);

            adapter.setDropDownViewResource(R.layout.spinner_dropdown);
            currency.setAdapter(adapter);

            int id = myHelper.get_id_of_current_currency();
            currency.setSelection(id);
            System.out.println("ID = "+id);

        }

        //    currency.getSelectedItem()
     //   System.out.println("HELLO = "+currency.getSelectedItem().toString().trim());
       // cu.setText(currency.getSelectedItem().toString().trim());
        cu.setText(myHelper.GetCurrency());

     currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
         @Override
         public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
             Object item = adapterView.getItemAtPosition(position);
             cu.setText(currency.getSelectedItem().toString().trim());
             System.out.println("HELLO = "+item.toString());
                name = item.toString();

         }

         @Override
         public void onNothingSelected(AdapterView<?> adapterView) {

         }
     });

     save.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String name1 = name;
             if (name1.isEmpty()){

             }else{
                 myHelper.Set_Value_To_1(name1);
                 Toast.makeText(Settings_123.this, "Currency has been changed", Toast.LENGTH_SHORT).show();
                 Intent intent = new Intent(Settings_123.this,MainActivity.class);
                 startActivity(intent);

             }
         }
     });



}





    void DisplayData(MyHelper myHelper){
        Cursor cursor = myHelper.readAllData_Currency();
        if(cursor.getCount()==0){
            //  Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){

                country_name.add((cursor.getString(1)));
                country_currency.add(cursor.getString(2));

            }
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

                Settings_123.super.onBackPressed();

            }
        });


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }



}
