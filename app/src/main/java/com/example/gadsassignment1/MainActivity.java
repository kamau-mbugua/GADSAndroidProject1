package com.example.gadsassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
/*import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2;*/

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    /*private ViewPager2 viewPager2;*/
    private ViewPager viewPager;
    private TabItem tbTopLerner, tbTopSkills;
    public PageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tbTopLerner= findViewById(R.id.tbTopLerner);
        tbTopSkills = findViewById(R.id.tbTopSkills);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                    if (tab.getPosition() == 1){
                        pagerAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //viewPager.addOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

}