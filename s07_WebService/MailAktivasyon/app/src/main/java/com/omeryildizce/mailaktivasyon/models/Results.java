package com.omeryildizce.mailaktivasyon.models;

public class Results {
    public boolean result;

    @Override
    public String toString() {
        return "Results{" +
                "result=" + result +
                '}';
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
