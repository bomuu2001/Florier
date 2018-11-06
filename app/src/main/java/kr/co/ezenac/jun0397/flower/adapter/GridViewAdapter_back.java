package kr.co.ezenac.jun0397.flower.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.Flower;
import kr.co.ezenac.jun0397.flower.beans.Picture;
import kr.co.ezenac.jun0397.flower.R;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GridViewAdapter_back extends BaseAdapter {
    Flower flower;
    ArrayList<Flower> items = new ArrayList<>();
    ArrayList<Picture> items1 = new ArrayList<>();
    LayoutInflater inflater;
    //임시 이미지
    private int[] images = {R.drawable.flower1, R.drawable.flower2, R.drawable.flower3};

    public GridViewAdapter_back(LayoutInflater inflater,ArrayList<Flower> items) {
        this.items = items;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return images[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder;

        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.make_flower_grid_item,viewGroup,false);
            holder = new Holder();
            holder.flower_img = view.findViewById(R.id.flower_img);
            holder.flower_name = view.findViewById(R.id.flower_name);
            holder.flower_price = view.findViewById(R.id.flower_price);
            view.setTag(holder);
        }else{
            holder=(Holder)view.getTag();
        }
        final Flower item = (Flower) getItem(i);
        //임시 이미지
        holder.flower_img.setImageResource(images[i]);
        //서버에서 정보 가져올시
//        holder.flower_img.setBackgroundResource(Integer.parseInt(items1.get(i).getImg()));
//        holder.flower_name.setText(items2.get(i).getFlower_name());
//        holder.flower_name.setText(items2.get(i).getFlower_price());

        return view;
    }
    private class Holder {
        ImageView flower_img;
        TextView flower_name;
        TextView flower_price;
    }
}