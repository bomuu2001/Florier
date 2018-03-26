package kr.co.ezenac.jun0397.flower;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import kr.co.ezenac.jun0397.flower.map.Fragment1;


/**
 * Created by Administrator on 2018-03-26.
 */

public class OderPage extends Fragment {

    ArrayList<String> price = new ArrayList<>();
    ArrayList<String> text = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> location = new ArrayList<>();

    @BindView(R.id.oder_page_text)
    TextView oder_page_text;

    @BindView(R.id.oder_page_price)
    Spinner oder_page_price;
    @BindView(R.id.oder_page_city) Spinner oder_page_city;
    @BindView(R.id.oder_page_location) Spinner oder_page_location;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootview = (ViewGroup) inflater.inflate(R.layout.activity_oder_page, container, false);
        Activity parentActivity = getActivity();

        ButterKnife.bind(this,rootview);

        price.add("1000");
        price.add("2000");
        price.add("3000");

        city.add("서울시");

        location.add("강남구");
        location.add("강서구");
        location.add("강북구");
        location.add("강동구");


        ArrayAdapter spinnerPrice;
        spinnerPrice = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, price);
        oder_page_price.setAdapter(spinnerPrice);

        ArrayAdapter spinnerCity;
        spinnerCity = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, city);
        oder_page_city.setAdapter(spinnerCity);

        ArrayAdapter spinnerLocation;
        spinnerLocation = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item, location);
        oder_page_location.setAdapter(spinnerLocation);

        Fragment1 fragment1 = new Fragment1();
        fragment1.setArguments(new Bundle());
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.fragmentHere, fragment1);
        fragmentTransaction.commit();

        return rootview;
    }

    @OnItemSelected(R.id.oder_page_price)
    public void onItemSelected(View v, int i){
        Toast.makeText(getActivity(),"선택된 아이템 : "+ oder_page_price.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.oder_page_text)
    public void onClickText(View v){
        CustomDialog customDialog = new CustomDialog(getActivity());
        customDialog.setCallbacks(new CustomDialog.Callbacks() {
            @Override
            public void onClickSelect(ArrayList<String> text) {
                String[] str = new String[text.size()];
                for(int i=0; i<=text.size(); i++){
                    str[i] = text.get(i).toString();
                    Log.d("kac",str[i] +",");
                    /*oder_page_text.setText(str[i] +",");*/
                }
                /*for(int j=0; j<str[text.size()].length(); j++) {
                    oder_page_text.setText(str[j] +",");
                }*/
            }
        });
        customDialog.show();
    }
}

