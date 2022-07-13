package com.example.healthawareness.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.healthawareness.MainActivity;
import com.example.healthawareness.R;

public class LoginActivity extends AppCompatActivity {
    EditText et_user_name,til_password;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        intiaization();

        findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationCheck()){
                  Intent intent =new Intent(LoginActivity.this,DashBoard.class);
                  startActivity(intent);
                }
            }
        });

    }

    private boolean validationCheck() {
        if(et_user_name.getText().toString().trim().length()==0){
            et_user_name.requestFocus();
            et_user_name.setError("please enter username");
            return false;
        }
        if(til_password.getText().toString().trim().length()==0){
            til_password.requestFocus();
            til_password.setError("please enter password");
            return false;
        }
        return true;
    }

    private void intiaization() {
        et_user_name=findViewById(R.id.et_user_name);
        til_password=findViewById(R.id.et_password);
    }
}