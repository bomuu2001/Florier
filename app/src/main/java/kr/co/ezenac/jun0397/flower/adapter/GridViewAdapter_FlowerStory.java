package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.FlowerStory;
import kr.co.ezenac.jun0397.flower.R;

public class GridViewAdapter_FlowerStory extends BaseAdapter {
    Context context;
    ArrayList<FlowerStory> items;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    public GridViewAdapter_FlowerStory(Context context, ArrayList<FlowerStory> items) {
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
        Holder holder;

        if(view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flower_story_grid_item,viewGroup,false);
            holder = new Holder();
            holder.story_img = view.findViewById(R.id.flower_img);
            holder.story_title = view.findViewById(R.id.flower_name);
            view.setTag(holder);
        }else{
            holder=(Holder)view.getTag();
        }
        //데이터 변경
      //  holder.story_title.setText(items.get(i).getTitle());
      //  holder.story_img.setImageResource(images[i]);

        return view;
    }
    private class Holder {
        ImageView story_img;
        TextView story_title;

    }
}
