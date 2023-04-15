package com.example.sts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sts.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegActivity extends AppCompatActivity {


    TextView tv1;
    EditText user, pass;
    Button reg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);


        tv1 = findViewById(R.id.tv1);
        user = findViewById(R.id.username);
        pass = findViewById(R.id.pass);
        reg_btn = findViewById(R.id.reg_btn);

        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });



    }

    private void registerUser() {

        String username = user.getText().toString();
        String password = pass.getText().toString();

        //username
        if (username.isEmpty()){
            user.requestFocus();
            user.setError("Please enter your username");
            return;
        }


        //password
        if (password.isEmpty()){
            pass.requestFocus();
            pass.setError("Please enter your password");
            return;
        }
        if (password.length()<3){
            pass.requestFocus();
            pass.setError("more than 3 character required");
            return;
        }


        //validation for email
        /*if (userEmail.isEmpty()){
            email.requestFocus();
            email.setError("Please enter your email");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(userEmail).matches()){
            email.requestFocus();
            email.setError("Please enter correct email");
            return;
        }*/

        Call<RegisterResponse> call = RetrofitClient
                .getInstance()
                .getApi()
                .register(username,password);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                RegisterResponse registerResponse = response.body();
                if (response.isSuccessful()){
                    Toast.makeText(RegActivity.this, registerResponse.getMessage(), Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(RegActivity.this, registerResponse.getMessage(), Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

            }
        });

    }

}