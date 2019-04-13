package com.example.noce30.cardview;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

public class TuDaTraActivity extends AppCompatActivity {
    ImageButton ImgBtnMP3;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tudatra);
        ImgBtnMP3 = (ImageButton) findViewById(R.id.imageButtonMP3);
        ImgBtnMP3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mediaPlayer = MediaPlayer.create(TuDaTraActivity.this,R.raw.hello);
                mediaPlayer.start();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
