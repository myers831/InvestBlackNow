package com.example.admin.investblacknow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContactInformationActivity extends AppCompatActivity {

    TextView tvName, tvEmail, tvFacebook, tvInstgram, tvOccupation, tvId;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvFacebook = findViewById(R.id.tvFacebook);
        tvInstgram = findViewById(R.id.tvInstagram);
        tvOccupation = findViewById(R.id.tvOccupation);
        tvId = findViewById(R.id.tvId);

        contact = (Contact) getIntent().getSerializableExtra("contact");

        tvName.setText(contact.getName());
        tvEmail.setText(contact.getContactOptions().get(2));
        tvFacebook.setText(contact.getContactOptions().get(0));
        tvInstgram.setText(contact.getContactOptions().get(1));
    }
}
