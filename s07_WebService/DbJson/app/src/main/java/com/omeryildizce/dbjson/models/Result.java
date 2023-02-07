package com.omeryildizce.dbjson.models;

public class Result {
    private String result ;

    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
