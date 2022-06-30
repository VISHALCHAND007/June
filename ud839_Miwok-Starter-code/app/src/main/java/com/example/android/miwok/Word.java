package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_RESOURCE;
    private int mAudioResourceId;
    private static final int NO_IMAGE_RESOURCE = -1;
    //constructor
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }
    //constructor to take the three input parameters
    public Word(String defaultTranslation, String miwokTranslation,int imageResourceId, int audioResourceId) {
        mMiwokTranslation = miwokTranslation;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    //method to get the miwok translation
    public String getmDefaultTranslation() {
        return mDefaultTranslation;
    }
    //method to get the default/english translation
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_RESOURCE;
    }

    public int getmAudioResourceId() {
        return mAudioResourceId;
    }
}
