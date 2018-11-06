package kr.co.ezenac.jun0397.flower.makeFlower;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.R;

public class Make_Flower_Fragment3 extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.make_flower_fragment3, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);


        //ImageView viewz = rootview.findViewById(R.id.viewz);
        return rootview;
    }
}
