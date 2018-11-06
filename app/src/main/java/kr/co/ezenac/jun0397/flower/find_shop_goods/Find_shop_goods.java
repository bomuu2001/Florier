package kr.co.ezenac.jun0397.flower.find_shop_goods;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import kr.co.ezenac.jun0397.flower.beans.Shop;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.adapter.Shop_List_Adapter1;

public class Find_shop_goods extends AppCompatActivity {
    @BindView(R.id.spinner_gu) Spinner spinner_gu;
    @BindView(R.id.spinner_dong) Spinner spinner_dong;
    @BindView(R.id.btn_search) Button btn_search;
    @BindView(R.id.list_shop) RecyclerView list_shop;
    @BindView(R.id.back) Button back;
    ArrayAdapter<CharSequence> adspin1, adspin2;
    ArrayList<Shop> items = new ArrayList<>();

    //검색시 선택된 매세지를 띄우기 위한 변수생성
    String choice_gu="";
    String choice_dong="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_shop_goods);
        ButterKnife.bind(this);

        //구 어댑터 생성
        adspin1 = ArrayAdapter.createFromResource(this, R.array.gu, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_gu.setAdapter(adspin1);

        //임시 테스트용 꽃집 생성
        Shop shop1 = new Shop(0,"토끼풀꽃","마포구","서교동");
        Shop shop2 = new Shop(1,"수수꽃다리","마포구","서교동");
        Shop shop3 = new Shop(2,"주영플라워","서대문구","북아현동");
        items.add(shop1);
        items.add(shop2);
        items.add(shop3);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); // horizontaㅣ, vertical 옵션에 따라 가로/세로 list
        list_shop.setHasFixedSize(true);
        list_shop.setLayoutManager(layoutManager);

        Shop_List_Adapter1 shopListAdapter = new Shop_List_Adapter1(this,items);
        list_shop.setAdapter(shopListAdapter);

    }
    //클릭한 구에 따른 동 표시
    @OnItemSelected(R.id.spinner_gu)
    public void clickspinner_gu(final int position){
        if (adspin1.getItem(position).equals("서대문구")) {
            choice_gu = "서대문구";
            adspin2 = ArrayAdapter.createFromResource(Find_shop_goods.this, R.array.dong_seodaemoon, android.R.layout.simple_spinner_dropdown_item);
            adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_dong.setAdapter(adspin2);
            //동 클릭시
            spinner_dong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                        choice_dong = adspin2.getItem(i).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { }
            });
        }else if(adspin1.getItem(position).equals("마포구")){
            choice_gu = "마포구";
            adspin2 = ArrayAdapter.createFromResource(Find_shop_goods.this, R.array.dong_mapo, android.R.layout.simple_spinner_dropdown_item);
            adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner_dong.setAdapter(adspin2);
            //동 클릭시
            spinner_dong.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                    choice_dong = adspin2.getItem(i).toString();
                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) { }
            });
        }
    }
    //검색 클릭시 이벤트
    @OnClick(R.id.btn_search)
    public void clickbtn_search(View view){
        Toast.makeText(Find_shop_goods.this, choice_gu + " - " + choice_dong, Toast.LENGTH_SHORT).show();
        if(choice_dong.equals("창천동")){

        }
    }
    //뒤로가기
    @OnClick(R.id.back)
    public void clickback(View view){
        finish();
    }
}
