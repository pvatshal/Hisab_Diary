package com.example.hisab_diary;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    TextView see_all, add_budget_id;

    ArrayList<Integer> id;
    ArrayList<Double> amounts;
    ArrayList<String> transaction_type;
    ArrayList<String> tag;
    ArrayList<String> date;
    ArrayList<String> note;
    ArrayList<String> created_at;
    ArrayList<String> payment;
    RecyclerView recyclerView1;



    ArrayList<Integer> id_1;
    ArrayList<Double> amounts_1;
    ArrayList<String> tag_1;

    TextView income_id, expense_id, total_balance_id;
    budget_page_adapter budget_page_adapter;

    String cu;
    Button week_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        System.out.println("CU = "+cu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

        View headerView = navigationView.getHeaderView(0);
        TextView Username = (TextView) headerView.findViewById(R.id.user_name_id);
        Username.setText("Guest User");
        TextView Useremail = (TextView) headerView.findViewById(R.id.user_email_id);
        Useremail.setText("Email");
        TextView signIn = (TextView) headerView.findViewById(R.id.sign_in_id);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });


        see_all = findViewById(R.id.see_all_id);
        add_budget_id = findViewById(R.id.edit_bedget_id);




        income_id = findViewById(R.id.income_id);
        expense_id = findViewById(R.id.expense_id);
        total_balance_id = findViewById(R.id.total_balanca_id);




        toggle.syncState();

        if (Build.VERSION.SDK_INT >= 21) {
            System.out.println("Hello");
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_layout,
                    new see_all_fragment()).addToBackStack(null).commit();
            navigationView.setCheckedItem(R.id.dashboard);
        }

        // week_ = findViewById(R.id.weekly_id);




        final MyHelper myHelper = new MyHelper(MainActivity.this);

        FloatingActionButton floatingActionButton = findViewById(R.id.add_id);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddActivity.class);
                startActivity(intent);
                //    System.out.println(myHelper.food_c("Food"));
            }
        });

//        week_.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,Week_Analysis.class);
//                startActivity(intent);
//            }
//        });


        {

            customeAdapter customeAdapter;

            id = new ArrayList<>();
            amounts = new ArrayList<>();
            transaction_type = new ArrayList<>();
            tag = new ArrayList<>();
            date = new ArrayList<>();
            note = new ArrayList<>();
            created_at = new ArrayList<>();
            payment = new ArrayList<>();


            RecyclerView recyclerView = findViewById(R.id.recyclerview);

            DisplayData(myHelper);

            customeAdapter = new customeAdapter(MainActivity.this, this, id, amounts, transaction_type, tag, date, note, created_at, payment);
            recyclerView.setAdapter(customeAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

            if (customeAdapter.getItemCount() == 0) {
            } else {
                recyclerView.setBackgroundColor(getResources().getColor(R.color.white1));
            }
        }

        {
            recyclerView1 = findViewById(R.id.recyclerview_1);
            id_1 =new ArrayList<>();
            amounts_1 =new ArrayList<>();
            tag_1 = new ArrayList<>();


            budget_page_adapter  = new budget_page_adapter(MainActivity.this,this,id_1,amounts_1,tag_1);


            recyclerView1= findViewById(R.id.main_page_budget_id);

            DisplayData_1(myHelper);

            budget_page_adapter = new budget_page_adapter(MainActivity.this,this,id_1,amounts_1,tag_1);
            recyclerView1.setAdapter(budget_page_adapter);
            recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
          //  recyclerView1.setLayoutManager(new LinearLayoutManager(this));



        }






        see_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,All_transaction.class);
                startActivity(intent);
            //    finish();

            }
        });

        add_budget_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Add_Budget.class);
                startActivity(intent);
               // finish();

            }
        });



        float ex = myHelper.sumTheExpense();
        System.out.println(ex);
     //   expense_id.setText("$"+String.valueOf(ex));
        expense_id.setText(myHelper.GetCurrency()+String.valueOf(ex));

        float in = myHelper.sumTheIncome();
        System.out.println(in);
        income_id.setText(myHelper.GetCurrency()+String.valueOf(in));


        float total = in-ex;
        System.out.println(total);


        if (total < 0 ){
            float total_ = Math.abs(total);
            total_balance_id.setText("- "+myHelper.GetCurrency()+String.valueOf(total_));
        }else{
            total_balance_id.setText(myHelper.GetCurrency()+String.valueOf(total));

        }







    }




    void DisplayData(MyHelper myHelper){
        Cursor cursor = myHelper.readAllData_3_rows();
        if(cursor.getCount()==0){
            Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }





    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
              // this.finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.dashboard:
                startActivity( new Intent(MainActivity.this,MainActivity.class));

                break;
            case R.id.all_transaction:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new see_all_fragment()).addToBackStack(null).commit();
                break;
            case R.id.categories:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Category()).addToBackStack(null).commit();
                break;
            case R.id.budget:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Category_wise()).addToBackStack(null).commit();
                break;
            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Setting()).addToBackStack(null).commit();
                break;
            case R.id.monthly_report_id:
               Intent intent = new Intent(MainActivity.this,Month_Analysis.class);
                startActivity(intent);
                break;
            case R.id.weekly_report_id:
               Intent intent1 = new Intent(MainActivity.this,Week_Analysis.class);
                startActivity(intent1);
                break;
            case R.id.yearly_report_id:
                Intent intent2 = new Intent(MainActivity.this,Year_Analysis.class);
                startActivity(intent2);
                break;





        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }


    void DisplayData_1(MyHelper myHelper){
        Cursor cursor = myHelper.readAllData_1();
        if(cursor.getCount()==0){
            Toast.makeText(this, "There is no DATA", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                id_1.add(cursor.getInt(0));
                amounts_1.add(cursor.getDouble(1));
                tag_1.add(cursor.getString(2));
                System.out.println(cursor.getString(2));
            }
        }


    }
}
