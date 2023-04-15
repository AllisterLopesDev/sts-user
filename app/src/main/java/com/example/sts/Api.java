package com.example.sts;

import com.example.sts.ModelResponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @FormUrlEncoded
    @POST("register")
    Call<RegisterResponse> register(
            @Field("username") String username,
            @Field("password") String password
    );

}
