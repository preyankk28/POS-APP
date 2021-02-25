package com.example.pocapp.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pocapp.R;
import com.google.android.material.card.MaterialCardView;

public class SettingsActivity extends AppCompatActivity {
  MaterialCardView materialCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        materialCardView = findViewById(R.id.linearlayout);


    }
    public void imageclick(View view) {
        materialCardView.setVisibility(View.VISIBLE);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}