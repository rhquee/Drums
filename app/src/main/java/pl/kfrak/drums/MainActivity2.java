package pl.kfrak.drums;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;

/**
 * Created by RENT on 2017-06-08.
 */

public class MainActivity2 extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    MediaPlayer soundImageView;
    MediaPlayer soundImageView2;
    MediaPlayer soundImageView3;
    MediaPlayer soundImageView4;
    MediaPlayer soundImageView5;
    MediaPlayer soundImageView6;
    HashMap<Integer, MediaPlayer> musicsHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicsHashMap = new HashMap<>();

        musicsHashMap.put(R.id.imageView, MediaPlayer.create(this, getMusicIdByViewId(R.id.imageView)));

    }

    public void playSound(View view) {
        MediaPlayer sound = musicsHashMap.get(view.getId());
        if (sound != null) {
            seekToBeginningAndPlay(sound);
        }else{
            putMusicPlayer(view.getId());
            seekToBeginningAndPlay(musicsHashMap.get(view.getId()));
        }
    }

    private void seekToBeginningAndPlay(MediaPlayer sound) {
        sound.seekTo(0);
        if (!sound.isPlaying())
            sound.start();
    }

    private void putMusicPlayer(int viewId) {
        musicsHashMap.put(viewId, MediaPlayer.create(this, getMusicIdByViewId(viewId)));
    }

//        //stara metoda playSounda
//        int musicId = getMusicIdByViewId(view.getId());
//        MediaPlayer sound = MediaPlayer.create(this, musicId);
//        sound.setOnCompletionListener(this);
//        sound.start();
//    }

    private int getMusicIdByViewId(int viewId) {
        switch (viewId) {
            case R.id.imageView:
                return R.raw.cymbal;
            default:
                return R.raw.gong;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}