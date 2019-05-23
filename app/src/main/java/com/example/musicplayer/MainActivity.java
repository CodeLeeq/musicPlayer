package com.example.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play_btn);
        pause = (Button) findViewById(R.id.pause_btn);
        stop = (Button) findViewById(R.id.stop_btn);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        switch(view.getId( )){

            case R.id.play_btn:
                mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music);
                mediaPlayer.start();
                break;
            case R.id.pause_btn:
                mediaPlayer.pause();
                break;

            case R.id.stop_btn:
                mediaPlayer.stop();
                break;
        }

    }
}
