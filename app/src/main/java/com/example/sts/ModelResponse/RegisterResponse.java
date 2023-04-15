package com.example.sts.ModelResponse;

public class RegisterResponse {
String error;
String message;
String token;


// if user exist
    public RegisterResponse(String error, String message) {
        this.error = error;
        this.message = message;
    }


// if user doesnt exist
    public RegisterResponse(String error, String message, String token) {
        this.error = error;
        this.message = message;
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
