package pl.kfrak.drums;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.HashMap;

/**
 * Created by RENT on 2017-06-08.
 */

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    HashMap<Integer, MediaPlayer> musicsHashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicsHashMap = new HashMap<>();
    }

    private void putMusicPlayer(int viewId) {
        musicsHashMap.put(viewId, MediaPlayer.create(this, getMusicIdByViewId(viewId)));
    }

    public void playSound(View view) {
        MediaPlayer sound = musicsHashMap.get(view.getId());
        if (sound != null) {
            seekToBeggingAndPlay(sound);
        } else {
            putMusicPlayer(view.getId());
            seekToBeggingAndPlay(musicsHashMap.get(view.getId()));
        }

        //old
        /*int musicId = getMusicIdByViewId(view.getId());
        MediaPlayer sound = MediaPlayer.create(this, musicId);
        sound.setOnCompletionListener(this);
        sound.start();*/
    }

    private void seekToBeggingAndPlay(MediaPlayer sound) {
        sound.seekTo(0);
        if (!sound.isPlaying())
            sound.start();
    }

    private int getMusicIdByViewId(int viewId) {
        switch (viewId) {
            case R.id.imageView:
                return R.raw.cymbal;
            case R.id.imageView2:
                return R.raw.cymbal;
            case R.id.imageView3:
                return R.raw.cymbal;
            case R.id.imageView4:
                return R.raw.cymbal;
            case R.id.imageView5:
                return R.raw.drum1;
            default:
                return R.raw.gong;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        mp.release();
    }
}


















//package pl.kfrak.drums;
//
//import android.media.MediaPlayer;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//
//import java.util.HashMap;
//
//import static pl.kfrak.drums.R.id.imageView2;
//
//public class MainActivity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
//    MediaPlayer soundImageView;
//    MediaPlayer soundImageView2;
//    MediaPlayer soundImageView3;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        MediaPlayer soundImageView = MediaPlayer.create(this, R.id.imageView);
//        MediaPlayer soundImageView2 = MediaPlayer.create(this, R.id.imageView2);
//        MediaPlayer soundImageView3 = MediaPlayer.create(this, R.id.imageView3);
//    }
//
//    //View view bo to klikalny element widoku
//    public void playSound(View view) {
//        int musicId = getMusicIdByViewId(view.getId());
//        MediaPlayer sound = MediaPlayer.create(this, musicId);
//        sound.setOnCompletionListener(this);
//        sound.start();
//    }
//
//    private int getMusicIdByViewId(int viewId) {
//        switch (viewId) {
//            case R.id.imageView:
//                return R.raw.bass;
//            case R.id.imageView2:
//                return R.raw.cymbal;
//            default:
//                return R.raw.bass;
//        }
//    }
//
//    @Override
//    public void onCompletion(MediaPlayer mp) {
//        mp.release();
//    }
//}
//
////        switch (view.getId()){
////            MediaPlayer sound;
////            case R.id.imageView:
////                sound = MediaPlayer.create(this, R.raw.bass);
////            case R.id.imageView2:
////                sound = MediaPlayer.create(this, R.raw.gong);
////            case R.id.imageView3:
////                sound = MediaPlayer.create(this, R.raw.shoot);
////            case R.id.imageView4:
////                sound = MediaPlayer.create(this, R.raw.hit1);
////            default:
////                sound = MediaPlayer.create(this, R.raw.cymbal);
////                break;
////            sound.start();
//
//
//
