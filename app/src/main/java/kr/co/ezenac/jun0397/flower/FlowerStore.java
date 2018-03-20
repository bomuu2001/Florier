package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.Bean.Flower;
import kr.co.ezenac.jun0397.flower.Bean.Store;
import kr.co.ezenac.jun0397.flower.adapter.FlowerListAdapter;
import kr.co.ezenac.jun0397.flower.adapter.FlowerStoreListAdapter;

/**
 * Created by Administrator on 2018-03-19.
 */

public class FlowerStore extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.flower_store, container, false);
        Activity parentActivity = getActivity();

        ListView list_store = rootview.findViewById(R.id.list_store);
        ArrayList<Store> stores = new ArrayList<>();

        Store store1 = new Store(0,"데이데이플라워","서울시","강서구","www.naver.com","0105040304","서울시 강서구 등촌동");
        Store store2 = new Store(1,"밝은빛꽃","충청남도","보령시","www.naver.com","0105040304","충청남도 보령시 죽정동");
        stores.add(store1);
        stores.add(store2);

        FlowerStoreListAdapter FlowerStoreListadapter = new  FlowerStoreListAdapter(stores);
        list_store.setAdapter(FlowerStoreListadapter);

        //ImageView viewz = rootview.findViewById(R.id.viewz);
        return rootview;
    }

}
