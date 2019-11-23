package com.hci.StarkIndustries.data.remote;

public class Error {
    private int code;
    private String description;

    public Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
