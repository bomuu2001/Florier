package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import kr.co.ezenac.jun0397.flower.Bean.Flower;
import kr.co.ezenac.jun0397.flower.adapter.FlowerListAdapter;

/**
 * Created by Administrator on 2018-03-14.
 */

public class MakeRealFlower extends Fragment{
    @BindView(R.id.flower_list) GridView flower_list;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.make_real_flower, container, false);
        Activity parentActivity = getActivity();

        ArrayList<Flower> flower = new ArrayList<>();

        Flower flower1 = new Flower(0,0,"장미",25000,"www.naver.com");
        Flower flower2 = new Flower(0,0,"수국",35000,"www.naver.com");
        Flower flower3 = new Flower(0,0,"튤립",65000,"www.naver.com");
        Flower flower4 = new Flower(0,0,"오드",75000,"www.naver.com");
        Flower flower5 = new Flower(0,0,"해바라기",15000,"www.naver.com");
        flower.add(flower1);
        flower.add(flower2);
        flower.add(flower3);
        flower.add(flower4);
        flower.add(flower5);

        FlowerListAdapter FlowerListadapter = new FlowerListAdapter(flower);
        flower_list.setAdapter(FlowerListadapter);

        //ImageView viewz = rootview.findViewById(R.id.viewz);
        return rootview;
    }

}
