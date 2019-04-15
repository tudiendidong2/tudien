package com.example.noce30.cardview.Model;

import android.graphics.Bitmap;

public class TuDaTra {
    public TuDaTra(String TA, String TV, byte[] img) {
        this.TA = TA;
        this.TV = TV;
        this.img = img;
    }

    public String getTA() {
        return TA;
    }

    public void setTA(String TA) {
        this.TA = TA;
    }

    public String getTV() {
        return TV;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }


    private String TA;
    private String TV;
    private byte[] img;
}
