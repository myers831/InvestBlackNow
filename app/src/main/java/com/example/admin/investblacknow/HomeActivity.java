package com.example.admin.investblacknow;

import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    List<Contact> contactList = new ArrayList<>();

    String NAV_FRAG_TAG = "navigationFragmentTag";
    String TAG = "HomeActivity";

    RecyclerView rvContactList;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    HomeRecyclerViewAdapter homeRecyclerViewAdapter;

    NavDrawFragment navDrawFragment;

    FrameLayout navFrame;

    private Toolbar myToolbar;
    private boolean navSwitch = false;
    //private DrawerLayout dlLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        myToolbar = findViewById(R.id.my_toolbar);
        navFrame = findViewById(R.id.navFrame);
        //dlLayout = findViewById(R.id.dlDrawer);

        navDrawFragment = new NavDrawFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.navFrame, navDrawFragment, NAV_FRAG_TAG).addToBackStack(NAV_FRAG_TAG).commit();

        setSupportActionBar(myToolbar);

        getSupportActionBar().setTitle("Invest Black Now");
        myToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(navSwitch == false){
                    Log.d(TAG, "onClick: open frag");
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
                    Log.d(TAG, "onClick: close frag");
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
                Log.d(TAG, "onClick: navFrame");
            }
        });

        initContacts();

        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(this, contactList);


        rvContactList = findViewById(R.id.rvContactsList);
        rvContactList.setLayoutManager(layoutManager);
        rvContactList.setItemAnimator(itemAnimator);
        rvContactList.setAdapter(homeRecyclerViewAdapter);
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

    private void initContacts() {

        List<String> contacts = new ArrayList<>();
        contacts.add("Facebook: Mmy Ers");
        contacts.add("Instagram: Mac831");
        contacts.add("Email: Myers831@yahoo.com");

        contactList.add(new Contact("Mac", "Software Developer", "http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Chris", "Writer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Jake", "Investor","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mike", "Banker","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Tiffany", "Lawyer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mac", "Software Developer", "http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Chris", "Writer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Jake", "Investor","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mike", "Banker","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Tiffany", "Lawyer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mac", "Software Developer", "http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Chris", "Writer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Jake", "Investor","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mike", "Banker","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Tiffany", "Lawyer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mac", "Software Developer", "http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Chris", "Writer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Jake", "Investor","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Mike", "Banker","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));
        contactList.add(new Contact("Tiffany", "Lawyer","http://www.personalbrandingblog.com/wp-content/uploads/2017/08/blank-profile-picture-973460_640-300x300.png", contacts));

    }
}
