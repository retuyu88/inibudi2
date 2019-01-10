package com.bb37kreatif.www.inibudi2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class menucardview extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatavbase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menucardview);

        Intent intent = getIntent();
        String referensi = intent.getStringExtra("EXTRA_MESSAGE");
        //Actionbar
        ActionBar actionBar = getSupportActionBar();
        //set Judul
        if (actionBar != null) {
            actionBar.setTitle("Posts List");
        }
        //RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        //set layout sebagai LinearLayout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //mengirim query ke firebase database
        mFirebaseDatavbase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatavbase.getReference(referensi);


    }
    //memasukan data ke recycler view pada saat dipanggil atau onStart

    @Override
    protected void onStart(){
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.menumas,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(getApplicationContext(), model.getJudul(), model.getDeskripsi(), model.getImage());

                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);

                        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                                //memngambil data dari firebase (basis data) online setelah klik pada item tahap ikan
                                String mJudul = getItem(position).getJudul();
                                String mPenjelasan = getItem(position).getDeskripsi();
                                String mImage = getItem(position).getImage();


                                //mengoper data ke activity baru
                                Intent intent = new Intent(view.getContext(), detailikan.class);
                                intent.putExtra("image", mImage);//mengambil gambar untuk activity selanjutnya
                                intent.putExtra("judul", mJudul);//mengambil judul untuk activity selanjutnya
                                intent.putExtra("deskripsi", mPenjelasan); //mengambil deskripsi untuk aktivity selanjutnya
                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        return viewHolder;
                    }
                };
        //set adapter ke recyclerView
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
