package com.example.user.orderproduct.json.signup;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 12/30/2017.
 */

public class SignUpPojo {

    public static class SignUpOk {

        @SerializedName("status")
        private String mStatus;

        public String getStatus() {
            return mStatus;
        }

        public void setStatus(String status) {
            mStatus = status;
        }

    }

    public static class Error {

        @SerializedName("code")
        private String mCode;
        @SerializedName("message")
        private String mMessage;
        @SerializedName("status_code")
        private Long mStatusCode;

        public String getCode() {
            return mCode;
        }

        public void setCode(String code) {
            mCode = code;
        }

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

    public static class SignUpError {

        @SerializedName("error")
        private Error mError;

        public Error getError() {
            return mError;
        }

        public void setError(Error error) {
            mError = error;
        }

    }
}
