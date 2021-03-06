package com.example.noce30.cardview;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<Integer> mImageUrls = new ArrayList<>();

    private ImageView img;
    DBHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init data
        db = new DBHelper(this);
        db.createDefaultNotesIfNeed();

        img=(ImageView) findViewById(R.id.imgSearchTA);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TiengAnhActivity.class);
                EditText searchText =  (EditText) findViewById(R.id.etSearch);
                intent.putExtra("keySearch", searchText.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        getImages();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add(R.drawable.vietanh);
        mNames.add("Tra từ Việt - Anh");

        mImageUrls.add(R.drawable.tucuaban);
        mNames.add("Từ của bạn");

        mImageUrls.add(R.drawable.tudatra);
        mNames.add("Từ đã tra");

        mImageUrls.add(R.drawable.tuquantrong);
        mNames.add("Từ quan trọng");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        getIcomingIntent();
    }

    private void getIcomingIntent()
    {
        Log.d(TAG, "getIcomingIntent: check aaaaaaaaaa");
        if(getIntent().hasExtra("position"))
        {
            Log.d(TAG, "getIcomingIntent:found intent extra ");
            int postion= getIntent().getIntExtra("position", 0);
            Intent intent = new Intent(MainActivity.this, TraVietAnhActivity.class);
            switch(postion) {
                case 0:
                    break;
                case 1:
                    intent = new Intent(MainActivity.this, TuCuaBanActivity.class);
                    break;
                case 2:
                    intent = new Intent(MainActivity.this, TuDaTraActivity.class);
                    break;
                case 3:
                    intent = new Intent(MainActivity.this, TuQuanTrong.class);
                    break;
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(intent);
        }
    }

}



