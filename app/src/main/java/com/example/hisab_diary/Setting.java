package com.example.hisab_diary;

import android.app.Activity;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;


public class Setting extends Fragment {


    LinearLayout layout, layout1, layout2, layout3;

    String[] c1 = new String[]{"₹", "$", "£", "€"};
    TextView cu;
    public static final String SHARED_PREFS = "SharedPrefs";
    public static final String TEXT = "text";

    MyHelper myHelper;

    ArrayList<String> country_name;
    ArrayList<String> country_currency;
    TextView change;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.setting,container,false);


        myHelper = new MyHelper(getContext());


        layout = view.findViewById(R.id.app_intro_layout_id);
        layout1 = view.findViewById(R.id.faqs_layout_id);
        change = view.findViewById(R.id.id_123);
        layout2 = view.findViewById(R.id.about_us_id);
        layout3 = view.findViewById(R.id.contact_us_id);



        layout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), About_Us.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);

            }
        });
        layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Contact_Us.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);

            }
        });


        cu = view.findViewById(R.id.cu_id);

        country_name =new ArrayList<>();
        country_currency = new ArrayList<>();

        cu.setText(myHelper.GetCurrency());

        System.out.println(country_name);


    //    currency.getSelectedItem()

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), IntroActivity01.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);

            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Settings_123.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);

            }
        });

//     currency.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//         @Override
//         public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
//             Object item = adapterView.getItemAtPosition(position);
//             cu.setText(currency.getSelectedItem().toString().trim());
//             System.out.println("HELLO = "+item.toString());
//
//             myHelper.Set_Value_To_1(item.toString());
//
//             Intent intent1 = new Intent("Id").putExtra("id",item.toString().trim());
//             LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent1);
//
//
//
//         }
//
//         @Override
//         public void onNothingSelected(AdapterView<?> adapterView) {
//
////         }
//     });


        layout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             //   Fragment fragment = new tasks();
                Intent i = new Intent(getActivity(), Faqs.class);
                startActivity(i);
                ((Activity) getActivity()).overridePendingTransition(0, 0);

            }
        });

        return view;
    }







}
