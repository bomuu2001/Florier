package kr.co.ezenac.jun0397.flower.login_register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ezenac.jun0397.flower.beans.RegisterUser;
import kr.co.ezenac.jun0397.flower.MainActivity;
import kr.co.ezenac.jun0397.flower.R;

public class Login extends AppCompatActivity {
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.btn_log) Button btn_log;
    @BindView(R.id.btn_regist) Button btn_regist;

    RegisterUser registerUser=new RegisterUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //회원가입시 로그인페이지 아이디 자동 입력
        if(requestCode == 0 && resultCode == RESULT_OK) {
            String a = data.getStringExtra("email");
            Toast.makeText(Login.this, "회원가입을 완료했습니다!", Toast.LENGTH_SHORT).show();
            username.setText(a);
        }
    }
    //로그인 버튼
    @OnClick(R.id.btn_log)
    public void clickbtn_log(View view){
        //Log.d("ljy","beans2 : "+registerUser.getPhoneNumber()+" "+registerUser.getEmail()+" "+registerUser.getPassword()+" "+registerUser.getName()+" "+registerUser.getBirth()+" "+registerUser.getSex());
//        if(username.getText().toString().trim() != registerUser.getEmail()){
//            Toast.makeText(Login.this, "이메일이 일치하지 않습니다", Toast.LENGTH_SHORT).show();
//            return;
//        }else if(password.getText().toString().trim() != registerUser.getPassword().trim()){
//            Toast.makeText(Login.this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show();
//            return;
//        }else {
//
//        }
        Intent intent = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }
    //회원가입 버튼
    @OnClick(R.id.btn_regist)
    public void clickbtn_regist(View view){
        Intent intent = new Intent(Login.this,Regist.class);
        // SINGLE_TOP : 이미 만들어진게 있으면 그걸 쓰고, 없으면 만들어서 써라
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        startActivityForResult(intent,0);
    }
}
