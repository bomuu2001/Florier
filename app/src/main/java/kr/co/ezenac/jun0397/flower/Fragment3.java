package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2018-03-26.
 */

public class Fragment3 extends Fragment {


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment3, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);


        return rootview;
    }
}