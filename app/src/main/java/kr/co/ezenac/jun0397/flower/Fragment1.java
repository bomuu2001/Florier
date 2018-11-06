package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import kr.co.ezenac.jun0397.flower.beans.FlowerStory;
import kr.co.ezenac.jun0397.flower.adapter.GridViewAdapter_FlowerStory;
import kr.co.ezenac.jun0397.flower.adapter.PictureAdapter;
import kr.co.ezenac.jun0397.flower.find_shop_goods.Find_shop_goods;
import kr.co.ezenac.jun0397.flower.makeFlower.MakeFlower;

public class Fragment1 extends Fragment {
    @BindView(R.id.startMake1) Button startMake1;
    @BindView(R.id.startMake2) ImageView startMake2;
    @BindView(R.id.top) ImageView top;
    @BindView(R.id.startFind1) Button startFind1;
    @BindView(R.id.startFind2) ImageView startFind2;
    @BindView(R.id.viewPager) ViewPager viewPager;
    @BindView(R.id.gridView) GridView gridView;

    ArrayList<FlowerStory> items = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);

        PictureAdapter adapter = new PictureAdapter(getActivity());
        viewPager.setAdapter(adapter);

        //임시 테스트 값 저장
        FlowerStory flowerStory1 = new FlowerStory(0,"꽃만드는 남자들","멋지게 차려입은 남자들이 만들어주는 꽃다발");
        FlowerStory flowerStory2 = new FlowerStory(1,"꽃만드는 여자들","이쁘게 차려입은 여자들이 만들어주는 꽃다발");
        FlowerStory flowerStory3 = new FlowerStory(2,"이달의 꽃다발","10월의 꽃다발은 튤립으로 만들은 꽃다발입니다");
        items.add(flowerStory1);
        items.add(flowerStory2);
        items.add(flowerStory3);
        GridViewAdapter_FlowerStory gridViewAdapterFlowerStory = new GridViewAdapter_FlowerStory(getContext(),items);
        gridView.setAdapter(gridViewAdapterFlowerStory);

        return rootview;
    }

    @OnClick({R.id.startMake1,R.id.startMake2})
    public void clickStartMake(View view){
        Intent intent = new Intent(getActivity(),MakeFlower.class);
        startActivity(intent);
    }
    @OnClick({R.id.startFind1,R.id.startFind2})
    public void clickStartFind(View view){
        Intent intent = new Intent(getActivity(),Find_shop_goods.class);
        startActivity(intent);
    }
    //클릭한 꽃이야기 페이지 생성
    @OnItemClick(R.id.gridView)
    public void clickgridview(int i){
        Intent intent = new Intent(getActivity(),MakeFlower.class);
    }
}
