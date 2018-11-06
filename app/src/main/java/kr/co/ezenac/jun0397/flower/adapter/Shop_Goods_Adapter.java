package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.Shop_Goods;
import kr.co.ezenac.jun0397.flower.R;

public class Shop_Goods_Adapter extends RecyclerView.Adapter<Shop_Goods_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Shop_Goods> items;

    public Shop_Goods_Adapter(Context context, ArrayList<Shop_Goods> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_goods_item1,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {
        //해당 데이터로 변경
        holder.goods_name.setText(items.get(i).getGoods_name());
        holder.goods_price.setText(String.valueOf(items.get(i).getGoods_price()));
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView goods_img;
        TextView goods_name;
        private TextView goods_price;

        public ViewHolder(View itemView) {
            super(itemView);
            goods_img = itemView.findViewById(R.id.goods_img);
            goods_name = itemView.findViewById(R.id.goods_name);
            goods_price = itemView.findViewById(R.id.goods_price);
        }
    }
}
