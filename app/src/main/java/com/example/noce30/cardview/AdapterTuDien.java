package com.example.noce30.cardview;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.LayoutInflaterFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class AdapterTuDien extends BaseAdapter {
    Context context;
    ArrayList<TuDien> list;

    public AdapterTuDien(Context context, ArrayList<TuDien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_row, null);
        ImageView imgHinhTuVung = (ImageView) row.findViewById(R.id.imgHinhTuVung);
        TextView txtTdTuVung = (TextView) row.findViewById(R.id.txtIdTuVung);
        TextView txtNameTuVung = (TextView) row.findViewById(R.id.txtNameTuVung);
        TextView txtMeaningTuVung = (TextView) row.findViewById(R.id.txtMeaningTuVung);

        TuDien tuDien = list.get(position);
        txtTdTuVung.setText(tuDien.id + "");
        txtNameTuVung.setText(tuDien.name);
        txtMeaningTuVung.setText(tuDien.meaning);
        Bitmap bmHinhTuVung = BitmapFactory.decodeByteArray(tuDien.image, 0 , tuDien.image.length);
        imgHinhTuVung.setImageBitmap(bmHinhTuVung);
        return row;

    }

}

