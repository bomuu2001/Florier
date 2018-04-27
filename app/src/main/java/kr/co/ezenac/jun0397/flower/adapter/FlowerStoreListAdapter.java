package kr.co.ezenac.jun0397.flower.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.Bean.Store;
import kr.co.ezenac.jun0397.flower.R;

/**
 * Created by Administrator on 2018-03-19.
 */

public class FlowerStoreListAdapter extends BaseAdapter {
    ArrayList<Store> stores = new ArrayList<>();


    public FlowerStoreListAdapter(ArrayList<Store> stores) {
        this.stores = stores;
    }

    @Override
    public int getCount() {
        return stores.size();
    }

    @Override
    public Object getItem(int position) {
        return stores.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        FlowerStoreListAdapter.Holder holder = new FlowerStoreListAdapter.Holder();

        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).
                    inflate(R.layout.flower_store_list_item,viewGroup,false);
            holder.tx_flower_store_name = view.findViewById(R.id.tx_flower_store_name);
            holder.tx_flower_store_address =view.findViewById(R.id.tx_flower_store_address);
            holder.tx_flower_store_phone=view.findViewById(R.id.tx_flower_store_phone);
            holder.flower_store_img = view.findViewById(R.id.flower_store_img);
            holder.btn_flower_store_plus=view.findViewById(R.id.btn_flower_store_plus);

            view.setTag(holder);
        } else{
            holder = (FlowerStoreListAdapter.Holder)view.getTag();
        }
        Store item = (Store) getItem(position);
        holder.tx_flower_store_name.setText(item.getName());
        holder.tx_flower_store_phone.setText(item.getCall());
        holder.tx_flower_store_address.setText(item.getAddress());

        Store itme = (Store) getItem(position);

        return view;
    }

    private class Holder{
        View flower_store_img;
        TextView tx_flower_store_name;
        TextView tx_flower_store_phone;
        TextView tx_flower_store_address;
        Button btn_flower_store_plus;
    }

}