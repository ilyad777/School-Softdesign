package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.activities.R;

public class TasksFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_tasks, null);
        ((MainActivity)getActivity()).checker(R.id.drawer_tasks);
        ((MainActivity)getActivity()).lockAppBar(true, getResources().getString(R.string.drawer_tasks));
        return convertView;
    }
}
