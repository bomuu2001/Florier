package kr.co.ezenac.jun0397.flower;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.beans.Flower;
import kr.co.ezenac.jun0397.flower.makeFlower.MakeFlower;

/**
 * Created by Administrator on 2018-03-26.
 */

public class CustomDialog extends Dialog {

    @BindView(R.id.img_flower) ImageView img_flower;
    @BindView(R.id.tx_flower_name) TextView tx_flower_name;
    @BindView(R.id.tx_flower_language) TextView tx_flower_language;
    @BindView(R.id.tx_flower_price) TextView tx_flower_price;
    @BindView(R.id.btn_minus) Button btn_minus;
    @BindView(R.id.btn_plus) Button btn_plus;
    @BindView(R.id.tx_count) TextView tx_count;
    @BindView(R.id.shopping_bag) Button shopping_bag;
    @BindView(R.id.btn_cancle) Button btn_cancle;

    ArrayList<Flower> items = new ArrayList<>();
    int a = 1; //tx_count 변수

    public CustomDialog(@NonNull Context context, ArrayList<Flower> items) {
        super(context);
        this.items = items;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//타이틀 바 삭제
        //getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT)); //다이얼로그의 배경을 투명으로 만듭니다.
        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);

    }
    //다이얼로그를 닫기
    @OnClick(R.id.btn_cancle)
    public void clickbtn_cancle(View view){
        dismiss();
    }
    //"+" 클릭시 수량증가
    @OnClick(R.id.btn_plus)
    public void clickbtn_plus(View view){
        a++;
        tx_count.setText(String.valueOf(a));
    }
    //"-" 클릭시 수량증가
    @OnClick(R.id.btn_minus)
    public void clickbtn_minus(View view){
        if(a != 0) {
            a--;
            tx_count.setText(String.valueOf(a));
        }
    }
    //장바구니 추가
    @OnClick(R.id.shopping_bag)
    public void clickshopping_bag(View view){

        String flower_name = tx_flower_name.getText().toString();
        int flower_price = Integer.parseInt(tx_flower_price.getText().toString());
        Log.d("ljy","name = "+flower_name+" "+"price = "+flower_price);

        //makeflower 클라스로 데이터 보냄
        Intent intent = new Intent(getContext(),MakeFlower.class);
        intent.putExtra("flower_name",flower_name);
        intent.putExtra("flower_price",flower_price);
        intent.putExtra("flower_quantity",a);
        getContext().startActivity(intent);
    }
    //클릭한 아이템으로 데이터 변경
    public void setData(int i){
//        int a = Integer.parseInt(items.get(i).getFlower_img());
//        img_flower.setBackgroundResource(R.drawable.a);
//        tx_flower_name.setText(items.get(i).getFlower_name());
//        tx_flower_language.setText(items.get(i).getFlower_language());
//        tx_flower_price.setText(String.valueOf(items.get(i).getFlower_price()));
    }
}
