package kr.co.ezenac.jun0397.flower.login_register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.R;

public class PhoneNumberCheck extends AppCompatActivity {

    @BindView(R.id.buttonSend) Button buttonSend;
    @BindView(R.id.editTextPhoneNo)EditText editTextPhoneNo;
    @BindView(R.id.editTextSMS)EditText editTextSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_check);
        ButterKnife.bind(this);
        
    }
    @OnClick(R.id.buttonSend)
    public void clickbuttonSend(View view){
        //입력한 값을 가져와 변수에 담는다
        String phoneNo = editTextPhoneNo.getText().toString().trim();
        String sms = editTextSMS.getText().toString().trim();

        try {
            //전송
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, sms, null, null);
            Toast.makeText(getApplicationContext(), "전송 완료!", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS faild, please try again later!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
