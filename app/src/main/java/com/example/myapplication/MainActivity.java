package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] nama;
    private TypedArray photo;
    private String[] deskripsi;

    private Adapter adapter;
    private ArrayList<Dinas> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepare();
        list = addItems();

        adapter = new Adapter( this, list);
        ListView listView= findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_PERSON, list.get(i));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Dinas> addItems() {
        ArrayList<Dinas> item = new ArrayList<>();
        for (int i = 0; i < nama.length; i++) {
            Dinas dinas = new Dinas();

            dinas.setNama(nama[i]);
            dinas.setPhoto(photo.getResourceId(i, -1));
            dinas.setDeskripsi(deskripsi[i]);
            item.add(dinas);
        }
        return item;
    }

    private void prepare() {
        nama = getResources().getStringArray(R.array.nama_dinas);
        photo = getResources().obtainTypedArray(R.array.photo);
        deskripsi = getResources().getStringArray(R.array.deskripsi);
    }
}