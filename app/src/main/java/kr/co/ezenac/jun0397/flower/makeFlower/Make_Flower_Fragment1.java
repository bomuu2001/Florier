package kr.co.ezenac.jun0397.flower.makeFlower;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.beans.Flower;
import kr.co.ezenac.jun0397.flower.CustomDialog;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.adapter.GridViewAdapter_Main;
import kr.co.ezenac.jun0397.flower.adapter.MakeFlowerAdapter_main;

public class Make_Flower_Fragment1 extends android.support.v4.app.Fragment {
    ArrayList<Flower> items = new ArrayList<>();
    @BindView(R.id.gridView) GridView gridView;
    @BindView(R.id.viewpager2) ViewPager viewPager2;
    @BindView(R.id.showChange) Button showChange;
    @BindView(R.id.view) RelativeLayout view;

    boolean a = false;

    CustomDialog customDialog;
    GridViewAdapter_Main gridViewAdapterMain;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.make_flower_fragment1, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);

        //데이터 임시 저장
        Flower flower1 = new Flower(0,"장미","사랑",2000,null);
        Flower flower2 = new Flower(0,"수국","노래",2500,null);
        Flower flower3 = new Flower(0,"카네이션","노예",2800,null);
        items.add(flower1);
        items.add(flower2);
        items.add(flower3);

        gridViewAdapterMain = new GridViewAdapter_Main(getLayoutInflater(), items);
        gridView.setAdapter(gridViewAdapterMain);

        MakeFlowerAdapter_main makeFlowerAdapterMain = new MakeFlowerAdapter_main(getContext(),items);
        viewPager2.setAdapter(makeFlowerAdapterMain);

        //그리드뷰 아이템 클릭시 다이얼로그 생성
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                customDialog = new CustomDialog(getActivity(),items);
//                customDialog.setData(i); //클릭아이템 으로 데이터 변경
                customDialog.show();
            }
        });

        return rootview;
    }
    //보기 변경
    @OnClick(R.id.showChange)
    public void clickshowChange(View view){
        if (a == false){
            showChange.setBackgroundResource(R.drawable.nine_squares2);
            viewPager2.setVisibility(View.GONE);
            gridView.setVisibility(View.VISIBLE);
            a = true;
        }else if(a ==true){
            showChange.setBackgroundResource(R.drawable.nine_squares1);
            viewPager2.setVisibility(View.VISIBLE);
            gridView.setVisibility(View.GONE);
            a = false;
        }
    }
}
