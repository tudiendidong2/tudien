package com.example.noce30.cardview;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.noce30.cardview.Adapter.TuDaTraAdapter;
import com.example.noce30.cardview.Model.TuDaTra;

import java.util.ArrayList;
import java.util.List;

public class TuDaTraActivity extends AppCompatActivity {
    DBHelper db;
    private ListView lvTuDaTra;
    private List<TuDaTra> arrayTuDaTra;
    private TuDaTraAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tudatra);
        db = new DBHelper(this);
        Cursor res = db.getAllDataTDT();
        arrayTuDaTra= new ArrayList<>();
        while (res.moveToNext()) {
            TuDaTra tDT = new TuDaTra(res.getString(1), res.getString(2), res.getBlob(3));
            arrayTuDaTra.add(tDT);
        }
        lvTuDaTra=(ListView) findViewById(R.id.lv_tudatra);

        adapter = new TuDaTraAdapter(this,R.layout.item_tudatra,arrayTuDaTra);
        lvTuDaTra.setAdapter(adapter);
    }
}
