package com.android.rotinemypage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tabAll = tabHost.newTabSpec("INFO").setIndicator("내정보");
        tabAll.setContent(R.id.tabInfo);
        tabHost.addTab(tabAll);

        TabHost.TabSpec tabGongji = tabHost.newTabSpec("CLOSING").setIndicator("결산");
        tabGongji.setContent(R.id.tabClosing);
        tabHost.addTab(tabGongji);

        TabHost.TabSpec tabBrag = tabHost.newTabSpec("CONSTELLATION").setIndicator("별자리");
        tabBrag.setContent(R.id.tabConstell);
        tabHost.addTab(tabBrag);

        TabHost.TabSpec tabGomin = tabHost.newTabSpec("CALENDER").setIndicator("달력");
        tabGomin.setContent(R.id.tabCalender);
        tabHost.addTab(tabGomin);

        tabHost.setCurrentTab(0);

    }
}