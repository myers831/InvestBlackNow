package com.example.admin.investblacknow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements LoginActivityContract.View {

    LoginActivityPresenter presenter;

    private EditText email, password;
    private String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        presenter = new LoginActivityPresenter();
        presenter.addView(this);

        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    public void btnExecute(View view) {

        presenter.loginUser(view, email.getText().toString(), password.getText().toString(), this);

    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void showFailedLogin() {
        Toast.makeText(LoginActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void launchSigninActivity() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    @Override
    public void startHomeActivity(Contact contact) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }
}
