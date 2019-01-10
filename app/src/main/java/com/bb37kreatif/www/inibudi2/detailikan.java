package com.bb37kreatif.www.inibudi2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class detailikan extends AppCompatActivity {

    TextView mjudul,mdeskripsi;
    ImageView mimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailikan);

        //action bar
        ActionBar actionBar = getSupportActionBar();
        //judul actionbar
        assert actionBar != null;
        actionBar.setTitle("Tahap Budidaya");
        //set tombol kembali
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        //view ke sebuah wadah
        mjudul = findViewById(R.id.dtahapbudidaya);
        mdeskripsi = findViewById(R.id.dpenjelasan);
        mimage = findViewById(R.id.dgambartahap);

        //mengambil detail dari intent
        String image = getIntent().getStringExtra("image");
        String judul = getIntent().getStringExtra("judul");
        String penjelasan = getIntent().getStringExtra("deskripsi");

        //set data to views
        mjudul.setText(judul);
        mdeskripsi.setText(penjelasan);
        Picasso.get().load(image).into(mimage);

    }

    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
