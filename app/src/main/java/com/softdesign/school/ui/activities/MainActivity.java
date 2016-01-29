package com.softdesign.school.ui.activities;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;


import com.softdesign.school.utils.*;

import java.util.Set;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CheckBox mCheckBox;
    Button mRed;
    Button mGreen;
    Button mBlue;
    Toolbar mToolbar;

    private int[] mColors;

    private static final String COLORS_KEY = "colors";
    private static final String CHECKED_KEY = "checked";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Lg.log(Lg.ASSERT, getLocalClassName(), "++++++++++++++++++++++++++++++");
        Lg.log(Lg.ASSERT, getLocalClassName(), "onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCheckBox = (CheckBox)findViewById(R.id.checkBox);
        mCheckBox.setOnClickListener(this);

        mRed = (Button)findViewById(R.id.button);
        mRed.setOnClickListener(this);
        mGreen = (Button)findViewById(R.id.button2);
        mGreen.setOnClickListener(this);
        mBlue = (Button)findViewById(R.id.button3);
        mBlue.setOnClickListener(this);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setupToolbar();
        mColors = new int[]{R.color.colorPrimaryDark, R.color.colorPrimary};
    }

    private void setupToolbar(){
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Toast.makeText(this, "menu", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                mColors = new int[]{R.color.colorPrimaryDarkRed, R.color.colorPrimaryRed};
                SetTheme(mColors);
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                mColors = new int[]{R.color.colorPrimaryDarkGreen, R.color.colorPrimaryGreen};
                SetTheme(mColors);
                Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                mColors = new int[]{R.color.colorPrimaryDark, R.color.colorPrimary};
                SetTheme(mColors);
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox:
                Toast.makeText(this, "Check", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * Устанавливает цвет StatusBar'a и Toolbar'a,
     *
     * @param colors  Масссив цветов [StatusBar color, Toolbar color]
     */

    public void SetTheme(int[] colors){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(colors[0]));
        }

        mToolbar.setBackgroundColor(getResources().getColor(colors[1]));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Lg.log(Lg.ASSERT, getLocalClassName(), "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Lg.log(Lg.ASSERT, getLocalClassName(), "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Lg.log(Lg.ASSERT, getLocalClassName(), "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Lg.log(Lg.ASSERT, getLocalClassName(), "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Lg.log(Lg.ASSERT, getLocalClassName(), "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Lg.log(Lg.ASSERT, getLocalClassName(), "onRestart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(COLORS_KEY, mColors);
        outState.putBoolean(CHECKED_KEY, mCheckBox.isChecked());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mColors = savedInstanceState.getIntArray(COLORS_KEY);
        SetTheme(mColors);
        mCheckBox.setChecked(savedInstanceState.getBoolean(CHECKED_KEY));
    }
}
