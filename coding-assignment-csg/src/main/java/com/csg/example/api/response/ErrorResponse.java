package com.csg.example.api.response;

public class ErrorResponse {
    private String error;
    private int status;

    public ErrorResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }

    // Getters and setters
    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}