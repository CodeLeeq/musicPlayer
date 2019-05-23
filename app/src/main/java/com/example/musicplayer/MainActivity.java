package com.example.musicplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int backButtonCount,currentPosition;

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
    // this is the app button listener to control play stop and pause.
    @Override
    public void onClick(View view) {

        switch(view.getId( )){

            case R.id.play_btn:
                if(mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                }
                else if (!mediaPlayer.isPlaying()){
                    mediaPlayer.seekTo(currentPosition);
                    mediaPlayer.start();

                }
                break;
            case R.id.pause_btn:
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    currentPosition = mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.stop_btn:
                if (mediaPlayer!=null)
                mediaPlayer.stop();
                mediaPlayer = null;
                break;
        }

    }
    //added backbutton to exit an application
    @Override
    public void onBackPressed()
    {
        if(backButtonCount >= 1)
        {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }
}
