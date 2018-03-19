package kr.co.ezenac.jun0397.flower.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
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
            holder.tx_flower_name = view.findViewById(R.id.tx_flower_name);
            holder.tx_flower_price =view.findViewById(R.id.tx_flower_price);
            holder.flower_img = view.findViewById(R.id.flower_img);

            view.setTag(holder);
        } else{
            holder = (FlowerStoreListAdapter.Holder)view.getTag();
        }
        Store item = (Store) getItem(position);
        holder.flower_img.setBackgroundResource(R.drawable.ic_launcher_background);

        return view;
    }

    private class Holder{
        View flower_img;
        TextView tx_flower_name;
        TextView tx_flower_price;
    }

}
