package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.Bean.Flower;
import kr.co.ezenac.jun0397.flower.Bean.Store;
import kr.co.ezenac.jun0397.flower.adapter.FlowerListAdapter;
import kr.co.ezenac.jun0397.flower.adapter.FlowerStoreListAdapter;

public class MainPage extends Fragment {
    @BindView(R.id.list_store) ListView list_store;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_main_page, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);

        ArrayList<Store> stores = new ArrayList<>();

        Store store1 = new Store(0,"데이데이플라워","서울시","강서구", 37.5570198, 126.8572475,"www.naver.com","0105040304","서울시 강서구 등촌3동");
        Store store2 = new Store(1,"밝은빛꽃","충청남도","보령시",36.3525227, 126.5987928, "www.naver.com","0105040304","충청남도 보령시 죽정동");
        stores.add(store1);
        stores.add(store2);

        FlowerStoreListAdapter FlowerStoreListadapter = new  FlowerStoreListAdapter(stores);
        list_store.setAdapter(FlowerStoreListadapter);

        //ImageView viewz = rootview.findViewById(R.id.viewz);
        return rootview;
    }

}
