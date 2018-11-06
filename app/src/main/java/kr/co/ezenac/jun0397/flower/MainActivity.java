package kr.co.ezenac.jun0397.flower;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


import butterknife.BindView;
import butterknife.ButterKnife;
import kr.co.ezenac.jun0397.flower.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.drawer)LinearLayout drawer;
    @BindView(R.id.drawer_layout)DrawerLayout drawer_layout;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Call<ArrayList<flower_test>> item = RetrofitService.getInstance().getRetrofitRequest().test(1,"장미");
//        Log.d("ksj","들어옴");
//        item.enqueue(new Callback<ArrayList<flower_test>>() {
//            @Override
//            public void onResponse(Call<ArrayList<flower_test>> call, Response<ArrayList<flower_test>> response) {
//                if(response.isSuccessful()){
//                    Log.d("ksj","안들어올시");
//                    ArrayList<flower_test> items  = response.body();
//                    Log.d("ksj","값들 : " +  items.get(0).getFlower_name());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ArrayList<flower_test>> call, Throwable t) {
//
//            }
//        });

        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(R.mipmap.ic_launcher, "Page2", new Fragment1());
        adapter.addFragment(R.drawable.ic_launcher_background, "page1", new Fragment2());
        adapter.addFragment(R.drawable.ic_launcher_background, "Page3", new Fragment3());
        adapter.addFragment(R.drawable.ic_launcher_background, "Page4", new Fragment4());
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mViewPager.getAdapter().getCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(adapter.getFragmentInfo(i).getIconid());
        }

    }
}
