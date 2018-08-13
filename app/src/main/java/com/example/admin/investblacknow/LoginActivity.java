package com.example.admin.investblacknow;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, password;
    private String TAG = "LoginActivity";

    private Contact contact;

    FirebaseDatabase database;
    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        database = FirebaseDatabase.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
        // Write a message to the database
    }

    public void btnExecute(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    myRef = database.getReference("Users/"+user.getUid());
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }
                        });
                break;
            case R.id.btnSignup:
                Intent intent = new Intent(this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void updateUI(FirebaseUser user) {

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                List<String> contactList = new ArrayList<>();

                contactList.add(dataSnapshot.child("contactOptions").child("0").getValue().toString());
                contactList.add(dataSnapshot.child("contactOptions").child("1").getValue().toString());
                contactList.add(dataSnapshot.child("contactOptions").child("2").getValue().toString());
                contactList.add(dataSnapshot.child("contactOptions").child("3").getValue().toString());

                contact = new Contact(dataSnapshot.child("name").getValue().toString(),
                        dataSnapshot.child("occupation").getValue().toString(),
                        dataSnapshot.child("image").getValue().toString(),
                        dataSnapshot.child("email").getValue().toString(),
                        dataSnapshot.child("password").getValue().toString(),
                        Integer.parseInt(dataSnapshot.child("commission").getValue().toString()),
                        dataSnapshot.child("id").getValue().toString(),
                        Boolean.parseBoolean(dataSnapshot.child("paid").getValue().toString()),
                        contactList, dataSnapshot.child("reference").getValue().toString());

                Log.d(TAG, "Value is: " + contact.getEmail());
                startMain();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }

    public void startMain(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }
}
