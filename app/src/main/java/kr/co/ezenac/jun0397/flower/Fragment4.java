package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.beans.Store;

/**
 * Created by Administrator on 2018-03-19.
 */

public class Fragment4 extends Fragment {
    @BindView(R.id.list_store) ListView list_store;
    ArrayList<Store> stores = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment4, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);

        //ImageView viewz = rootview.findViewById(R.id.viewz);
        return rootview;
    }

}
