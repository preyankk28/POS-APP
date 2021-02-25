package com.example.pocapp.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.pocapp.Adapter.TabLayoutAdapter;
import com.example.pocapp.R;
import com.google.android.material.tabs.TabLayout;

public class MDTActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Button continuebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mdtlayout);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tabLayout.addTab(tabLayout.newTab().setText("Fixed Amount"));
        tabLayout.addTab(tabLayout.newTab().setText("Same Amount"));
        tabLayout.addTab(tabLayout.newTab().setText("Custom Amount"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final TabLayoutAdapter adapter = new TabLayoutAdapter(this,getSupportFragmentManager(),
                tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}