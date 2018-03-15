package kr.co.ezenac.jun0397.flower.Bean;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2018-03-14.
 */

public class Fragmentinfo {
    private int iconid;
    private String text;
    private Fragment fragment;

    public Fragmentinfo(int iconid, String text, Fragment fragment) {
        this.iconid = iconid;
        this.text = text;
        this.fragment = fragment;
    }

    public int getIconid() {
        return iconid;
    }

    public void setIconid(int iconid) {
        this.iconid = iconid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
