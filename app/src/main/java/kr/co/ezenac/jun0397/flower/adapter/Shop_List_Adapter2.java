package kr.co.ezenac.jun0397.flower.adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.shop.Shop;
import kr.co.ezenac.jun0397.flower.beans.Store;
import kr.co.ezenac.jun0397.flower.shop.Shop_Fragment1;

public class Shop_List_Adapter2 extends RecyclerView.Adapter<Shop_List_Adapter2.ViewHolder2>{
    Context context;
    ArrayList<Store> items;
    ArrayList<Store> items2 = new ArrayList<>(); //데이터 보내는용



    public Shop_List_Adapter2(Context context, ArrayList<Store> items) {
        this.context = context;
        this.items = items;
    }
    @Override
    public ViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_list_item2,parent,false);

        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder2 holder, final int i) {
        holder.shop_name.setText(items.get(i).getName());
        holder.shop_gu.setText(items.get(i).getGu());
        holder.shop_dong.setText(items.get(i).getDong());
        //꽃집 상세보기 클릭시 데이터 넘김
        holder.btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Shop.class);
                Bundle bundle = new Bundle();
                Shop_Fragment1 shopFragment1 = new Shop_Fragment1();
                items2.clear();
                items2.add(items.get(i));
                bundle.putParcelableArrayList("list",items2);
                shopFragment1.setArguments(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder2 extends RecyclerView.ViewHolder{
        private ImageView img_shop;
        private TextView shop_name;
        private TextView shop_gu;
        private TextView shop_dong;
        private Button btn_shop;
        public ViewHolder2(View itemView) {
            super(itemView);
            img_shop = itemView.findViewById(R.id.img_shop);
            shop_name = itemView.findViewById(R.id.name);
            shop_gu = itemView.findViewById(R.id.shop_gu);
            shop_dong = itemView.findViewById(R.id.shop_dong);
            btn_shop = itemView.findViewById(R.id.btn_shop);
        }
    }
}
