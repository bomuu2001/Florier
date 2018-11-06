package kr.co.ezenac.jun0397.flower.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import kr.co.ezenac.jun0397.flower.beans.Picture;
import kr.co.ezenac.jun0397.flower.R;

//상단 광고 어답터
public class PictureAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;
    //임시 이미지 저장
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c};

    ArrayList<Picture> items = new ArrayList<>();

    // 해당 context가 자신의 context 객체와 똑같이 되도록 생성자를 만듬
    public PictureAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        // object를 LinearLayout 형태로 형변환했을 때 view와 같은지 여부를 반환
//        return view == ((LinearLayout)object); 으로 했을때 오류 나서 View 로 바꿈..
        return view == ((View)object);
    }
    //각각의 item을 인스턴스 화
    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        //초기화
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.include_fragment1, container, false);
        ImageView imageView = (ImageView)v.findViewById(R.id.top);

        //임시 이미지
        imageView.setImageResource(images[i]);
        //서버에서 정보 가져올시
        //imageView.setImageResource(Integer.parseInt(items.get(i).getImg()));
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
