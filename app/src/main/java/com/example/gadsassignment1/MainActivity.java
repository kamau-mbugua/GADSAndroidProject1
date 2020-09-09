package com.example.gadsassignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
/*import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2;*/

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {



    private TabLayout tabLayout;
    /*private ViewPager2 viewPager2;*/
    private ViewPager viewPager;
    private TabItem tbTopLerner, tbTopSkills;
    public PageAdapter pagerAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Re-name the Action Car and add back Arrow
        /*getSupportActionBar().setTitle("LEADERBOAD");*/

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        tbTopLerner= findViewById(R.id.tbTopLerner);
        tbTopSkills = findViewById(R.id.tbTopSkills);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        Button btnSubmit = findViewById(R.id.btnSubmit);

        pagerAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(   MainActivity.this,SubmitForm.class);
                startActivity(intent);
                return;
            }
        });

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