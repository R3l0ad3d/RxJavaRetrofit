package com.example.user.orderproduct.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.user.orderproduct.APIService.APIRespons;
import com.example.user.orderproduct.ModelClass.SignUpModel;
import com.example.user.orderproduct.R;
import com.example.user.orderproduct.databinding.ActivitySignUpBinding;
import com.example.user.orderproduct.json.signup.SignUpPojo;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    ActivitySignUpBinding binding;
    SignUpModel signUpModel;

    APIRespons apiRespons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_up);
        signUpModel = new SignUpModel("","","","");

        binding.setObjSignUp(signUpModel);
        binding.setActivity(this);

        init();
    }

    private void init() {
        apiRespons = new APIRespons();
        progressDialog = new ProgressDialog(this);
    }

    public void signUpClick(){
        //retrpfitCall();
        retrofitRxjavaCall();

    }

    private void retrofitRxjavaCall() {
        progressDialog.show();
        if(binding.getObjSignUp().getName().equals("")){
            binding.etNameSignUp.setError("Empty Field Found ...");
            progressDialog.dismiss();
        }else if(binding.getObjSignUp().getEmail().equals("")){
            binding.etEmailSignUp.setError("Empty Field Found ...");
            progressDialog.dismiss();
        }else if(!binding.getObjSignUp().getPass().equals(binding.getObjSignUp().getPassConf())){
            binding.etConfirmPasswordSIgnUp.setError("Password Not Match ...");
            progressDialog.dismiss();
        }else {
            io.reactivex.Observable<SignUpPojo.SignUpOk> observable = apiRespons.
                    callSignupRx(binding.getObjSignUp().getEmail(),binding.getObjSignUp().getPass(),binding.getObjSignUp().getName());
            observable.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subject<SignUpPojo.SignUpOk>() {
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

                        @Override
                        protected void subscribeActual(Observer<? super SignUpPojo.SignUpOk> observer) {

                        }

                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(SignUpPojo.SignUpOk value) {
                            Toast.makeText(getApplicationContext(),""+value.getStatus(),Toast.LENGTH_LONG).show();


                        }

                        @Override
                        public void onError(Throwable e) {
                            Toast.makeText(getApplicationContext(),""+e.getMessage(),Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onComplete() {
                            progressDialog.dismiss();
                        }
                    });
        }
    }

    private void retrpfitCall() {
        progressDialog.show();
        if(binding.getObjSignUp().getName().equals("")){
            binding.etNameSignUp.setError("Empty Field Found ...");
            progressDialog.dismiss();
        }else if(binding.getObjSignUp().getEmail().equals("")){
            binding.etEmailSignUp.setError("Empty Field Found ...");
            progressDialog.dismiss();
        }else if(!binding.getObjSignUp().getPass().equals(binding.getObjSignUp().getPassConf())){
            binding.etConfirmPasswordSIgnUp.setError("Password Not Match ...");
            progressDialog.dismiss();
        }else {
            Call<SignUpPojo.SignUpOk> call = apiRespons.callSignup(binding.getObjSignUp().getEmail(),binding.getObjSignUp().getPass(),binding.getObjSignUp().getName());

            call.enqueue(new Callback<SignUpPojo.SignUpOk>() {
                @Override
                public void onResponse(Call<SignUpPojo.SignUpOk> call, Response<SignUpPojo.SignUpOk> response) {
                    if(response.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"Request Success",Toast.LENGTH_LONG).show();

                        Toast.makeText(getApplicationContext(),""+response.body().getStatus(),Toast.LENGTH_LONG).show();


                    }else {
                        Toast.makeText(getApplicationContext(),"Duplicate E-Mail Found ..."/*+response.code()+" \n"+response.body()*/,Toast.LENGTH_LONG).show();
                    }

                    progressDialog.dismiss();
                }


                @Override
                public void onFailure(Call<SignUpPojo.SignUpOk> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage().toString(),Toast.LENGTH_LONG).show();
                }
            });
        }
    }

}
