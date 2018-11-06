package kr.co.ezenac.jun0397.flower.shop;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.R;

public class Shop_Fragment3 extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.shop_fragment3, container, false);
        ButterKnife.bind(this,rootview);

        return rootview;
    }
}
