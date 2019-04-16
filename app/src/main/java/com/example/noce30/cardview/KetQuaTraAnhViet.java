package com.example.noce30.cardview;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class KetQuaTraAnhViet extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketqua_anhviet);
        db = new DBHelper(this);

        this.showSearchResult();
    }

    public void showSearchResult() {
        String keySearch= getIntent().getStringExtra("keySearchTV");
        Cursor res = db.getAllData(keySearch);
        if(res.getCount() == 0) {
            // show message
            showMessage("Thông báo","Không tìm thấy từ " + keySearch);
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            this.showText(res.getString(2), res.getString(1), res.getString(4));
        }
    }

    public void showText(String anh,String viet, String viDu){
        TextView textTV = (TextView)findViewById(R.id.txtTV);
        TextView textTA = (TextView)findViewById(R.id.txtTA);
        TextView textVD = (TextView)findViewById(R.id.txtVD);

        textTV.setText(viet);
        textTA.setText(anh);
        textVD.setText(viDu);

    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
