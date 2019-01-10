package com.bb37kreatif.www.inibudi2;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.VideoView;

public class splashSreen extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_sreen);
        getSupportActionBar().hide();
        videoView = findViewById(R.id.videoView2);

        Uri video = Uri.parse("android.resource://" + getPackageName() +"/" + R.raw.aa);
        videoView.setVideoURI(video);
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                startActivity(new Intent(splashSreen.this, homemenu.class));
                finish();
            }
        });
        videoView.start();
    }
}
