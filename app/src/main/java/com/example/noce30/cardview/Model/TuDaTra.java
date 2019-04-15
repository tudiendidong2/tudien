package com.example.noce30.cardview.Model;

public class TuDaTra {
    public TuDaTra(boolean isMale, String mName, String mNumber) {
        this.isMale = isMale;

        this.mName = mName;
        this.mNumber = mNumber;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmNumber() {
        return mNumber;
    }

    public void setmNumber(String mNumber) {
        this.mNumber = mNumber;
    }

    private boolean isMale;
    private String mName;
    private String mNumber;
}
