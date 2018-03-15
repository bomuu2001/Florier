package kr.co.ezenac.jun0397.flower.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.Bean.Fragmentinfo;

/**
 * Created by Administrator on 2018-03-14.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragmentinfo> fragmentinfo = new ArrayList<>();

    public  void addFragment(int iconid,String title, Fragment fragment){
        Fragmentinfo info = new Fragmentinfo(iconid,title,fragment);
        fragmentinfo.add(info);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentinfo.get(position).getText();
    }

    public Fragmentinfo getFragmentInfo(int position) {
        return fragmentinfo.get(position);
    }

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentinfo.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return fragmentinfo.size();
    }
}
