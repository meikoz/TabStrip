package com.android.meiko;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.android.meiko.fragment.FindFragment;
import com.android.meiko.fragment.HomeFragment;
import com.android.meiko.fragment.MomentsFragment;
import com.android.meiko.fragment.PersonFragment;
import com.android.tabstrip.TabStripView;

public class MainActivity extends AppCompatActivity {

    private TabStripView navigateTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigateTabBar = (TabStripView) findViewById(R.id.navigateTabBar);
        //对应xml中的containerId
        navigateTabBar.setFrameLayoutId(R.id.main_container);
        //对应xml中的navigateTabTextColor
        navigateTabBar.setTabTextColor(getResources().getColor(R.color.tab_text_normal));
        //对应xml中的navigateTabSelectedTextColor
        navigateTabBar.setSelectedTabTextColor(getResources().getColor(R.color.colorPrimary));

        //恢复选项状态
        navigateTabBar.onRestoreInstanceState(savedInstanceState);

        navigateTabBar.addTab(HomeFragment.class, new TabStripView.TabParam(R.mipmap.ic_tab_bar_home, R.mipmap.ic_tab_bar_mine_selected, R.string.tab_bar_text_home));
        navigateTabBar.addTab(MomentsFragment.class, new TabStripView.TabParam(R.mipmap.ic_tab_bar_moments, R.mipmap.ic_tab_bar_moments_selected, R.string.tab_bar_text_moments));
        navigateTabBar.addTab(FindFragment.class, new TabStripView.TabParam(R.mipmap.ic_tab_bar_find, R.mipmap.ic_tab_bar_find_selected, R.string.tab_bar_text_find));
        navigateTabBar.addTab(PersonFragment.class, new TabStripView.TabParam(R.mipmap.ic_tab_bar_person, R.mipmap.ic_tab_bar_person_selected, R.string.tab_bar_text_person));
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //保存当前选中的选项状态
        navigateTabBar.onSaveInstanceState(outState);
    }

}
