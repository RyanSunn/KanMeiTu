package com.example.kanmeitu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.kanmeitu.MainActivity;
import com.example.kanmeitu.R;
import com.example.kanmeitu.utils.Constants;
import com.example.kanmeitu.utils.RegularUtil;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usernameView;
    private EditText passwordView;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //找控件
        usernameView = findViewById(R.id.username);
        passwordView = findViewById(R.id.password);
        bt_login = findViewById(R.id.bt1);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //获取用户名
        String username = usernameView.getText().toString().trim();
        //判断是否输入账号
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, R.string.prompt_input_username,Toast.LENGTH_SHORT).show();
            return;
        }
        //判断账号格式
//        if(!RegularUtil.isPhone(username)){
//            Toast.makeText(this, R.string.error_phone_format,Toast.LENGTH_SHORT).show();
//            return;
//        }
        //获取密码
        String password = passwordView.getText().toString().trim();
        //判断是否输入密码
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, R.string.prompt_input_password,Toast.LENGTH_SHORT).show();
            return;
        }

        //判断密码格式
        if(password.length()<6||password.length()>15){
            Toast.makeText(this, R.string.error_password_format,Toast.LENGTH_SHORT).show();
            return;
        }

        //检验账号密码
        if (Constants.USERNAME.equals(username)&&Constants.PASSWORD.equals(password)){
            //登陆成功
            finish();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this, R.string.error_login,Toast.LENGTH_SHORT).show();
        }
    }
}