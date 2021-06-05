package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {
    private Context context;
    private ArrayList<Dinas> list;

    Adapter(Context context, ArrayList<Dinas> list){
        this.context = context;
        this. list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.items, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Dinas dinas =(Dinas) getItem(i);
        viewHolder.bind(dinas);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view){
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Dinas dinas) {
            txtName.setText(dinas.getNama());
            txtDescription.setText(dinas.getDeskripsi());
            imgPhoto.setImageResource(dinas.getPhoto());
        }
    }
}



