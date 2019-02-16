package com.example.android.springfever;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This is used to transfer data about what each Table of Contents item does.
 * One should be created for each item, and then stored in an Array or ArrayList.
 * <p>
 * Use: https://guides.codepath.com/android/using-parcelable#defining-a-parcelable-object
 */
public class BirdCallParcel implements Parcelable {

    int name = R.string.error;
    int price = R.string.error;
    int productId = R.string.error;
    int description = R.string.error;

    int materialBase = R.string.error;
    int materialCover = R.string.error;
    int materialStriker = R.string.error;
    int materialSoundboard = R.string.error;

    /**
     * When given a BirdCall object, it extracts the needed data to send.
     */
    BirdCallParcel(BirdCall birdCall) {
        name = birdCall.getNameInt();
        price = birdCall.getPriceInt();
        productId = birdCall.getProductIdInt();
        description = birdCall.getDescriptionInt();

        materialBase = birdCall.getMaterialBaseInt();
        materialCover = birdCall.getMaterialCoverInt();
        materialStriker = birdCall.getMaterialStrikerInt();
        materialSoundboard = birdCall.getMaterialSoundboardInt();
    }

    //Parcelable Methods
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(this.name);
        out.writeInt(this.price);
        out.writeInt(this.productId);
        out.writeInt(this.description);
        out.writeInt(this.materialBase);
        out.writeInt(this.materialCover);
        out.writeInt(this.materialStriker);
        out.writeInt(this.materialSoundboard);
    }

    private BirdCallParcel(Parcel in) {
        this.name = in.readInt();
        this.price = in.readInt();
        this.productId = in.readInt();
        this.description = in.readInt();
        this.materialBase = in.readInt();
        this.materialCover = in.readInt();
        this.materialStriker = in.readInt();
        this.materialSoundboard = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BirdCallParcel> CREATOR = new Creator<BirdCallParcel>() {
        @Override
        public BirdCallParcel createFromParcel(Parcel in) {
            return new BirdCallParcel(in);
        }

        @Override
        public BirdCallParcel[] newArray(int size) {
            return new BirdCallParcel[size];
        }
    };
}
