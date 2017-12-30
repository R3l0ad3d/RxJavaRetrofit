
package com.example.user.orderproduct.json.login;


import com.google.gson.annotations.SerializedName;


public class LogInPojo {

    @SerializedName("error")
    private Error mError;
    @SerializedName("expires_in")
    private Long mExpiresIn;
    @SerializedName("status")
    private String mStatus;
    @SerializedName("token")
    private String mToken;

    public Error getError() {
        return mError;
    }

    public void setError(Error error) {
        mError = error;
    }

    public Long getExpiresIn() {
        return mExpiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        mExpiresIn = expiresIn;
    }

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

}
