package com.example.android.boostcamp_facebook_practice;

import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity{
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.facebook_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
          int id = item.getItemId();

        if(R.id.message==id){
            Toast.makeText(MainActivity.this,"message button",LENGTH_SHORT).show();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    ViewPager vp;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);

        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
//        toolbar.setLogo(R.drawable.ic_plain_white);
//        View logoView = toolbar.getChildAt(1);
//        logoView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"plane button",LENGTH_SHORT).show();
//            }
//        });
//
//        toolbar.findViewById(R.id.logo_image).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(),"plane button",LENGTH_SHORT).show();
//            }
//        });


        tabLayout = (TabLayout) findViewById(R.id.vp_tab);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        vp = (ViewPager)findViewById(R.id.vp);
        vp.requestFocus();
       // /dd
        vp.setAdapter(new TabPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount()));
     vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                vp.setCurrentItem(position);
                switch(position){
                    case 0:
                        tabLayout.getTabAt(position).setIcon(R.drawable.ic_3bar_blue);
                        break;
                    case 1:
                        tabLayout.getTabAt(position).setIcon(R.drawable.ic_alarm_blue);
                        break;
                    case 2:
                        tabLayout.getTabAt(position).setIcon(R.drawable.ic_timeline_blue);
                        break;

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                int position = tab.getPosition();

                switch(position){
                    case 0:
                        tabLayout.getTabAt(position).setIcon(R.drawable.ic_3bar_grey);
                        break;
                    case 1:
                        tabLayout.getTabAt(position).setIcon(R.drawable.ic_alarm_grey);
                        break;
                    case 2:
                        tabLayout.getTabAt(position).setIcon(R.drawable.ic_timeline_grey);
                        break;

                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

   }
}

    class TabPagerAdapter extends FragmentStatePagerAdapter {

        // Count number of tabs
        private int tabCount;

        public TabPagerAdapter(FragmentManager fm, int tabCount) {
                super(fm);
                this.tabCount = tabCount;
        }

        @Override
        public Fragment getItem(int position) {

                // Returning the current tabs
                switch (position) {
                    case 0:
                        return  new Main_frag_first();
                    case 1:
                       return new Main_frag_second();
                    case 2:
                        return new Main_frag_third();
                    default:
                        return null;
                    }
                }

        @Override
        public int getCount() {
            return tabCount;
        }
    }