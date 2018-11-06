package kr.co.ezenac.jun0397.flower.login_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.beans.RegisterUser;
import kr.co.ezenac.jun0397.flower.R;

public class Regist extends AppCompatActivity {

    @BindView(R.id.etEmail) EditText etEmail;
    @BindView(R.id.etPassword) EditText etPassword;
    @BindView(R.id.etName) EditText etName;
    @BindView(R.id.etBirth) EditText etBirth;
    @BindView(R.id.btnDone) Button btnDone;
    @BindView(R.id.btnCancel) Button btnCancel;
    @BindView(R.id.radioGroup) RadioGroup radioGroup;
    @BindView(R.id.radio0) RadioButton radio0;
    @BindView(R.id.radio1) RadioButton radio1;

    RegisterUser registerUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.btnDone)
    public void clickbtnDone(View view){
        // 이메일 입력 확인
        if( etEmail.getText().toString().length() == 0 ) {
            Toast.makeText(Regist.this, "Email을 입력하세요!", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }
        if(etEmail.toString() =="@"){

        }
        // 비밀번호 입력 확인
        if( etPassword.getText().toString().length() == 0 ) {
            Toast.makeText(Regist.this, "비밀번호를 입력하세요!", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return;
        }
        if(etPassword.length()<8){
            Toast.makeText(Regist.this, "바말번호가 최소 8자 보다 짧습니다", Toast.LENGTH_SHORT).show();
            return;
        }
        if(etPassword.length()>20){
            Toast.makeText(Regist.this, "비밀번호가 최대 20자 보다 깁니다", Toast.LENGTH_SHORT).show();
            return;
        }
        //이름 확인
        if( etName.getText().toString().length() == 0 ) {
            Toast.makeText(Regist.this, "이름을 입력하세요!", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }
        //생년월일 확인
        if( etBirth.getText().toString().length() == 0 ) {
            Toast.makeText(Regist.this, "생년월일을 입력하세요!", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }
        //성별 확인
        if( radio0.isChecked() == false && radio1.isChecked() ==false) {
            Toast.makeText(Regist.this, "성별을 입력하세요!", Toast.LENGTH_SHORT).show();
            etEmail.requestFocus();
            return;
        }
        //회원정보 빈즈 파일에 저장
        int phonenumber = 0;
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        int birth = Integer.parseInt(etBirth.getText().toString().trim());
        int sex=2;


        //성별 구분 남자 0 여자 1
        if(radio0.isChecked() == true){
            sex = 0;
        }else if(radio1.isChecked() == true){
            sex = 1;
        }
        Intent intent=getIntent();
        intent.putExtra("email",email);
        setResult(RESULT_OK,intent);
        registerUser = new RegisterUser(0,phonenumber,email,password,name,birth,sex);

        finish();
    }
    @OnClick(R.id.btnCancel)
    public void clickbtnCancel(View view){
        finish();
    }
}
