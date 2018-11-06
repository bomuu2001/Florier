package kr.co.ezenac.jun0397.flower.shop;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.beans.Store;

public class Shop_Fragment2 extends Fragment {


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.shop_fragment2, container, false);
        ButterKnife.bind(this,rootview);

        return rootview;
    }
}
