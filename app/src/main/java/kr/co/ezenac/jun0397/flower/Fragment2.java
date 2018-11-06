package kr.co.ezenac.jun0397.flower;

import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import kr.co.ezenac.jun0397.flower.adapter.Shop_List_Adapter1;
import kr.co.ezenac.jun0397.flower.adapter.Shop_List_Adapter2;
import kr.co.ezenac.jun0397.flower.beans.Store;
import kr.co.ezenac.jun0397.flower.map.MapFragment;

/**
 * Created by Administrator on 2018-03-14.
 */

public class Fragment2 extends Fragment {
    @BindView(R.id.spinner_gu) Spinner spinner_gu;
    @BindView(R.id.spinner_dong) Spinner spinner_dong;
    @BindView(R.id.btn_search) Button btn_search;
    @BindView(R.id.list_shop2) RecyclerView list_shop2;

    ArrayList<Store> items = new ArrayList<>();
    ArrayList<Store> items2 = new ArrayList<>(); //선택지역 꽃집 리트스 저장용
    ArrayList<Store> items3 = new ArrayList<>(); //꽃집 리스트 클릭시 지도상 해당핀으로 이동용
    ArrayAdapter<CharSequence> adspin1, adspin2;

    MapFragment map = new MapFragment();
    Bundle bundle = new Bundle();
    //검색시 선택된 구,동 을 띄우기 위한 변수생성
    String choice_gu="";
    String choice_dong="";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment2, container, false);
        ButterKnife.bind(this,rootview);

        //구(ex서초구) 어댑터 생성~
        adspin1 = ArrayAdapter.createFromResource(getActivity(), R.array.gu, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gu.setAdapter(adspin1);

        Store store1 = new Store(5,"토끼풀꽃","마포구","서교동",37.5558254,126.9248356);
        Store store2 = new Store(7,"수수꽃다리","마포구","서교동",37.5558047,126.8569844);
        Store store3 = new Store(3,"주영플라워","서대문구","신촌동",37.5660411,126.9477262);
        items.add(store1);
        items.add(store2);
        items.add(store3);

        //전체꽃집 리스트
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // horizontaㅣ, vertical 옵션에 따라 가로/세로 list
        list_shop2.setHasFixedSize(true);
        list_shop2.setLayoutManager(layoutManager);

        Shop_List_Adapter2 shopListAdapter = new Shop_List_Adapter2(getActivity(),items);
        list_shop2.setAdapter(shopListAdapter);


        //네이버 지도 프래그먼트 연결
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentHere, map).replace(R.id.fragmentHere, map).commit();

        //리스트 클링시 이벤트
        final GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
        list_shop2.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.d("phk", "onInterceptTouchEvent");
                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int i = rv.findViewHolderForAdapterPosition(rv.getChildLayoutPosition(child)).getAdapterPosition();
                    ////꽃집 리스트 클릭시 지도상 해당핀으로 이동
                    items3.clear();
                    items3.add(items.get(i));
                    bundle.putParcelableArrayList("list", items3);
                    Log.d("ljy","보내는 items3 = "+items3);
                    map.setArguments(bundle);
                    map.onStart();
                    Toast.makeText(getActivity(), items.get(i).getName(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
                Log.d("phk", "onTouchEvent");
            }
            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                Log.d("phk", "onRequestDisallowInterceptTouchEvent");
            }
        });

        return rootview;
    }
    //클릭한 구에 따른 동 표시
    @OnItemSelected(R.id.spinner_gu)
    public void clickspinner_gu(final int position){
        if (adspin1.getItem(position).equals("서대문구")) {
            choice_gu = "서대문구";
            adspin2 = ArrayAdapter.createFromResource(getActivity(), R.array.dong_seodaemoon, android.R.layout.simple_spinner_dropdown_item);
            adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_dong.setAdapter(adspin2);
            //동 클릭시
            spinner_dong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                    choice_dong = adspin2.getItem(i).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { }
            });
        }else if(adspin1.getItem(position).equals("마포구")){
            choice_gu = "마포구";
            adspin2 = ArrayAdapter.createFromResource(getActivity(), R.array.dong_mapo, android.R.layout.simple_spinner_dropdown_item);
            adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_dong.setAdapter(adspin2);
            //동 클릭시
            spinner_dong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                    choice_dong = adspin2.getItem(i).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { }
            });
        }
    }
    //검색 클릭시 이벤트
    @OnClick(R.id.btn_search)
    public void clickbtn_search(View view){
        Toast.makeText(getActivity(), choice_gu + " - " + choice_dong, Toast.LENGTH_SHORT).show();
        sameLocation(choice_dong);

        map.onStart();
    }
    //items에 저장된 목록중 같은 dong에 위치한 꽃집 리스트를 뿌려줌
    public void sameLocation(String dong){
            items2.clear();
            for(int i=0; i<items.size(); i++){
                String list = items.get(i).getDong();
                Log.d("ljy","List = "+list);
                if(list.equals(dong)){
                    items2.add(items.get(i));
                    Log.d("ljy", "items2 = "+items2);
                }
            }
            //선택지역 꽃집 리스트 뿌려줌
            Shop_List_Adapter2 shopListAdapter2 = new Shop_List_Adapter2(getActivity(),items2);
            list_shop2.setAdapter(shopListAdapter2);

            //네이버 지도(꽃집 선택지역 리스트)
            bundle.putParcelableArrayList("list", items2);
            Log.d("ljy","보내는 items2 = "+items2);
            map.setArguments(bundle);
    }
}
