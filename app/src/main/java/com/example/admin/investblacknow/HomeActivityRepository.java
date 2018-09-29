package com.example.admin.investblacknow;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Admin on 8/18/2018.
 */

public class HomeActivityRepository {

    HomeActivityContract.Presenter presenter;

    private FirebaseDatabase database;
    private DatabaseReference userRef;
    String TAG = "HomeActivityRepository";

    List<Contact> contactList = new ArrayList<>();

    private HomeActivityRepository(){

    }

    public static HomeActivityRepository getInstance() {
        return new HomeActivityRepository();
    }

    public void addPresenter(HomeActivityContract.Presenter presenter) {
        this.presenter = presenter;
    }

    public void getContacts(){
        database = FirebaseDatabase.getInstance();
        userRef = database.getReference("Users");

        userRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                contactList.clear();
                boolean hasContacts = dataSnapshot.hasChildren();
                Log.d(TAG, "onDataChange: " + hasContacts);
                if(hasContacts){
                    Log.d(TAG, "onDataChange: Contacts count: " + dataSnapshot.getChildrenCount());

                    for(DataSnapshot snapShot: dataSnapshot.getChildren()){
                        List<String> contacts = new ArrayList<>();
                        contacts.add(snapShot.child("contactOptions").child("0").getValue().toString());
                        contacts.add(snapShot.child("contactOptions").child("1").getValue().toString());
                        contacts.add(snapShot.child("contactOptions").child("2").getValue().toString());
                        contacts.add(snapShot.child("contactOptions").child("3").getValue().toString());

                        contactList.add(new Contact(snapShot.child("name").getValue().toString(),
                                snapShot.child("occupation").getValue().toString(),
                                snapShot.child("image").getValue().toString(),
                                snapShot.child("email").getValue().toString(),
                                snapShot.child("password").getValue().toString(),
                                Integer.parseInt(snapShot.child("commission").getValue().toString()),
                                snapShot.child("id").getValue().toString(),
                                Boolean.parseBoolean(snapShot.child("paid").getValue().toString()),
                                contacts,
                                snapShot.child("reference").getValue().toString()));
                    }
                }
                presenter.setAdapter(contactList);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: " + databaseError.getMessage());
            }
        });
    }
}
