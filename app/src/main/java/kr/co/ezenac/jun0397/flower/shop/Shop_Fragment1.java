package kr.co.ezenac.jun0397.flower.shop;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.beans.Store;

public class Shop_Fragment1 extends Fragment {

    @BindView(R.id.img_shop)ImageView img_shop;
    @BindView(R.id.shop_name)TextView shop_name;
    @BindView(R.id.shop_addr)TextView shop_addr;
    @BindView(R.id.shop_number)TextView shop_number;
    @BindView(R.id.openclose_time)TextView openclose_time;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.shop_fragment1, container, false);
        ButterKnife.bind(this,rootview);

        //클릭한 리스트 데이터 받아오기
        Bundle bundle = getArguments();
        if(bundle != null) {
             ArrayList<Store> items = getArguments().getParcelableArrayList("list");
        }
        Log.d("ljy", "list = " + bundle);
        //데이터 변경
//        shop_name.setText(items.get(0).getName());
//        shop_name.setText(items.get(0).getAddress());
//        shop_name.setText(items.get(0).getCall());
//        openclose_time.setText(items.get(0).getTime);
        return rootview;
    }

}
