package com.example.user.orderproduct.ModelClass;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;

import com.example.user.orderproduct.BR;


/**
 * Created by User on 12/28/2017.
 */

public class LogInModel extends BaseObservable{

    public ObservableField<String> eMail;
    public ObservableField<String> passWord;

    public LogInModel() {
        eMail = new ObservableField<>("");
        passWord = new ObservableField<>("");
    }

    public LogInModel(String eMail, String passWord) {
        this.eMail.set(eMail);
        this.passWord.set(passWord);
    }

    @Bindable
    public String geteMail() {
        return eMail.get();
    }

    public void seteMail(String eMail) {
        this.eMail.set(eMail);
        notifyPropertyChanged(BR.email);
    }

    @Bindable
    public String getPassWord() {
        return passWord.get();
    }

    public void setPassWord(String passWord) {
        this.passWord.set(passWord);
        notifyPropertyChanged(BR.passWord);
    }

    public boolean isConfirm(){
        if(!this.geteMail().equals("")&&!this.getPassWord().equals("")){
            return true;
        }else return false;
    }

    @Override
    public String toString() {
        return "Email : "+geteMail()+"\n"+"PassWord : "+getPassWord();
    }
}
