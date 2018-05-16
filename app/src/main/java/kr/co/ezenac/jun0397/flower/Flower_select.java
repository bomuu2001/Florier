package kr.co.ezenac.jun0397.flower;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.Bean.Flower;
import kr.co.ezenac.jun0397.flower.adapter.FlowerListAdapter;

public class Flower_select extends AppCompatActivity {
    @BindView(R.id.flower_list)
    GridView flower_list;
    @BindView(R.id.btn_ok)
    Button btn_ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_dry_flower);
        ButterKnife.bind(this);

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

    }
    @OnClick(R.id.btn_ok)
    public void clickOk(View view) {
//        Intent intent = new Intent(Flower_select.this,MakeDryFlower.class);
//        startActivityForResult(intent, 0);
        finish();

    }
}
