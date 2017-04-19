package com.example.emp2.expandablelistview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class Create_Cash_Invoice_MainActivity extends AppCompatActivity {

    /*TextView date ;
    int dd,mm,yy;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__cash__invoice__main);
       /* date=(TextView)findViewById(R.id.currentDate);
        final Calendar cal = Calendar.getInstance();
        dd = cal.get(Calendar.DAY_OF_MONTH);
        mm = cal.get(Calendar.MONTH);
        yy = cal.get(Calendar.YEAR);
// set current date into textview
        date.setText(new StringBuilder()
// Month is 0 based, just add 1
                .append(dd).append("-").append(mm + 1).append("-")
                .append(yy));*/


        List<Fragment> fragments = new Vector<>();
        fragments.add(Fragment.instantiate(Create_Cash_Invoice_MainActivity.this,Create_Cash_Item.class.getName()));
        fragments.add(Fragment.instantiate(Create_Cash_Invoice_MainActivity.this,Create_Cash_Payment.class.getName()));

        MyTabListener adapter = new MyTabListener(getSupportFragmentManager(),fragments);
        final ViewPager pager = (ViewPager)findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        if(getSupportActionBar()!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }


        final ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };
        actionBar.addTab(actionBar.newTab().setText(getText(R.string.CreateCashInvoice_Tab1)).setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText(getText(R.string.CreateCashInvoice_Tab2)).setTabListener(tabListener));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
