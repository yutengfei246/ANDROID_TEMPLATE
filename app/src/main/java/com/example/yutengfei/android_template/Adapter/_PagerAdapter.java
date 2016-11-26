package com.example.yutengfei.android_template.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by yutengfei on 29/08/16.
 */
public class _PagerAdapter extends FragmentPagerAdapter {

    private int numItems ;
    private Context mContext;
    private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();
    private List<String> theTab;



    static final class TabInfo{
        private final Class<?> clss;
        private final Bundle args;

        TabInfo(Class<?> _class, Bundle _args){
            clss = _class;
            args = _args;
        }
    }

    public _PagerAdapter(FragmentManager fragmentManager, int numItems, Context context){
        super(fragmentManager);
        this.numItems = numItems;
        this.mContext = context;
        this.theTab = new ArrayList<>();
    }

    public void addTab(Class<?> clss, Bundle args, String tab){
        TabInfo info = new TabInfo(clss, args);
        mTabs.add(info);
        this.theTab.add(tab);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        TabInfo info = mTabs.get(position);
        switch (position) {
            case 0:
                return Fragment.instantiate(mContext, info.clss.getName(), info.args);
            case 1:
                return Fragment.instantiate(mContext, info.clss.getName(), info.args);
            case 2:
                return Fragment.instantiate(mContext, info.clss.getName(), info.args);
            case 3:
                return Fragment.instantiate(mContext, info.clss.getName(), info.args);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numItems;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.theTab.get(position).toLowerCase();
    }
}
