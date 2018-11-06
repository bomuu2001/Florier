package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.ShoppingBagList;
import kr.co.ezenac.jun0397.flower.R;
import kr.co.ezenac.jun0397.flower.makeFlower.MakeFlower;

public class ShoppingBagAdapter extends BaseAdapter {
    Context context;
    ArrayList<ShoppingBagList> items = new ArrayList<>();
    MakeFlower makeFlower;

    int quantity2;
    int flower_price2;
    int flower_price_sum;
    int all_price_sum = 0;

    public ShoppingBagAdapter(Context context, ArrayList<ShoppingBagList> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.shopping_list_item,viewGroup,false);
            holder.tx_order_name = view.findViewById(R.id.tx_order_name);
            holder.minus =view.findViewById(R.id.minus);
            holder.plus = view.findViewById(R.id.plus);
            holder.count = view.findViewById(R.id.count);
            holder.btn_x = view.findViewById(R.id.btn_x);
            holder.tx_order_price = view.findViewById(R.id.tx_order_price);

            view.setTag(holder);
        } else{
            holder = (ShoppingBagAdapter.Holder)view.getTag();
        }
        final ShoppingBagList item = (ShoppingBagList) getItem(i);

        //리스트 데이터 변경
        holder.tx_order_name.setText(items.get(i).getGoods_name());
        final String flower_price = String.valueOf(items.get(i).getGoods_price());
        holder.tx_order_price.setText(flower_price);
        final String quantity = String.valueOf(items.get(i).getGoods_quantity());
        holder.count.setText(quantity);

        //꽃 금액 개수에 따른 변경
        quantity2 = Integer.parseInt(quantity);
        flower_price2 = Integer.parseInt(flower_price);
        flower_price_sum = flower_price2 * quantity2;
        holder.tx_order_price.setText(String.valueOf(flower_price_sum));

        //총금액 변경
        int size = items.size();
        int [] sum = new int[size];
        for(int j = 0; j < size; j++){
            sum[j] = items.get(j).getGoods_price()*quantity2;
            all_price_sum += sum[j];
        }
//        makeFlower.setSum_price(all_price_sum);

        //리스트 삭제
        holder.btn_x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(item) ;

                // listview 갱신.
                notifyDataSetChanged();
                Toast.makeText(context,"삭제 되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        //개수 내림
        final Holder finalHolder = holder;
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity2 != 1) {
                    //개수감소
                    quantity2--;
                    finalHolder.count.setText(String.valueOf(quantity2));
                    //가격감소
                    flower_price_sum -= flower_price2;
                    finalHolder.tx_order_price.setText(String.valueOf(flower_price_sum));
                    //총금액 변경
//                    for(int i = 0; i < items.size(); i++){
//                         sum[i] = items.get(i).getGoods_price();
//                         all_price_sum += sum[i];
//                    }
                }
            }
        });
        //개수 올림
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //개수증가
                quantity2++;
                finalHolder.count.setText(String.valueOf(quantity2));
                //가격증가
                flower_price_sum += flower_price2;
                finalHolder.tx_order_price.setText(String.valueOf(flower_price_sum));
                //총금액 변경
//                for(int i = 0; i < items.size(); i++){
//                    sum[i] = items.get(i).getGoods_price();
//                    all_price_sum += sum[i];
//                }
            }
        });
        return view;
    }
    private class Holder {
        TextView tx_order_name;
        TextView minus;
        TextView count;
        TextView plus;
        Button btn_x;
        TextView tx_order_price;
    }
    public void qwe(){
        Log.d("ljy","sum = "+all_price_sum);
        makeFlower.setSum_price(all_price_sum);
    }
}
