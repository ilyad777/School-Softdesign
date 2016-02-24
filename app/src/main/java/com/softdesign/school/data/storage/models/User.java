package com.softdesign.school.data.storage.models;

import android.graphics.drawable.Drawable;

public class User {
    private String mFirstName;
    private String mLastName;
    private int mRating;
    private Drawable mImage;
    private String mVkLink;
    private String mGitLing;
    private int mHomeTask;

    public User(Drawable mImage, String mFirstName, String mLastName) {
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mImage = mImage;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getRating() {
        return mRating;
    }

    public Drawable getImage() {
        return mImage;
    }

    public String getVkLink() {
        return mVkLink;
    }

    public String getGitLing() {
        return mGitLing;
    }

    public int getHomeTask() {
        return mHomeTask;
    }
}