package com.example.noce30.cardview;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class TuQuanTrong extends AppCompatActivity {
    final String DATABASE_NAME = "EmployeeDB.db";
    SQLiteDatabase database;

    ListView listView;
    ArrayList<TuDien> list;
    AdapterTuDien adapterTuDien;
    DBHelper db;
    private ImageButton btnBackTQT;
    private  ImageButton btnTimKiem;
    private  ImageButton btnTimKiemTQT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tuquantrong);
        addControls();

        readData();
        db = new DBHelper(this);
        db.createDefaultNotesIfNeed();


        btnBackTQT = (ImageButton) findViewById(R.id.btnBackTuQuanTrong);
        btnBackTQT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TuQuanTrong.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnTimKiem = (ImageButton) findViewById(R.id.btnTimKiemBK);
        btnTimKiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TuQuanTrong.this, TraAnhVietActivity.class);
                startActivity(intent);

            }
        });
        btnTimKiemTQT = (ImageButton) findViewById(R.id.btnTimKiemTQT);
        btnTimKiemTQT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText searchText = (EditText) findViewById(R.id.edtSearchAV);

               addControls();
                query(searchText.toString());

            }
        });


    }

    private void addControls() {
        listView = (ListView) findViewById(R.id.listview);
        list = new ArrayList<>();
        adapterTuDien = new AdapterTuDien(this, list);
        listView.setAdapter(adapterTuDien);
    }
    private  void  readData() {
        database = DatabaseHelper.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM TuDien", null);
        list.clear();
        for (int i = 0; i < cursor.getCount(); i++)
        {
            cursor.moveToPosition(i);
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String meanning = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            list.add(new TuDien(id, name, meanning, image));
        }
        adapterTuDien.notifyDataSetChanged();
    }
    private ArrayList<TuDien> query(String nameTQT){
        database = DatabaseHelper.initDatabase(this, DATABASE_NAME);
        String q = "SELECT * FROM TuDien WHERE name LIKE '%"+nameTQT+"%'";
        Cursor cursor = database.rawQuery(q, null);
        list = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            for (int i = 0; i < cursor.getCount(); i++)
            {
                cursor.moveToPosition(i);
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String meanning = cursor.getString(2);
                byte[] image = cursor.getBlob(3);
                list.add(new TuDien(id, name, meanning, image));
            }
        }
        return list;

    }






}




