package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PERSON = "extra_person";

    TextView tvNama;
    TextView tvDeskripsi;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Dinas dinas = getIntent().getParcelableExtra(EXTRA_PERSON);

        imageView = findViewById(R.id.iv_foto);
        Picasso.get().load(dinas.getPhoto()).into(imageView);

        tvNama = findViewById(R.id.tv_nama);
        tvNama.setText(dinas.getNama());

        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        tvDeskripsi.setText(dinas.getDeskripsi());

    }
}