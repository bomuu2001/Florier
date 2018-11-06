package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.Flower;
import kr.co.ezenac.jun0397.flower.beans.Picture;
import kr.co.ezenac.jun0397.flower.CustomDialog;
import kr.co.ezenac.jun0397.flower.R;

public class MakeFlowerAdapter_main extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;
    //임시 이미지 저장
    private int[] images = {R.drawable.flower1, R.drawable.flower2, R.drawable.flower3};

    ArrayList<Picture> items1 = new ArrayList<>();
    ArrayList<Flower> items = new ArrayList<>();

    CustomDialog customDialog;

    public MakeFlowerAdapter_main(Context context, ArrayList<Flower> items) {
        this.context = context;
        this.items = items;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // object를 LinearLayout 형태로 형변환했을 때 view와 같은지 여부를 반환
        return view == ((View)object);
    }
    //각각의 item을 인스턴스 화
    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        //초기화
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.include_make_flower_fragment1, container, false);
        ImageView imageView = (ImageView)v.findViewById(R.id.img_flower);
        TextView tx_flower_name = v.findViewById(R.id.tx_flower_name);
        TextView tx_flower_price = v.findViewById(R.id.tx_flower_price);
        Log.d("ljy","i = "+i);

        //데이터 변경
//        imageView.setImageResource(Integer.parseInt(items1.get(i).getImg()));
//        tx_flower_name.setText(items.get(i).getFlower_name());
//        tx_flower_price.setText(String.valueOf(items.get(i).getFlower_price()));
        imageView.setImageResource(images[i]);

        //다이얼 로그 생성
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog = new CustomDialog(context,items);
//                customDialog.setData(i); //클릭아이템 으로 데이터 변경
                customDialog.show();
                Toast.makeText(context,"클릭되었습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(v);
        return v;
    }

    //할당을 해제
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
//        super.destroyItem(container, position, object);
    }
}
