package com.softdesign.school.ui.activities;


import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.softdesign.school.ui.fragments.*;
import com.softdesign.school.utils.*;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment mFragment;
    public AppBarLayout.LayoutParams params = null;

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.navigation_drawer)
    DrawerLayout mNavigationDrawer;
    @Bind(R.id.navigation_view)
    NavigationView mNavigationView;
    @Bind(R.id.appbar_layout)
    AppBarLayout mAppBar;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout mCollapsingToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.a(getLocalClassName(), "++++++++++++++++++++++++++++++");
        Lg.a(getLocalClassName(), "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setupToolbar();
        setupDrawer();

        if (savedInstanceState != null) {
        } else {
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container, new ProfileFragment()).commit();
        }

    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    public void setTitle(int title) {
        mCollapsingToolbar.setTitle(getResources().getString(title));
    }

    /**
     * Устанавливает выделение выбранного пункта меню
     *
     * @param id пункт меню
     */

    public void checker(int id) {
        mNavigationView.getMenu().findItem(id).setChecked(true);
    }

    private void setupDrawer() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.drawer_profile:
                        mFragment = new ProfileFragment();
                        break;
                    case R.id.drawer_contacts:
                        mFragment = new ContactsFragment();
                        break;
                    case R.id.drawer_tasks:
                        mFragment = new TasksFragment();
                        break;
                    case R.id.drawer_teem:
                        mFragment = new TeemFragment();
                        break;
                    case R.id.drawer_settings:
                        mFragment = new SettingsFragment();
                        break;
                }
                if (mFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.main_frame_container,
                            mFragment).addToBackStack(mFragment.getClass().getName()).commit();
                }
                mNavigationDrawer.closeDrawers();
                return false;
            }
        });
    }

    public void lockAppBar(boolean collapse, String title) {

        params = (AppBarLayout.LayoutParams) mCollapsingToolbar.getLayoutParams();
        mCollapsingToolbar.setTitle(title);

        if (collapse) {
            AppBarLayout.OnOffsetChangedListener mListener = new AppBarLayout.OnOffsetChangedListener() {
                @Override
                public void onOffsetChanged(AppBarLayout mAppBar, int verticalOffset) {
                    if (mCollapsingToolbar.getHeight() + verticalOffset <= ViewCompat.getMinimumHeight(mCollapsingToolbar) + getStatusBarHeight()) {
                        mAppBar.removeOnOffsetChangedListener(this);
                    }
                }
            };
            mAppBar.addOnOffsetChangedListener(mListener);
            mAppBar.setExpanded(false);
        } else {
            mAppBar.setExpanded(true);
            params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL | AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
            mCollapsingToolbar.setLayoutParams(params);
        }
    }

    public int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "menu", Toast.LENGTH_SHORT).show();
        }
        mNavigationDrawer.openDrawer(GravityCompat.START);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Fragment findingFragment = (Fragment) getSupportFragmentManager().findFragmentById(R.id.main_frame_container);

        if (findingFragment != null && findingFragment instanceof ProfileFragment) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        super.onBackPressed();
    }


    public void onClick(View view) {
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
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Lg.a(getLocalClassName(), "onRestore");
    }
}
