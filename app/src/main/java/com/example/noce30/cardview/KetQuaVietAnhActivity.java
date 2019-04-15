package com.example.noce30.cardview;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class KetQuaVietAnhActivity extends AppCompatActivity {
    DBHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBHelper(this);
        setContentView(R.layout.layout_ketquavietanh);
        this.showSearchResult();
    }

    public void showSearchResult() {
        String keySearch= getIntent().getStringExtra("keySearchTV");
        Cursor res = db.getTV(keySearch);
        if(res.getCount() == 0) {
            // show message
            showMessage("Thông báo","Không tìm thấy từ " + keySearch);
            return;
        }

        while (res.moveToNext()) {
            this.showText(res.getString(1), res.getString(2), res.getString(2), res.getString(4));
        }
    }

    public void showText(String anh,String showviet, String viet, String viDu){
        TextView textViet = (TextView) findViewById(R.id.vaText);

        TextView textTV = (TextView)findViewById(R.id.txtTV);
        TextView textTA = (TextView)findViewById(R.id.txtTA);
        TextView textVD = (TextView)findViewById(R.id.txtVD);

        textViet.setText(showviet);
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
