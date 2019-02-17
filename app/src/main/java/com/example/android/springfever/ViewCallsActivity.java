package com.example.android.springfever;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.android.springfever.databinding.ActivityViewCallsBinding;

import java.util.ArrayList;

//Placeholder sounds from: https://freesound.org/
public class ViewCallsActivity extends AppCompatActivity {
    ActivityViewCallsBinding binding;
    public MyMediaPlayer myMediaPlayer;

    ArrayList<BirdCall> birdCallList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myMediaPlayer = new MyMediaPlayer(this);

        //See: https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#4
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_calls);

        populateBirdCalls();
        binding.callList.setAdapter(new ViewCallsAdapter(this, birdCallList));

        //See: http://ezzylearning.com/tutorial/handling-android-listview-onitemclick-event
        binding.callList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewCallsActivity.this, ViewSingleCallActivity.class);
                intent.putExtra("bird_call", new BirdCallParcel(birdCallList.get(position)));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        myMediaPlayer.onStopOverride();
    }

    private void populateBirdCalls() {
        birdCallList.clear();
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_1)
                .setDescription(R.string.material_description_1)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_1)
                .setImage(R.drawable.placeholder_1, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_2)
                .setDescription(R.string.material_description_2)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_2)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_2)
                .setImage(R.drawable.placeholder_2, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_3)
                .setDescription(R.string.material_description_3)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_3)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_3)
                .setImage(R.drawable.placeholder_3, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_4)
                .setDescription(R.string.material_description_4)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_4)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_4)
                .setImage(R.drawable.placeholder_4, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_5)
                .setDescription(R.string.material_description_5)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_2)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_5)
                .setImage(R.drawable.placeholder_5, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_6)
                .setDescription(R.string.material_description_6)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_1)
                .setImage(R.drawable.placeholder_6, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_7)
                .setDescription(R.string.material_description_7)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_2)
                .setImage(R.drawable.placeholder_1, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_8)
                .setDescription(R.string.material_description_8)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_3)
                .setImage(R.drawable.placeholder_2, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_9)
                .setDescription(R.string.material_description_9)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_4)
                .setImage(R.drawable.placeholder_3, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_10)
                .setDescription(R.string.material_description_10)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_5)
                .setImage(R.drawable.placeholder_4, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_11)
                .setDescription(R.string.material_description_11)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_1)
                .setImage(R.drawable.placeholder_5, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_12)
                .setDescription(R.string.material_description_12)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_2)
                .setImage(R.drawable.placeholder_6, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_13)
                .setDescription(R.string.material_description_13)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_3)
                .setImage(R.drawable.placeholder_1, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_14)
                .setDescription(R.string.material_description_14)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_4)
                .setImage(R.drawable.placeholder_2, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_15)
                .setDescription(R.string.material_description_15)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_5)
                .setImage(R.drawable.placeholder_3, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_16)
                .setDescription(R.string.material_description_16)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_1)
                .setImage(R.drawable.placeholder_4, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_17)
                .setDescription(R.string.material_description_17)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_2)
                .setImage(R.drawable.placeholder_5, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_18)
                .setDescription(R.string.material_description_18)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_3)
                .setImage(R.drawable.placeholder_6, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_19)
                .setDescription(R.string.material_description_19)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_4)
                .setImage(R.drawable.placeholder_1, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_20)
                .setDescription(R.string.material_description_20)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_5)
                .setImage(R.drawable.placeholder_2, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_21)
                .setDescription(R.string.material_description_21)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_1)
                .setImage(R.drawable.placeholder_3, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_22)
                .setDescription(R.string.material_description_22)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_2)
                .setImage(R.drawable.placeholder_4, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_23)
                .setDescription(R.string.material_description_23)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_3)
                .setImage(R.drawable.placeholder_5, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_24)
                .setDescription(R.string.material_description_24)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_4)
                .setImage(R.drawable.placeholder_6, BirdCall.SCALE_TYPE_CENTER_INSIDE));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_25)
                .setDescription(R.string.material_description_25)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_5)
                .setImage(R.drawable.placeholder_1, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_26)
                .setDescription(R.string.material_description_26)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_1)
                .setImage(R.drawable.placeholder_2, BirdCall.SCALE_TYPE_CENTER_CROP));
        birdCallList.add(new BirdCall(this)
                .setName(R.string.material_name_27)
                .setDescription(R.string.material_description_27)
                .setProductId(R.string.error)
                .setPrice(5)
                .setMaterialBase(R.string.material_base_1)
                .setMaterialCover(R.string.material_cover_1)
                .setMaterialStriker(R.string.material_striker_1)
                .setMaterialSoundboard(R.string.material_soundboard_1)
                .setSound(R.raw.placeholder_2)
                .setImage(R.drawable.placeholder_3, BirdCall.SCALE_TYPE_CENTER_CROP));

    }
}
