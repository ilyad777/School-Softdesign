package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.activities.R;

import butterknife.Bind;


public class ProfileFragment extends Fragment {
    @Bind(R.id.fab)
    FloatingActionButton mActionButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_profile, null);
        ((MainActivity)getActivity()).checker(R.id.drawer_profile);
        ((MainActivity)getActivity()).lockAppBar(false, getResources().getString(R.string.person_name));
        return convertView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton mFloatingActionButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mFloatingActionButton.getLayoutParams();
        params.setAnchorId(R.id.appbar_layout);
        params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
        mFloatingActionButton.setLayoutParams(params);
        mFloatingActionButton.setImageResource(R.drawable.ic_mode_edit_24dp);


    }
}
