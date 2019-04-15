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
            this.showText(res.getString(1), res.getString(2), res.getString(4));
            boolean isExist = db.kiemTraDataTDT(keySearch);
            if(!isExist) {
                db.insertDataTDT(res.getString(1), res.getString(2), res.getBlob(3), res.getString(4));
            }
        }
    }

    public void showText(String anh,String viet, String viDu){
        TextView textEnglish = (TextView)findViewById(R.id.txtTuTiengViet);
        TextView textVN = (TextView)findViewById(R.id.txtTuTiengAnh);
        TextView textVD = (TextView)findViewById(R.id.txtViDu);

        textEnglish.setText(anh);
        textVN.setText(viet);
        textVD.setText(viDu);
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuImage) {
            Intent intent=new Intent(TiengAnhActivity.this, ImageActivity.class);
            String keySearch = getIntent().getStringExtra("keySearch");
            intent.putExtra("key", keySearch);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
            return true;
        }

        return true;
    }
}
