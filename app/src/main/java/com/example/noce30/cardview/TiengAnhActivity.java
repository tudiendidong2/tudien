package com.example.noce30.cardview;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class TiengAnhActivity extends AppCompatActivity {
    DBHelper db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBHelper(this);
        setContentView(R.layout.layout_tienganh);
        this.showSearchResult();
    }

    public void showSearchResult() {
        String keySearch= getIntent().getStringExtra("keySearch");
        Cursor res = db.getAllData(keySearch);
        if(res.getCount() == 0) {
            // show message
            showMessage("Thông báo","Không tìm thấy từ " + keySearch);
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            this.showText(res.getString(1), res.getString(2));
        }
    }

    public void showText(String anh,String viet){
        TextView textEnglish = (TextView)findViewById(R.id.txtTuTiengViet);
        TextView textVN = (TextView)findViewById(R.id.txtTuTiengAnh);
        textEnglish.setText(anh);
        textVN.setText(viet);
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
