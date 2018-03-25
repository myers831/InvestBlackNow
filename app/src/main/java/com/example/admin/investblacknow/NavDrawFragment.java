package com.example.admin.investblacknow;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavDrawFragment extends Fragment implements AdapterView.OnItemClickListener{

    private ListView lvList;
    public DrawerLayout dlLayout;

    String[] menuItems = {"Home", "Store", "Social Media", "Photos", "About Us", "Contact Us", "Settings"};;

    public NavDrawFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_draw, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lvList = view.findViewById(R.id.lvList);
        dlLayout = view.findViewById(R.id.dlDrawer);
        lvList.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, menuItems));
        lvList.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
