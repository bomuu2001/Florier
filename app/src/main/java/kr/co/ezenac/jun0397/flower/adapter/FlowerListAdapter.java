package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.Bean.Flower;
import kr.co.ezenac.jun0397.flower.R;

/**
 * Created by Administrator on 2018-03-14.
 */

public class FlowerListAdapter extends BaseAdapter {
    ArrayList<Flower> flowers = new ArrayList<>();

    public FlowerListAdapter(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public int getCount() {
        return flowers.size();
    }

    @Override
    public Object getItem(int position) {
        return flowers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        FlowerListAdapter.Holder holder = new FlowerListAdapter.Holder();
        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.flower_list_item,viewGroup,false);
            holder.tx_flower_name = view.findViewById(R.id.tx_flower_name);
            holder.tx_flower_price =view.findViewById(R.id.tx_flower_price);
            holder.flower_img = view.findViewById(R.id.flower_img);

            view.setTag(holder);
        } else{
            holder = (FlowerListAdapter.Holder)view.getTag();
        }
        Flower item = (Flower) getItem(position);
        String price = String.valueOf(item.getFlower_price());
        holder.tx_flower_name.setText(item.getFlower_name());
        holder.tx_flower_price.setText(price);
        holder.flower_img.setBackgroundResource(R.drawable.ic_launcher_background);

        return view;
    }

    private class Holder{
        View flower_img;
        TextView tx_flower_name;
        TextView tx_flower_price;


    }

}
