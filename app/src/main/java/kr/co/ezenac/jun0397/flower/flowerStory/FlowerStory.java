package kr.co.ezenac.jun0397.flower.flowerStory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.R;

public class FlowerStory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_shop_goods);
        ButterKnife.bind(this);
    }
}
