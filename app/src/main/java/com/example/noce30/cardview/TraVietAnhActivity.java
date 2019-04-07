package com.example.noce30.cardview;

//Lê Văn Hoàng - cập nhật 14:05 07/04/2019


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class TraVietAnhActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tratiengviet);

//        toolbar = (Toolbar) findViewById(R.id.toolBar);
//        getSupportActionBar().setTitle("Text");
//        toolbar.setNavigationIcon(R.drawable.ic_back_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ketquaanhviet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg = "";
        switch (item.getItemId()) {
            case R.id.search:
                msg = "Search";
                break;
            case R.id.note:
                msg = "Note";
                break;
            case R.id.save:
                msg = "Save";
                break;
        }

        Toast.makeText(this, msg+" Checked", Toast.LENGTH_LONG).show();

        return super.onOptionsItemSelected(item);
    }
}
