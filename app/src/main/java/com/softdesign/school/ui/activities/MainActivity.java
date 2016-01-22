package com.softdesign.school.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.softdesign.school.R;
import com.softdesign.school.utils.Lg;

public class MainActivity extends AppCompatActivity{

    CheckBox mCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lg.log(Lg.ASSERT, getLocalClassName(), "onCreate");
        mCheckBox = (CheckBox)findViewById(R.id.checkBox);

    }

    protected void onClick(View view){
        switch (view.getId()){
            case R.id.button:
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
            case R.id.checkBox:
                break;
        }
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
}
