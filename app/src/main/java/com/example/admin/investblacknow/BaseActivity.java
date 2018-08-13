package com.example.admin.investblacknow;

import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;

public class BaseActivity extends AppCompatActivity {
// *** Part of Nav Menu Code to add to every Activity that uses it ***
//    private Toolbar myToolbar;
//    private boolean navSwitch = false;
//    FrameLayout navFrame;
//    NavDrawFragment navDrawFragment;
//    String NAV_FRAG_TAG = "navigationFragmentTag";
//    ****************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

// *** Part of Nav Menu Code to add to every Activity that uses it ***
//        myToolbar = findViewById(R.id.my_toolbar);
//        navFrame = findViewById(R.id.navFrame);
//
//        navDrawFragment = new NavDrawFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.navFrame, navDrawFragment, NAV_FRAG_TAG).addToBackStack(NAV_FRAG_TAG).commit();
//
//        setSupportActionBar(myToolbar);
//
//        getSupportActionBar().setTitle("Invest Black Now");
//        myToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
//        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(navSwitch == false){
//                    Log.d(NAV_FRAG_TAG, "onClick: open frag");
//                    navFrame.setLayoutParams(new FrameLayout.LayoutParams(2000, 3000));
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            SystemClock.sleep(200); // Sleep 4 seconds
//                            // Now change the color back. Needs to be done on the UI thread
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    navDrawFragment.dlLayout.openDrawer(GravityCompat.START);                                }
//                            });
//                        }
//                    }).start();
//                    navSwitch = true;
//                }else if(navSwitch == true){
//                    Log.d(NAV_FRAG_TAG, "onClick: close frag");
//                    navDrawFragment.dlLayout.closeDrawer(GravityCompat.START);
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            SystemClock.sleep(200); // Sleep 4 seconds
//                            // Now change the color back. Needs to be done on the UI thread
//                            runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    navFrame.setLayoutParams(new FrameLayout.LayoutParams(0, 3000));
//                                }
//                            });
//                        }
//                    }).start();
//                    navSwitch = false;
//                }
//            }
//        });
//
//        navFrame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                navFrame.setLayoutParams(new FrameLayout.LayoutParams(0, 3000));
//                navSwitch = false;
//                Log.d(NAV_FRAG_TAG, "onClick: navFrame");
//            }
//        });
//    ************************************************************************************
    }

//     *** Part of Nav Menu Code to add to every Activity that uses it ***
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // app icon in action bar clicked; goto parent activity.
//                this.finish();
//                return true;
//
//            case R.id.action_settings:
//                // User chose the "Settings" item, show the app settings UI...
//                return true;
//
//            case R.id.action_favorite:
//                // User chose the "Favorite" action, mark the current item
//                // as a favorite...
//                return true;
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//    ************************************************************************************

}
