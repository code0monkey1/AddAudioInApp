package com.example.chiranjeev.addaudioinapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
/*
 Step 1 : create the buttons to control the play and pause actions for the audio
 Step 2 : Declare a media player object ( this will hold the song in it )
 Step 3 : In the oncreate method , Initialize the media player object by using the create method and mentioning
 the context as "this" app and the destination of the song as second param
 Step 4 : call the start() function on the media player to start the song
 Step 5 : call the stop function on the mediaplayer in the onclick method
 which is connected to the stop button
 */
public class MainActivity extends AppCompatActivity {
   //Step 2 :
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Step 3:
        mediaPlayer=MediaPlayer.create(this,R.raw.mangalyam);
    }



    public void onStart(View view){


        // Step 4 :
        mediaPlayer.start();
    }

    public void onPause(View view){
        mediaPlayer.pause();
    }
}
