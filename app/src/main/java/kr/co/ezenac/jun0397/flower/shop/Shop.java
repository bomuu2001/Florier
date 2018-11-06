package kr.co.ezenac.jun0397.flower.shop;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.adapter.ViewPagerAdapter;
import kr.co.ezenac.jun0397.flower.makeFlower.Make_Flower_Fragment1;
import kr.co.ezenac.jun0397.flower.makeFlower.Make_Flower_Fragment2;
import kr.co.ezenac.jun0397.flower.makeFlower.Make_Flower_Fragment3;

public class Shop extends AppCompatActivity {
    @BindView(R.id.tab) TabLayout tab;
    @BindView(R.id.viewpager) ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        ButterKnife.bind(this);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(R.mipmap.ic_launcher, "가게", new Shop_Fragment1());
        adapter.addFragment(R.drawable.ic_launcher_background, "상품", new Shop_Fragment2());
        adapter.addFragment(R.drawable.ic_launcher_background, "후기", new Shop_Fragment3());
        viewPager.setAdapter(adapter);

        tab.setupWithViewPager(viewPager);

        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
            tab.getTabAt(i).setIcon(adapter.getFragmentInfo(i).getIconid());
        }
    }
}
