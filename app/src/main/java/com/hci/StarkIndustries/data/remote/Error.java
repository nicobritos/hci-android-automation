package com.hci.StarkIndustries.data.remote;

import java.util.ArrayList;

public class Error {
    private int code;
    private ArrayList<String> description;

    public Error(int code, ArrayList<String> description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ArrayList<String> getDescription() {
        return this.description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
}
