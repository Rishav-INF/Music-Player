package com.example.music_player

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.media.MediaPlayer
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import com.example.music_player.R


class musix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play)

        // Find the playButton
        val playButton = findViewById<ImageButton>(R.id.imageButton)

        // Set onClick listener for playButton
        playButton.setOnClickListener()
        {
            if(count==false){
            playSound();}
            else
            {
                pauseSound()
            }

        }
    }
    var mMediaPlayer: MediaPlayer? = null
    var count=false

    // Plays the water sound
    fun playSound() {

        if (mMediaPlayer == null) {
            mMediaPlayer = MediaPlayer.create(this, R.raw.gsbmps)
            mMediaPlayer!!.isLooping = true
            mMediaPlayer!!.start()
            count=true
        } else {mMediaPlayer!!.start()
            count=true}

    }

    // Pause playback
    fun pauseSound() {
        if (mMediaPlayer?.isPlaying == true) mMediaPlayer?.pause()
        count=false
    }

    // Stops playback
    fun stopSound() {
        if (mMediaPlayer != null) {
            mMediaPlayer!!.stop()
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }

    // Destroys the MediaPlayer instance when the app is closed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }
}