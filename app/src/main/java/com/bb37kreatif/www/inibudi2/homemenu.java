package com.bb37kreatif.www.inibudi2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class homemenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homemenu);

        ImageButton pilihikan = findViewById(R.id.pilihjenisikan);
        pilihikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),menuikan.class);
                startActivity(intent);
            }
        });

        ImageButton tanyabudi = findViewById(R.id.tanyabudi);
        tanyabudi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),dialog.class);
                startActivity(intent);
            }
        });

    }
}
