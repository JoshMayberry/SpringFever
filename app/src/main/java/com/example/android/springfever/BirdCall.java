package com.example.android.springfever;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

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

    private int mImage = R.drawable.empty;
    private int mImageScaleType = SCALE_TYPE_CENTER_CROP;
    public static final int SCALE_TYPE_CENTER_CROP = 0;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;

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

        setImage(parcel.image, parcel.imageScaleType);

        setMaterialBase(parcel.materialBase);
        setMaterialCover(parcel.materialCover);
        setMaterialStriker(parcel.materialStriker);
        setMaterialSoundboard(parcel.materialSoundboard);
    }

    /**
     * Plays the sound associated with this bird call.
     */
    public void onPlaySound() {
        mMyMediaPlayer.playSound(mSoundId);
    }

    /**
     * Adds this call to the shopping cart.
     * If it is already in the cart, it is removed.
     */
    public void onToggleCart() {
        Toast.makeText(mActivity, "Not Yet Implemented", Toast.LENGTH_SHORT).show();
    }

    //Getters
    //See: https://codelabs.developers.google.com/codelabs/android-databinding/index.html?index=..%2F..index#6
    //See: https://www.youtube.com/watch?v=gP_zj-CIBvM
    @Bindable
    public String getName() {
        return mActivity.getString(mName);
    }

    public int getNameInt() {
        return mName;
    }

    @Bindable
    public String getPrice() {
        return "$" + mPrice + ".00";
    }

    public int getPriceInt() {
        return mPrice;
    }

    @Bindable
    public String getProductId() {
        return mActivity.getString(mProductId);
    }

    public int getProductIdInt() {
        return mProductId;
    }

    @Bindable
    public Drawable getImage() {
        return mActivity.getDrawable(mImage);
    }

    @Bindable
    public ImageView.ScaleType getImageScaleType() {
        switch (mImageScaleType) {
            case SCALE_TYPE_CENTER_CROP:
                return ImageView.ScaleType.CENTER_CROP;
            case SCALE_TYPE_CENTER_INSIDE:
                return ImageView.ScaleType.CENTER_INSIDE;
            default:
                Log.e("BirdCall", "Unknown scale type " + mImageScaleType);
                return ImageView.ScaleType.CENTER_INSIDE;
        }
    }

    public int getImageScaleTypeInt() {
        return mImageScaleType;
    }

    public int getImageInt() {
        return mImage;
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

    @Bindable
    public String getMaterialBase() {
        return mActivity.getString(mMaterialBase);
    }

    public int getMaterialBaseInt() {
        return mMaterialBase;
    }

    @Bindable
    public String getMaterialCover() {
        return mActivity.getString(mMaterialCover);
    }

    public int getMaterialCoverInt() {
        return mMaterialCover;
    }

    @Bindable
    public String getMaterialStriker() {
        return mActivity.getString(mMaterialStriker);
    }

    public int getMaterialStrikerInt() {
        return mMaterialStriker;
    }

    @Bindable
    public String getMaterialSoundboard() {
        return mActivity.getString(mMaterialSoundboard);
    }

    public int getSoundInt() {
        return mSoundId;
    }

    public int getMaterialSoundboardInt() {
        return mMaterialSoundboard;
    }

    //Setters
    public BirdCall setName(int name) {
        this.mName = name;
        notifyPropertyChanged(BR.name);
        return this;
    }

    public BirdCall setPrice(int price) {
        this.mPrice = price;
        notifyPropertyChanged(BR.price);
        return this;
    }

    public BirdCall setProductId(int productId) {
        this.mProductId = productId;
        notifyPropertyChanged(BR.productId);
        return this;
    }

    public BirdCall setImage(int imageId) {
        this.mImage = imageId;
        notifyPropertyChanged(BR.image);
        return this;
    }

    public BirdCall setImage(int imageId, int scaleType) {
        setImage(imageId);
        setImageScaleType(scaleType);
        return this;
    }

    public BirdCall setImageScaleType(int scaleType) {
        this.mImageScaleType = scaleType;
        notifyPropertyChanged(BR.imageScaleType);
        return this;
    }

    public BirdCall setDescription(int description) {
        this.mDescription = description;
        notifyPropertyChanged(BR.description);
        return this;
    }

    public BirdCall setMaterialBase(int materialBase) {
        this.mMaterialBase = materialBase;
        notifyPropertyChanged(BR.materialBase);
        return this;
    }

    public BirdCall setMaterialCover(int materialCover) {
        this.mMaterialCover = materialCover;
        notifyPropertyChanged(BR.materialCover);
        return this;
    }

    public BirdCall setMaterialStriker(int materialStriker) {
        this.mMaterialStriker = materialStriker;
        notifyPropertyChanged(BR.materialStriker);
        return this;
    }

    public BirdCall setSound(int soundId) {
        this.mSoundId = soundId;
        return this;
    }

    public BirdCall setMaterialSoundboard(int materialSoundboard) {
        this.mMaterialSoundboard = materialSoundboard;
        notifyPropertyChanged(BR.materialSoundboard);
        return this;
    }
}
