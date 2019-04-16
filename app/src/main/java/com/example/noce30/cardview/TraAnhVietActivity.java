package com.example.noce30.cardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TraAnhVietActivity extends AppCompatActivity {
    private ImageButton btnTimKiemTTAV;
    DBHelper db;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tratu_anhviet);
        //init data
        btnTimKiemTTAV = (ImageButton) findViewById(R.id.btnTimKiemTTAV);
        btnTimKiemTTAV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TraAnhVietActivity.this, KetQuaTraAnhViet.class);
                EditText searchText = (EditText) findViewById(R.id.edtSearchAV);
                intent.putExtra("keySearchTV", searchText.getText().toString());
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);

            }
        });

    }

}
