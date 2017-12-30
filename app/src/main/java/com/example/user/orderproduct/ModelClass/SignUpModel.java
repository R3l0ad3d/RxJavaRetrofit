package com.example.user.orderproduct.ModelClass;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.example.user.orderproduct.BR;

/**
 * Created by User on 12/28/2017.
 */

public class SignUpModel extends BaseObservable{
    public final ObservableField<String> name = new ObservableField<>();
    public final ObservableField<String> email = new ObservableField<>();
    public final ObservableField<String> pass = new ObservableField<>();
    public final ObservableField<String> passConf = new ObservableField<>();

    public SignUpModel() {
    }



    public SignUpModel(String name, String email, String pass,String confPass) {
        this.name.set(name);
        this.email.set(email);
        this.pass.set(pass);
        this.passConf.set(confPass);
    }

    @Bindable
    public String getName() {
        return name.get();
    }


    public void setName(String name) {
        this.name.set(name);
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getEmail() {
        return email.get();
    }


    public void setEmail(String email) {
        this.email.set(email);
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPass() {
        return pass.get();
    }


    public void setPass(String pass) {
        this.pass.set(pass);
        notifyPropertyChanged(BR.pass);
    }

    @Bindable
    public String getPassConf() {
        return passConf.get();
    }

    public void setPassConf(String confPass){
        this.passConf.set(confPass);
        notifyPropertyChanged(BR.passConf);
    }


    @Override
    public String toString() {
        return "Name : "+getName()+"\n"+"Email : "+getEmail()+"\n"+"Password : "+getPass();
    }
}
