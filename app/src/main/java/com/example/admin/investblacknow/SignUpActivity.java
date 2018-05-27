package com.example.admin.investblacknow;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class SignUpActivity extends BaseActivity {
    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;
    private DatabaseReference database;
    private EditText nameSU;
    private EditText emailSU;
    private EditText passwordSU;
    private EditText occupationSU;
    private EditText phoneSU;
    private EditText linkedinSU;
    private EditText facebookSU;
    private EditText instagramSU;
    private String imageSU;
    private String idSU;
    private int commissionSU;
    private boolean paidSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
        nameSU = findViewById(R.id.NameEt);
        emailSU = findViewById(R.id.EmailEt);
        passwordSU = findViewById(R.id.PasswordEt);
        occupationSU = findViewById(R.id.OccupationEt);
        phoneSU = findViewById(R.id.PhoneEt);
        linkedinSU = findViewById(R.id.LinkedinEt);
        facebookSU = findViewById(R.id.FacebookEt);
        instagramSU = findViewById(R.id.InstagramEt);
        imageSU =  "http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png";
        commissionSU = 0;
        idSU = "AA2345";
        paidSU = true;

    }

    public void signUpExecute(View view) {
        mAuth.createUserWithEmailAndPassword(emailSU.getText().toString(), passwordSU.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful() && (emailSU.getText().toString() != "" || passwordSU.getText().toString() != "")) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    Toast.makeText(SignUpActivity.this, "SignUp Successful",
                                            Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    addUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUpActivity.this, "Authentication failed. Make sure to add Name, Email, and Password",
                                            Toast.LENGTH_LONG).show();
                                }

                                // ...
                            }
                        });
    }

    private void addUser() {
        List<String> contactList = new ArrayList<>();
        contactList.add(phoneSU.getText().toString());
        contactList.add(linkedinSU.getText().toString());
        contactList.add(facebookSU.getText().toString());
        contactList.add(instagramSU.getText().toString());

        Contact contact = new Contact(nameSU.getText().toString(),
                occupationSU.getText().toString(),
                imageSU,
                emailSU.getText().toString(),
                passwordSU.getText().toString(),
                commissionSU,
                idSU,
                paidSU,
                contactList);

        database.child("Users").child(idSU).setValue(contact);
    }

    private void updateUI(FirebaseUser user) {
        Intent intent = new Intent(this, HomeActivity.class);
        Log.d(TAG, user.getEmail());
        startActivity(intent);
    }

    public void addPicture(View view) {
    }
}
