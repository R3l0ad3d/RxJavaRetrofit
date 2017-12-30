
package com.example.user.orderproduct.json.login;


import com.google.gson.annotations.SerializedName;


public class Error {

    @SerializedName("message")
    private String mMessage;
    @SerializedName("status_code")
    private Long mStatusCode;

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Long getStatusCode() {
        return mStatusCode;
    }

    public void setStatusCode(Long statusCode) {
        mStatusCode = statusCode;
    }

}
