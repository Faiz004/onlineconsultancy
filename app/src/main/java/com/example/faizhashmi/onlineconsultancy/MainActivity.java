package com.example.faizhashmi.onlineconsultancy;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        }

    public void onNextClick (View v) {

        Intent homeAcivity=new Intent(getBaseContext(),RegionActivity.class);
        startActivity(homeAcivity);

    }
}