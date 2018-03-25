package com.example.admin.investblacknow;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 2/18/2018.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>  {

    List<Contact> contacts = new ArrayList<>();
    Context context;

    public HomeRecyclerViewAdapter(Context context, List<Contact> contacts){
        this.contacts = contacts;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.contact = contact;
        holder.tvContactName.setText(contact.getName());
        holder.tvContactOccupation.setText(contact.getOccupation());
        Glide.with(context).load(contact.getImage()).into(holder.ivContactPic);

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvContactName;
        private final TextView tvContactOccupation;
        private final ImageView ivContactPic;
        Contact contact;

        public ViewHolder(View itemView) {
            super(itemView);
            tvContactName = itemView.findViewById(R.id.tvContactName);
            tvContactOccupation = itemView.findViewById(R.id.tvContactOccupation);
            ivContactPic = itemView.findViewById(R.id.ivContactPic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ContactInformationActivity.class);
                    intent.putExtra("contact", contact);
                    context.startActivity(intent);
                }
            });
        }
    }
}
