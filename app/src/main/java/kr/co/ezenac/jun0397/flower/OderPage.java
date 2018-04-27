package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import kr.co.ezenac.jun0397.flower.Bean.Store;
import kr.co.ezenac.jun0397.flower.adapter.FlowerStoreListAdapter;
import kr.co.ezenac.jun0397.flower.map.Fragment1;


/**
 * Created by Administrator on 2018-03-26.
 */

public class OderPage extends Fragment {

    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> location = new ArrayList<>();

    ArrayList<Store> stores = new ArrayList<>();

    /*@BindView(R.id.oder_page_text)
    TextView oder_page_text;

    @BindView(R.id.oder_page_price)
    Spinner oder_page_price;*/
    @BindView(R.id.oder_page_city) Spinner oder_page_city;
    @BindView(R.id.oder_page_location) Spinner oder_page_location;
    @BindView(R.id.list_store) ListView list_store;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_oder_page, container, false);
        Activity parentActivity = getActivity();

        ButterKnife.bind(this,rootview);

        price.add("1000");
        price.add("2000");
        price.add("3000");

        city.add("서울시");
        city.add("경기도");

        /*location.add("강남구");
        location.add("강서구");
        location.add("강북구");
        location.add("강동구");*/


        /*ArrayAdapter spinnerPrice;
        spinnerPrice = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, price);
        oder_page_price.setAdapter(spinnerPrice);*/

        ArrayAdapter spinnerCity;
        spinnerCity = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, city);
        oder_page_city.setAdapter(spinnerCity);

        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(new Bundle());
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHere, fragment1);
        fragmentTransaction.commit();


        Store store1 = new Store(0,"데이데이플라워","서울시","강서구","www.naver.com","0105040304","서울시 강서구 등촌동");
        Store store2 = new Store(1,"밝은빛꽃","충청남도","보령시","www.naver.com","0105040304","충청남도 보령시 죽정동");
        stores.add(store1);
        stores.add(store2);

        FlowerStoreListAdapter FlowerStoreListadapter = new FlowerStoreListAdapter(stores);
        list_store.setAdapter(FlowerStoreListadapter);

        return rootview;
    }

    /*@OnItemSelected(R.id.oder_page_price)
    public void onPriceSelected(View v, int i){
        Toast.makeText(getActivity(),"선택된 아이템 : "+ oder_page_price.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }*/

    @OnItemSelected(R.id.oder_page_city)
    public void onCitySelected(View v, int i){
        Toast.makeText(getActivity(), "선택된 지역: " +oder_page_city.getItemAtPosition(i), Toast.LENGTH_LONG).show();
        if(oder_page_city.getItemAtPosition(i).equals("서울시")){
            location.clear();
            location.add("강남구");
            location.add("강서구");
            location.add("강북구");
            location.add("강동구");
        } else if(oder_page_city.getItemAtPosition(i).equals("경기도")){
            location.clear();
            location.add("수원시");
            location.add("성남시");
            location.add("안양시");
            location.add("고양시");
        }

        ArrayAdapter spinnerLocation;
        spinnerLocation = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, location);
        oder_page_location.setAdapter(spinnerLocation);

    }

    @OnItemSelected(R.id.oder_page_location)
    public void onLocationSelected(View v, int i){
        Toast.makeText(getActivity(), "선택된 지역: " +oder_page_location.getItemAtPosition(i), Toast.LENGTH_LONG).show();
        if(oder_page_location.getItemAtPosition(i).equals("강서구")){
            //db에 강서구를 select해서 리턴해주는 값을 받아야한다. 그러면 이건 arrylist형태로 넘어오게 되고 이 것을 Store에 저장해야한다.
            stores.clear();
            Store list = new Store(0,"데이데이플라워","서울시","강서구","www.naver.com","0105040304","서울시 강서");
            stores.add(list);
            FlowerStoreListAdapter FlowerStoreListadapter = new FlowerStoreListAdapter(stores);
            list_store.setAdapter(FlowerStoreListadapter);
        }
    }
}