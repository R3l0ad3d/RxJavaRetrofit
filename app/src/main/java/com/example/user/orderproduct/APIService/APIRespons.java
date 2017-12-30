package com.example.user.orderproduct.APIService;

import com.example.user.orderproduct.json.login.LogInPojo;
import com.example.user.orderproduct.json.signup.SignUpPojo;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 12/28/2017.
 */

public class APIRespons {

    protected final static String BASE_URL="http://api.seba.ltd/";
    protected APIService apiService;
    protected Retrofit retrofit;

    public APIRespons() {
        retrofit = getRetrofit();
    }

    public Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    //for RxJava
    public Retrofit getRetrofitRx(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }

    public Call<LogInPojo> callLogin (String email, String pass){
        apiService = getRetrofit().create(APIService.class);
        Call<LogInPojo> logIn = apiService.getLogInRespons(email,pass);
        return logIn;

    }

    //For RxJava loginCall
    public Observable<LogInPojo> callLoginRx (String email, String pass){
        apiService = getRetrofitRx().create(APIService.class);
        Observable<LogInPojo> logIn = apiService.getLogInResponsRx(email,pass);
        return logIn;

    }

    public Call<SignUpPojo.SignUpOk> callSignup (String email, String pass, String name){
        apiService = getRetrofit().create(APIService.class);
        Call<SignUpPojo.SignUpOk> signUp = apiService.getSignUpRespons(email,pass,name);
        return signUp;

    }

    //For RxJava SIgnUp call
    public Observable<SignUpPojo.SignUpOk> callSignupRx (String email, String pass, String name){
        apiService = getRetrofitRx().create(APIService.class);
        Observable<SignUpPojo.SignUpOk> signUp = apiService.getSignUpResponsRx(email,pass,name);
        return signUp;

    }
}
