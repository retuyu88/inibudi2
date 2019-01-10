package com.bb37kreatif.www.inibudi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class menuikan extends AppCompatActivity {
    String namaikan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuikan);

        ImageButton ikanmas = findViewById(R.id.tblmas);
        ikanmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaikan = "data/mas";
                Intent intent = new Intent(getApplicationContext(),menucardview.class);
                intent.putExtra("EXTRA_MESSAGE", namaikan);
                startActivity(intent);
            }
        });
        ImageButton ikangurame = findViewById(R.id.tblgurame);
        ikangurame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaikan = "data/gurame";
                Intent intent = new Intent(getApplicationContext(),menucardview.class);
                intent.putExtra("EXTRA_MESSAGE", namaikan);
                startActivity(intent);
            }
        });
        ImageButton ikanlele = findViewById(R.id.tbllele);
        ikanlele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaikan = "data/lele";
                Intent intent = new Intent(getApplicationContext(),menucardview.class);
                intent.putExtra("EXTRA_MESSAGE", namaikan);
                startActivity(intent);
            }
        });
        ImageButton ikanpatin = findViewById(R.id.tblpatin);
        ikanpatin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaikan = "data/patin";
                Intent intent = new Intent(getApplicationContext(),menucardview.class);
                intent.putExtra("EXTRA_MESSAGE", namaikan);
                startActivity(intent);
            }
        });
        ImageButton ikannila = findViewById(R.id.tblnila);
        ikannila.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namaikan = "data/nila";
                Intent intent = new Intent(getApplicationContext(),menucardview.class);
                intent.putExtra("EXTRA_MESSAGE", namaikan);
                startActivity(intent);
            }
        });
    }
}
