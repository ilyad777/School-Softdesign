package com.softdesign.school.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.CoordinatorLayout;

import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.activities.MainActivity;
import com.softdesign.school.ui.activities.R;
import com.softdesign.school.ui.adapters.RecycleUserAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactsFragment extends Fragment {
    ArrayList<User> mUsers = new ArrayList<User>();
    @Bind(R.id.fab)
    FloatingActionButton mActionButton;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_contacts, null);

        ((MainActivity) getActivity()).checker(R.id.drawer_contacts);
        ((MainActivity) getActivity()).lockAppBar(true, getResources().getString(R.string.drawer_contacts));

        ButterKnife.bind(this, getActivity());

        generateData();

        RecyclerView mRecyclerView = (RecyclerView) convertView.findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new RecycleUserAdapter(mUsers);
        mRecyclerView.setAdapter(mAdapter);

        return convertView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) mActionButton.getLayoutParams();
        params.setAnchorId(R.id.main_frame_container);
        params.anchorGravity = Gravity.BOTTOM | Gravity.RIGHT;
        mActionButton.setLayoutParams(params);
        mActionButton.setImageResource(R.drawable.ic_add_24dp);
        mActionButton.show();
    }

    private void generateData() {
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar1), "Иван", "Иванов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar2), "Петр", "Петров"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar3), "Семен", "Семенов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar4), "Василий", "Козлов"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar5), "Изя", "Васерман"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar6), "Руслан", "Урмеев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar7), "Константин", "Пожидаев"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar8), "Инга", "Инжир"));
        mUsers.add(new User(getResources().getDrawable(R.drawable.avatar9), "Анна", "Пожидаева"));
    }
}
