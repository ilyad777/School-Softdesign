package com.softdesign.school.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.softdesign.school.ui.activities.R;

public class UserViewHolder extends RecyclerView.ViewHolder{
    protected ImageView mAvatar;
    protected TextView mUserName;


    public UserViewHolder(View itemView) {
        super(itemView);
        mUserName = (TextView) itemView.findViewById(R.id.user_name);
        mAvatar = (ImageView) itemView.findViewById(R.id.user_avatar);
    }
}