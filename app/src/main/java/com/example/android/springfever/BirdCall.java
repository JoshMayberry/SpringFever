package com.example.android.springfever;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * This class holds data pertaining to a bird call.
 * It can be used by an XML layout to auto-populate fields using data binding.
 * It can extract data from a parcel given to the intent under the key 'bird_call'.
 */
public class BirdCall extends BaseObservable {
    private Activity mActivity;
    private MyMediaPlayer mMyMediaPlayer;

    private int mName = R.string.error;
    private int mPrice = R.string.error;
    private int mProductId = R.string.error;
    private int mDescription = R.string.error;
    private int mSoundId = R.raw.error;

    private int mMaterialBase = R.string.error;
    private int mMaterialCover = R.string.error;
    private int mMaterialStriker = R.string.error;
    private int mMaterialSoundboard = R.string.error;

    BirdCall(ViewCallsActivity activity) {
        this.mActivity = activity;
        mMyMediaPlayer = activity.myMediaPlayer; //I can't figure out how to access this in both activities using mActivity, so this is what I came up with
        extractParcelData();
    }

    BirdCall(ViewSingleCallActivity activity) {
        this.mActivity = activity;
        mMyMediaPlayer = activity.myMediaPlayer; //I can't figure out how to access this in both activities using mActivity, so this is what I came up with
        extractParcelData();
    }

    @Override
    public String toString() {
        return "BirdCall{" +
                "mActivity=" + mActivity +
                ", mMyMediaPlayer is not null=" + String.valueOf(mMyMediaPlayer != null) +
                ", mName=" + mName +
                ", mPrice=" + mPrice +
                ", mProductId=" + mProductId +
                ", mDescription=" + mDescription +
                ", mSoundId=" + mSoundId +
                ", mMaterialBase=" + mMaterialBase +
                ", mMaterialCover=" + mMaterialCover +
                ", mMaterialStriker=" + mMaterialStriker +
                ", mMaterialSoundboard=" + mMaterialSoundboard +
                '}';
    }

    /**
     * This extracts the parcel values and places them into a more stable object
     * See: https://guides.codepath.com/android/using-parcelable#what-it-is-not
     */
    private void extractParcelData() {
        Intent intent = mActivity.getIntent();
        if (!(intent.hasExtra("bird_call"))) {
            return;
        }

        BirdCallParcel parcel = intent.getParcelableExtra("bird_call");
        setName(parcel.name);
        setPrice(parcel.price);
        setSound(parcel.sound);
        setProductId(parcel.productId);
        setDescription(parcel.description);

        setMaterialBase(parcel.materialBase);
        setMaterialCover(parcel.materialCover);
        setMaterialStriker(parcel.materialStriker);
        setMaterialSoundboard(parcel.materialSoundboard);
    }

    //See: https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#6
    //See: https://www.youtube.com/watch?v=gP_zj-CIBvM
    @Bindable
    public String getName() {
        return mActivity.getString(mName);
    }

    public int getNameInt() {
        return mName;
    }

    public BirdCall setName(int name) {
        this.mName = name;
        notifyPropertyChanged(BR.name);
        return this;
    }

    @Bindable
    public String getPrice() {
        return "$" + mPrice + ".00";
    }

    public int getPriceInt() {
        return mPrice;
    }

    public BirdCall setPrice(int price) {
        this.mPrice = price;
        notifyPropertyChanged(BR.price);
        return this;
    }

    @Bindable
    public String getProductId() {
        return mActivity.getString(mProductId);
    }

    public int getProductIdInt() {
        return mProductId;
    }

    public BirdCall setProductId(int productId) {
        this.mProductId = productId;
        notifyPropertyChanged(BR.productId);
        return this;
    }

    //See: https://stackoverflow.com/questions/1583940/how-do-i-get-the-first-n-characters-of-a-string-without-checking-the-size-or-goi/1583968#1583968
    @Bindable
    public String getShortDescription() {
        String description = mActivity.getString(mDescription);
        return description.substring(0, Math.min(description.length(), 20)) + "...";
    }

    @Bindable
    public String getDescription() {
        return mActivity.getString(mDescription);
    }

    public int getDescriptionInt() {
        return mDescription;
    }

    public BirdCall setDescription(int description) {
        this.mDescription = description;
        notifyPropertyChanged(BR.description);
        return this;
    }

    @Bindable
    public String getMaterialBase() {
        return mActivity.getString(mMaterialBase);
    }

    public int getMaterialBaseInt() {
        return mMaterialBase;
    }

    public BirdCall setMaterialBase(int materialBase) {
        this.mMaterialBase = materialBase;
        notifyPropertyChanged(BR.materialBase);
        return this;
    }

    @Bindable
    public String getMaterialCover() {
        return mActivity.getString(mMaterialCover);
    }

    public int getMaterialCoverInt() {
        return mMaterialCover;
    }

    public BirdCall setMaterialCover(int materialCover) {
        this.mMaterialCover = materialCover;
        notifyPropertyChanged(BR.materialCover);
        return this;
    }

    @Bindable
    public String getMaterialStriker() {
        return mActivity.getString(mMaterialStriker);
    }

    public int getMaterialStrikerInt() {
        return mMaterialStriker;
    }

    public BirdCall setMaterialStriker(int materialStriker) {
        this.mMaterialStriker = materialStriker;
        notifyPropertyChanged(BR.materialStriker);
        return this;
    }

    @Bindable
    public String getMaterialSoundboard() {
        return mActivity.getString(mMaterialSoundboard);
    }

    public int getSoundInt() {
        return mSoundId;
    }

    public BirdCall setSound(int soundId) {
        this.mSoundId = soundId;
        return this;
    }

    public int getMaterialSoundboardInt() {
        return mMaterialSoundboard;
    }

    public BirdCall setMaterialSoundboard(int materialSoundboard) {
        this.mMaterialSoundboard = materialSoundboard;
        notifyPropertyChanged(BR.materialSoundboard);
        return this;
    }

    public void onPlaySound() {
        mMyMediaPlayer.playSound(mSoundId);
    }
}
