package com.example.noce30.cardview.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.noce30.cardview.Model.TuDaTra;
import com.example.noce30.cardview.R;

import java.util.List;

public class TuDaTraAdapter extends ArrayAdapter<TuDaTra> {
    private Context context;
    private int resource;
    private List<TuDaTra> arrayContact;
    public TuDaTraAdapter( Context context, int resource, List<TuDaTra> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrayContact=objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null)
        {
            viewHolder = new ViewHolder();
            convertView=LayoutInflater.from(context).inflate(R.layout.item_tudatra,parent,false);
            viewHolder.tvTA=(TextView) convertView.findViewById(R.id.txtTDTTA);
            viewHolder.imgTuDaTra=(ImageView) convertView.findViewById(R.id.img_tudatra) ;
            //viewHolder.tvTV=(TextView) convertView.findViewById(R.id.tx);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        TuDaTra tuDaTra= arrayContact.get(position);
        viewHolder.tvTA.setText(tuDaTra.getTA());
        byte[] image = tuDaTra.getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        viewHolder.imgTuDaTra.setImageBitmap(bitmap);
        //viewHolder.tvNumber.setText(tuDaTra.getTV());

        return convertView;
    }
    public class ViewHolder{
        ImageView imgTuDaTra;
        TextView tvTA;
        TextView tvTV;
    }
}
