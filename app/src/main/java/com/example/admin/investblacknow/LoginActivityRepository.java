package com.example.admin.investblacknow;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

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

/**
 * Created by Admin on 8/25/2018.
 */

public class LoginActivityRepository {

    LoginActivityContract.Presenter presenter;

    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private FirebaseAuth mAuth;

    String TAG = "LoginActivityRepository";

    private LoginActivityRepository(){

    }

    public static LoginActivityRepository getInstance(){
        return new LoginActivityRepository();
    }

    public void loginUser(View view, String email, String password, Activity activity){
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        switch (view.getId()){
            case R.id.btnLogin:
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    userRef = database.getReference("Users/"+user.getUid());
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());

                                    presenter.showFailedLogin();

                                    updateUI(null);
                                }

                                // ...
                            }
                        });
                break;
            case R.id.btnSignup:

                presenter.launchSigninActivity();
                break;
        }
    }

    public void updateUI(FirebaseUser user){
        // Read from the database
        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Contact contact;
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

                presenter.startHomeActivity(contact);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void addPresenter(LoginActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
