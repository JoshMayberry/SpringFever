package com.example.android.springfever;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;

/**
 * This class contains code relevant to playing sound effects for this app.
 * It exists to both contain the redundant code and keep the classes that use it simpler.
 * It is patterned after the media player application for Udacity's Miwok app.
 * Use: https://github.com/JoshMayberry/Miwok
 */
public class MyMediaPlayer {
    private Activity mActivity;

    private AudioManager mAudioManager;
    private MediaPlayer mMediaPlayer;

    /**
     * Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio_focus_pre-android_80
     * @param activity - The activity that is using the media player
     */
    MyMediaPlayer (Activity activity) {
        mActivity = activity;
        mAudioManager = (AudioManager) mActivity.getSystemService(Context.AUDIO_SERVICE);
        releaseMediaPlayer();
    }

    /**
     * Plays a sound effect if the media stream is free to do so.
     * See: https://developer.android.com/guide/topics/media/mediaplayer#mediaplayer
     * See: https://www.101apps.co.za/index.php/articles/all-about-using-android-s-context-class.html
     * @param soundId - The resource id of the sound file in res/raw
     */
    public void playSound(int soundId) {
        if (!(requestAudioService())) {
            return;
        }

        mMediaPlayer = MediaPlayer.create(mActivity.getApplication(), soundId);
        mMediaPlayer.start();

        mMediaPlayer.setOnCompletionListener(mMediaCompletionListener);
    }

    /**
     * Call this in the onStop override of the activity.
     * Frees up resources when the app is closed.
     * See: https://developer.android.com/guide/components/activities/activity-lifecycle#alc
     */
    void onStopOverride() {
        releaseMediaPlayer();
    }

    /**
     * Frees up resources when the sound effect is finished playing.
     */
    private MediaPlayer.OnCompletionListener mMediaCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };


    /**
     * Handles losing and gaining media focus.
     * Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio-focus-change
     * See: https://developer.android.com/reference/android/media/AudioManager.OnAudioFocusChangeListener
     * See: https://medium.com/google-developers/how-to-properly-handle-audio-interruptions-3a13540d18fa
     */
    private AudioManager.OnAudioFocusChangeListener mAudioManagerChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    switch (focusChange) {
                        //See: https://stackoverflow.com/questions/5086322/java-switch-statement-multiple-cases/5277741#5277741
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            mMediaPlayer.start();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            releaseMediaPlayer();
                            break;
                    }
                }
            };

    /**
     * A convenience function that frees up resources if needed.
     * Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio_focus_pre-android_80
     */
    private void releaseMediaPlayer() {
        if (mMediaPlayer == null) {
            return;
        }
        mMediaPlayer.release();
        mMediaPlayer = null;

        mAudioManager.abandonAudioFocus(mAudioManagerChangeListener);
    }

    /**
     * Checks if the app can play a sound effect right now.
     * Use: https://developer.android.com/guide/topics/media-apps/audio-focus#audio_focus_pre-android_80
     */
    private boolean requestAudioService() {
        return mAudioManager.requestAudioFocus(mAudioManagerChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT) == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
    }
}
