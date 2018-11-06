package kr.co.ezenac.jun0397.flower.makeFlower;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import android.widget.Button;

import android.widget.ListView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.beans.ShoppingBagList;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.adapter.ShoppingBagAdapter;
import kr.co.ezenac.jun0397.flower.adapter.ViewPagerAdapter;


public class MakeFlower extends AppCompatActivity {
    @BindView(R.id.tab2) TabLayout tab;
    @BindView(R.id.viewpager1) ViewPager viewPager1;
    @BindView(R.id.handle) Button handle;
    @BindView(R.id.cart_list) ListView cart_list;
    @BindView(R.id.sum_price) TextView sum_price;
    @BindView(R.id.back) Button back;
    @BindView(R.id.drawer) SlidingDrawer drawer;
    @BindView(R.id.btn_order) Button btn_order;

    ArrayList<ShoppingBagList> items = new ArrayList<>();
    ShoppingBagAdapter shoppingBagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_flower);
        ButterKnife.bind(this);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(R.mipmap.ic_launcher, "메인꽃", new Make_Flower_Fragment1());
        adapter.addFragment(R.drawable.ic_launcher_background, "배경꽃", new Make_Flower_Fragment2());
        adapter.addFragment(R.drawable.ic_launcher_background, "추천꽃", new Make_Flower_Fragment3());
        viewPager1.setAdapter(adapter);

        tab.setupWithViewPager(viewPager1);

        for (int i = 0; i < viewPager1.getAdapter().getCount(); i++) {
            tab.getTabAt(i).setIcon(adapter.getFragmentInfo(i).getIconid());
        }

        //고객이 장바구니에 넣은 아이템
        Intent intent = getIntent();

        String flower_name = intent.getStringExtra("flower_name");
        int flower_price = intent.getIntExtra("flower_price",0);
        int flower_quantity = intent.getIntExtra("flower_quantity",0);

        if(flower_name != null & flower_price != 0 & flower_quantity != 0) {
            Log.d("ljy", flower_name + "  " + flower_price + "  " + flower_quantity);
            ShoppingBagList shoppingBagList = new ShoppingBagList(0,"ljy",flower_name,flower_price,flower_quantity);//user_id 임시 ljy로 설정

            items.add(shoppingBagList);
            shoppingBagAdapter = new ShoppingBagAdapter(this, items);
            shoppingBagAdapter.notifyDataSetChanged();
            cart_list.setAdapter(shoppingBagAdapter);
        }else{
            Log.d("ljy", flower_name + "  " + flower_price + "  " + flower_quantity);
            return;
        }
    }
    //뒤로가기
    @OnClick(R.id.back)
    public void clickback(View view){
        finish();
    }
    //하단 장바구니 닫기
    @OnClick(R.id.handle)
    public void clickup_down(View view){
        drawer.animateClose();
    }
    //주문하기 클릭
    @OnClick(R.id.btn_order)
    public void clickbtn_order(View view){

    }
    //총금액 변경
    public void setSum_price(int a){
        Log.d("ljy","a = "+a);
        String b =String.valueOf(a);
        sum_price.setText(b);
    }
}
