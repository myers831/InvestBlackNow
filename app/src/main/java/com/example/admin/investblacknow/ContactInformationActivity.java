package com.example.admin.investblacknow;

import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ContactInformationActivity extends BaseActivity {

    private Toolbar myToolbar;
    private boolean navSwitch = false;
    FrameLayout navFrame;
    NavDrawFragment navDrawFragment;
    String NAV_FRAG_TAG = "navigationFragmentTag";

    TextView tvName, tvEmail, tvPhone, tvFacebook, tvInstgram, tvLinkedIn, tvOccupation, tvId, tvBio;
    ImageView ivProfilePic;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_information);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvFacebook = findViewById(R.id.tvFacebook);
        tvInstgram = findViewById(R.id.tvInstagram);
        tvLinkedIn = findViewById(R.id.tvLinkedIn);
        tvOccupation = findViewById(R.id.tvOccupation);
        tvId = findViewById(R.id.tvId);
        tvBio = findViewById(R.id.tvBio);
        ivProfilePic = findViewById(R.id.ivProfilePic);

        contact = (Contact) getIntent().getSerializableExtra("contact");

        tvName.setText(contact.getName());
        tvEmail.setText("Email: " + contact.getEmail());
        tvPhone.setText("Phone: " + contact.getContactOptions().get(0));
        tvLinkedIn.setText("LinkedIn: " + contact.getContactOptions().get(1));
        tvFacebook.setText("Facebook: " + contact.getContactOptions().get(2));
        tvInstgram.setText("Instagram: " + contact.getContactOptions().get(3));
        tvOccupation.setText(contact.getOccupation());
        tvId.setText(contact.getID());

        Glide.with(this).load("http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png")
                .into(ivProfilePic);


        myToolbar = findViewById(R.id.my_toolbar);
        navFrame = findViewById(R.id.navFrame);

        navDrawFragment = new NavDrawFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.navFrame, navDrawFragment, NAV_FRAG_TAG).addToBackStack(NAV_FRAG_TAG).commit();

        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle("Invest Black Now");
        myToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(navSwitch == false){
                    Log.d(NAV_FRAG_TAG, "onClick: open frag");
                    navFrame.setLayoutParams(new FrameLayout.LayoutParams(2000, 3000));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(200); // Sleep 4 seconds
                            // Now change the color back. Needs to be done on the UI thread
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    navDrawFragment.dlLayout.openDrawer(GravityCompat.START);                                }
                            });
                        }
                    }).start();
                    navSwitch = true;
                }else if(navSwitch == true){
                    Log.d(NAV_FRAG_TAG, "onClick: close frag");
                    navDrawFragment.dlLayout.closeDrawer(GravityCompat.START);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(200); // Sleep 4 seconds
                            // Now change the color back. Needs to be done on the UI thread
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    navFrame.setLayoutParams(new FrameLayout.LayoutParams(0, 3000));
                                }
                            });
                        }
                    }).start();
                    navSwitch = false;
                }
            }
        });

        navFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navFrame.setLayoutParams(new FrameLayout.LayoutParams(0, 3000));
                navSwitch = false;
                Log.d(NAV_FRAG_TAG, "onClick: navFrame");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;

            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                // as a favorite...
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
