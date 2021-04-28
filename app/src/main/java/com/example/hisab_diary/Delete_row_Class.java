package com.example.hisab_diary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Delete_row_Class extends AppCompatActivity {

    Button delete;
    EditText id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_row_layout);

        delete = findViewById(R.id.delete_button);
        id = findViewById(R.id.number_id);



        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                System.out.println("id = = = "+id.getText().toString().trim());

                MyHelper myHelper = new MyHelper(Delete_row_Class.this);
                myHelper.deleteOneRow(id.getText().toString().trim());

                Intent intent = new Intent(Delete_row_Class.this, MainActivity.class);
                startActivity(intent);


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
