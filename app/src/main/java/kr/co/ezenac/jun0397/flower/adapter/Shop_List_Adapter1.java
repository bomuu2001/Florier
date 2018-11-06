package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.Shop;
import kr.co.ezenac.jun0397.flower.beans.Shop_Goods;
import kr.co.ezenac.jun0397.flower.R;

public class Shop_List_Adapter1 extends RecyclerView.Adapter<Shop_List_Adapter1.ViewHolder> {
    Context context;
    ArrayList<Shop> items;
    ArrayList<Shop_Goods> items2 = new ArrayList<>();

    public Shop_List_Adapter1(Context context, ArrayList<Shop> items) {
        this.context = context;
        this.items = items;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_list_item1,parent,false);
        //임시 테스트 값 지정
        Shop_Goods shop_goods1 = new Shop_Goods(0,"바람",10000);
        Shop_Goods shop_goods2 = new Shop_Goods(1,"사랑",20000);
        Shop_Goods shop_goods3 = new Shop_Goods(2,"만남",15000);
        items2.add(shop_goods1);
        items2.add(shop_goods2);
        items2.add(shop_goods3);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        Log.d("ljy","1 ="+items.size());

        holder.shop_name.setText(items.get(i).getShop_name());
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL); // horizontaㅣ, vertical 옵션에 따라 가로/세로 list
        holder.list_goods.setHasFixedSize(true);
        holder.list_goods.setLayoutManager(layoutManager);

        Log.d("ljy","2 ="+items2.size());
        Shop_Goods_Adapter adapter = new Shop_Goods_Adapter(context,items2);
        holder.list_goods.setAdapter(adapter);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView shop_name;
        private RecyclerView list_goods;
        public ViewHolder(View itemView) {
            super(itemView);
            shop_name = itemView.findViewById(R.id.shop_name);
            list_goods = itemView.findViewById(R.id.list_goods);
        }
    }
}
