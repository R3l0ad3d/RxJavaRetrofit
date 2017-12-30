package com.example.user.orderproduct.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.user.orderproduct.APIService.APIRespons;
import com.example.user.orderproduct.ModelClass.LogInModel;
import com.example.user.orderproduct.R;
import com.example.user.orderproduct.databinding.ActivityLogInBinding;
import com.example.user.orderproduct.json.login.LogInPojo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity extends AppCompatActivity {

    ActivityLogInBinding binding;
    LogInModel logInModel;
    APIRespons apiRespons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_log_in);

        logInModel = new LogInModel();
        binding.setLogInModel(logInModel);
        binding.setActivityLogIn(this);

        apiRespons = new APIRespons();
    }

    public void logInClick(){
        //Toast.makeText(this,binding.getLogInModel().toString(),Toast.LENGTH_LONG).show();

        if(binding.getLogInModel().geteMail().equals("")){
            binding.etEmailLogIn.setError("Empty Field Found ....");
        }else if(binding.getLogInModel().getPassWord().equals("")){
            binding.etPasswordLogIn.setError("Empty Field Found ....");
        }else {
            //retrofitCall();
            rxJavaCall();
        }
    }

    private void rxJavaCall() {
        final Observable<LogInPojo> observable = apiRespons.callLoginRx(binding.getLogInModel().geteMail(),binding.getLogInModel().getPassWord());
        observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subject<LogInPojo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LogInPojo value) {

                        Toast.makeText(getApplicationContext(),""+value.getToken(),Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    protected void subscribeActual(Observer<? super LogInPojo> observer) {

                    }

                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Override
                    public Throwable getThrowable() {
                        return null;
                    }
                });
    }

    private void retrofitCall() {
        Call<LogInPojo> call = apiRespons.callLogin(binding.getLogInModel().geteMail(),binding.getLogInModel().getPassWord());

        call.enqueue(new Callback<LogInPojo>() {
            @Override
            public void onResponse(Call<LogInPojo> call, Response<LogInPojo> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),""+response.body().getToken(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),""+response.code(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LogInPojo> call, Throwable t) {

            }
        });
    }
}
