package com.example.changelivi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private Window window;

    Button mBtnGreen;
    Button mBtnPurple;
    Button mBtnRed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnGreen = (Button) findViewById(R.id.btn_red);
        mBtnPurple = (Button) findViewById(R.id.btn_purple);
        mBtnRed = (Button) findViewById(R.id.btn_green);

        this.window = getWindow();

        mBtnRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark ="#43E047";
                String primary = "#43E047";
                String background= "#494949";
                /*String primaryDark = Integer.toString(red);
                String primary =  Integer.toString(red);
                String background=  Integer.toString(red);
                */

                cambiarColor(primaryDark,primary,background);
            }
        });
        mBtnPurple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#5C007A";
                String primary = "#8E24AA";
                String background= "#757575";
                cambiarColor(primaryDark,primary,background);            }
        });

        mBtnGreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String primaryDark = "#AB000D";
                String primary = "#E53935";
                String background= "#546E7A";
                cambiarColor(primaryDark,primary,background);            }
        });

    }

    private void cambiarColor(String primaryDark,String primary,String background){
        //ColorPrimaryDark
        window.setStatusBarColor(Color.parseColor(primaryDark));
        //ColorPrimary
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(primary)));
        //bg
        window.setBackgroundDrawable(new ColorDrawable(Color.parseColor(background)));
        //Botton navigation
        window.setNavigationBarColor(Color.parseColor(primary));

        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor",MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color",Color.parseColor(primaryDark));
        mEditor.apply();

    }
}