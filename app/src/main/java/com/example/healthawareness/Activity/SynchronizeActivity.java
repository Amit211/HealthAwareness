package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.healthawareness.R;

public class SynchronizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synchronize);
        setTitle("Synchronize");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}