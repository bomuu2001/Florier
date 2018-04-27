package kr.co.ezenac.jun0397.flower;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

/**
 * Created by Administrator on 2018-03-26.
 */

public class CustomDialog extends Dialog {
    ArrayList<String> text = new ArrayList<>();

    @BindView(R.id.custom1) TextView custom1;
    @BindView(R.id.custom2) TextView custom2;
    @BindView(R.id.custom3) TextView custom3;
    @BindView(R.id.custom4) TextView custom4;

    public interface Callbacks{
        void onClickSelect(ArrayList<String> text);
    }

    Callbacks callbacks = null;

    public void setCallbacks(Callbacks callbacks) {
        this.callbacks = callbacks;
    }

    public CustomDialog(@NonNull Context context) {
        super(context);

        setContentView(R.layout.custom_dialog);
        ButterKnife.bind(this);

        custom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.add("custom1");
            }
        });

        custom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.add("custom2");
            }
        });

        custom3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.add("custom3");
            }
        });

        custom4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.add("custom4");
            }
        });
        Log.d("kac",text +",");
    }

    @OnItemSelected({R.id.custom1,R.id.custom2,R.id.custom3,R.id.custom4})
    public void onSelected(View view){
        for(int i=0; i<text.size(); i++){
            text.add(i, String.valueOf(i));
        }
    }

    @OnClick(R.id.custom_dialog_confirm)
    public void onClick(View v){
        onClickItem(text);
        dismiss();
    }

    public void onClickItem(ArrayList<String> text)
    {
        if(callbacks != null){
            callbacks.onClickSelect(text);
        }
    }
}
