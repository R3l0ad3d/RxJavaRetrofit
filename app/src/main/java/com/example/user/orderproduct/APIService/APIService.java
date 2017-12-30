package com.example.user.orderproduct.APIService;

import com.example.user.orderproduct.ModelClass.LogInModel;
import com.example.user.orderproduct.json.login.LogInPojo;
import com.example.user.orderproduct.json.signup.SignUpPojo;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by User on 12/28/2017.
 */

public interface APIService {
    @FormUrlEncoded
    @POST("api/auth/login")
    Call<LogInPojo> getLogInRespons(@Field("email") String email, @Field("password") String password);

    //for RxJava
    @FormUrlEncoded
    @POST("api/auth/login")
    Observable<LogInPojo> getLogInResponsRx(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("api/auth/signup")
    Call<SignUpPojo.SignUpOk> getSignUpRespons(@Field("email") String email, @Field("password") String password, @Field("name") String name);

    //for RxJava
    @FormUrlEncoded
    @POST("api/auth/signup")
    Observable<SignUpPojo.SignUpOk> getSignUpResponsRx(@Field("email") String email, @Field("password") String password, @Field("name") String name);

}
