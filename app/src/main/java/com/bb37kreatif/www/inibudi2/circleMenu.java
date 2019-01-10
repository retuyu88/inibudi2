package com.bb37kreatif.www.inibudi2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class circleMenu extends AppCompatActivity {

    String arrayName[]={"Ikan Mas","Ikan Patin","Ikan Nila","Ikan Gurame", "Ikan Lele"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_menu);


        final CircleMenu circleMenu = findViewById(R.id.circleMenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"),R.drawable.mic_control,R.drawable.ic_launcher)
                .addSubMenu(Color.parseColor("#258CFF"),R.drawable.ikan_mas)
                .addSubMenu(Color.parseColor("#6d4c41"),R.drawable.ikan_lele)
                .addSubMenu(Color.parseColor("#ff0000"),R.drawable.ikan_gurame)
                .addSubMenu(Color.parseColor("#03a9f4"),R.drawable.ikan_nila)
                .addSubMenu(Color.parseColor("#1a237e"),R.drawable.ikan_patin)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {

                    @Override
                    public void onMenuSelected(int index) {

                        Toast.makeText(circleMenu.this,"Anda Memilih "+arrayName[index], Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
