package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegActivity extends AppCompatActivity {


    TextView tv1;
    EditText username, pass;
    Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        tv1 = findViewById(R.id.tv1);
        username = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        reg_btn = findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i  = new Intent(getApplicationContext(), RegActivity.class);
                startActivity(i);
            }
        });


    }
}