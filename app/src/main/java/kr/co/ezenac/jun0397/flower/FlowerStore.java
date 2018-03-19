package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.Bean.Flower;
import kr.co.ezenac.jun0397.flower.adapter.FlowerListAdapter;

/**
 * Created by Administrator on 2018-03-19.
 */

public class FlowerStore extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.make_dry_flower, container, false);
        Activity parentActivity = getActivity();

        GridView flower_list = rootview.findViewById(R.id.flower_list);
        ArrayList<Flower> flower = new ArrayList<>();

        Flower flower1 = new Flower(0,0,"장미드라이",25000,"www.naver.com");
        Flower flower2 = new Flower(0,0,"수국드라이",35000,"www.naver.com");
        Flower flower3 = new Flower(0,0,"튤립드라이",65000,"www.naver.com");
        Flower flower4 = new Flower(0,0,"오드드라이",75000,"www.naver.com");
        Flower flower5 = new Flower(0,0,"해바라기이",15000,"www.naver.com");
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
