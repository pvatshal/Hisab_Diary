package com.example.hisab_diary;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Category_wise extends Fragment {

    ArrayList<Integer> id_1;
    ArrayList<Double> amounts_1;
    ArrayList<String> tag_1;

    budget_analysis_show_adapter budget_page_adapter;
    MyHelper myHelper;
    RecyclerView recyclerView1;

    TextView total_budget;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.budget_show_layout, container, false);



        recyclerView1 = view.findViewById(R.id.main_page_budget_id_2);
        total_budget = view.findViewById(R.id.budget_total_id);
        myHelper = new MyHelper(getContext());


        total_budget.setText(myHelper.GetCurrency()+String.valueOf(myHelper.total_budget()));
        {
            id_1 = new ArrayList<>();
            amounts_1 = new ArrayList<>();
            tag_1 = new ArrayList<>();

            budget_page_adapter = new budget_analysis_show_adapter(getActivity(), getContext(), id_1, amounts_1, tag_1);


        //    recyclerView1 = view.findViewById(R.id.main_page_budget_id);

            DisplayData_1(myHelper);

          //  budget_page_adapter = new budget_analysis_show_adapter(getActivity(), getContext(), id_1, amounts_1, tag_1);
            recyclerView1.setAdapter(budget_page_adapter);
            recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));


//            final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
//            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//            recyclerView1.setLayoutManager(layoutManager);

        }


        return view;


    }

    void DisplayData_1(MyHelper myHelper) {
        Cursor cursor = myHelper.readAllData_1();
        if (cursor.getCount() == 0) {
            //  Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                id_1.add(cursor.getInt(0));
                amounts_1.add(cursor.getDouble(1));
                tag_1.add(cursor.getString(2));
                System.out.println(cursor.getString(2));
            }
        }


    }


}
