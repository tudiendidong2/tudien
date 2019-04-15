package com.example.noce30.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class TraVietAnhActivity extends AppCompatActivity {
    private ImageView img;
    DBHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tratiengviet);
        //init data
        db = new DBHelper(this);
        db.createDefaultNotesIfNeed();

        img = (ImageView) findViewById(R.id.imgSearchVA);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TraVietAnhActivity.this, KetQuaVietAnhActivity.class);
                EditText searchText = (EditText) findViewById(R.id.etSearchTV);
                intent.putExtra("keySearchTV", searchText.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
    }

}
