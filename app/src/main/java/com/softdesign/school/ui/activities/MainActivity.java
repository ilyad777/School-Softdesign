package com.softdesign.school.ui.activities;


import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.softdesign.school.ui.fragments.*;
import com.softdesign.school.utils.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Toolbar mToolbar;
    private NavigationView mNavigationView;
    private DrawerLayout mNavigationDrawer;
    private MenuItem mItem;
    private Fragment mFragment;
    private FrameLayout mFrameContainer;
    private static final String CHECKED_KEY = "checked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.a(getLocalClassName(), "++++++++++++++++++++++++++++++");
        Lg.a(getLocalClassName(), "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawer = (DrawerLayout)findViewById(R.id.navigation_drawer);
        mNavigationView = (NavigationView)findViewById(R.id.navigation_view);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setupToolbar();

        setupDrawer();
        mFrameContainer = (FrameLayout)findViewById(R.id.main_frame_container);
        if(savedInstanceState != null){

        }else{
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container,new ProfileFragment()).commit();
            mItem = mNavigationView.getMenu().findItem(R.id.drawer_profile);
            mItem.setChecked(true);
        }

    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Устанавливает выделение выбранного пункта меню
     * @param item пункт меню
     */
    private void checker(MenuItem item){
        mItem.setChecked(false);
        item.setChecked(true);
        mItem = item;
    }

    private void setupDrawer(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        checker(item);
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        checker(item);
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        checker(item);
                        break;
                    case R.id.drawer_teem:
                        mFragment = new TeemFragment();
                        checker(item);
                        break;
                    case R.id.drawer_settings:
                        mFragment = new SettingsFragment();
                        checker(item);
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, mFragment).addToBackStack(null).commit();
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Toast.makeText(this, "menu", Toast.LENGTH_SHORT).show();
        }
        mNavigationDrawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){

    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.a(getLocalClassName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.a(getLocalClassName(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.a(getLocalClassName(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.a(getLocalClassName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.a(getLocalClassName(), "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.a(getLocalClassName(), "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Lg.a(getLocalClassName(), "onSave");
        outState.putInt(CHECKED_KEY, mItem.getItemId());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.a(getLocalClassName(), "onRestore");
        mItem = mNavigationView.getMenu().findItem(savedInstanceState.getInt(CHECKED_KEY));
        mItem.setChecked(true);
    }
}
