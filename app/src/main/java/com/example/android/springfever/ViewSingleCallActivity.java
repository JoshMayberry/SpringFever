package com.example.android.springfever;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.springfever.databinding.ActivityViewSingleCallBinding;

public class ViewSingleCallActivity extends AppCompatActivity {
    ActivityViewSingleCallBinding binding;
    public MyMediaPlayer myMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myMediaPlayer = new MyMediaPlayer(this);

        //See: https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#4
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_single_call);
        binding.setBirdCall(new BirdCall(this));
    }

    @Override
    protected void onStop() {
        super.onStop();
        myMediaPlayer.onStopOverride();
    }
}
