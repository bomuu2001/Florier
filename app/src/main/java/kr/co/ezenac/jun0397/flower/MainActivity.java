package kr.co.ezenac.jun0397.flower;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import kr.co.ezenac.jun0397.flower.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    Button btn_dra;
    LinearLayout drawer;
    DrawerLayout drawer_layout;
    TabLayout mTabLayout;
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabLayout = (TabLayout) findViewById(R.id.tab);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        drawer_layout = findViewById(R.id.drawer_layout);
        drawer = findViewById(R.id.drawer);
        btn_dra=findViewById(R.id.btn_dra);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(R.mipmap.ic_launcher, "Page1", new MakeRealFlower());
        adapter.addFragment(R.drawable.ic_launcher_background, "page2", new MakeDryFlower());
        adapter.addFragment(R.drawable.ic_launcher_background, "Page3", new MakeRealFlower());
        adapter.addFragment(R.drawable.ic_launcher_background, "Page4", new MakeRealFlower());
        mViewPager.setAdapter(adapter);

        mTabLayout.setupWithViewPager(mViewPager);

        for (int i = 0; i < mViewPager.getAdapter().getCount(); i++) {
            mTabLayout.getTabAt(i).setIcon(adapter.getFragmentInfo(i).getIconid());
        }

        btn_dra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_layout.openDrawer(drawer);
            }
        });
    }
}
