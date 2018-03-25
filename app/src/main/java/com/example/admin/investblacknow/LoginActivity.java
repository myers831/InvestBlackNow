package com.example.admin.investblacknow;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnExecute(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.btnSignup:
                break;
        }
    }
}
