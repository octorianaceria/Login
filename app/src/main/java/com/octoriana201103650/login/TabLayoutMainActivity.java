package com.octoriana201103650.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabLayoutMainActivity extends AppCompatActivity {
    private MyFragmentPagerAdapter _myFragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TabLayout tabLayout1 = (TabLayout)findViewById(R.id.tablayout1);
        tabLayout1.addTab(tabLayout1.newTab().setText("E-Commerce"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Berita"));
        tabLayout1.addTab(tabLayout1.newTab().setText("Kampus"));
        tabLayout1.setTabGravity(TabLayout.GRAVITY_FILL);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) final ViewPager viewPager1 = (ViewPager) findViewById(R.id.viewPager1);

        _myFragmentPagerAdapter = new MyFragmentPagerAdapter(this, getSupportFragmentManager(), tabLayout1.getTabCount());
        viewPager1.setAdapter(_myFragmentPagerAdapter);
        viewPager1.setOffscreenPageLimit(3);

        viewPager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout1));

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager1.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}