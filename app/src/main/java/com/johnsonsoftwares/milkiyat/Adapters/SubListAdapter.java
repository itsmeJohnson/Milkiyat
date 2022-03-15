package com.johnsonsoftwares.milkiyat.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonsoftwares.milkiyat.MainActivity;
import com.johnsonsoftwares.milkiyat.R;
import com.johnsonsoftwares.milkiyat.model.Items;
import com.johnsonsoftwares.milkiyat.model.Listings;
import com.johnsonsoftwares.milkiyat.model.SubItems;

import java.util.ArrayList;
import java.util.List;

public class SubListAdapter extends RecyclerView.Adapter<SubListAdapter.ViewHolder> {
    private List<Listings> listings;
    Context mContext;
    List<SubItems> subItemsArrayList;
    SublistItemAdapter sublistItemAdapter;
    private LinearLayoutManager lln;

    public SubListAdapter(List<Listings> listings, Context mContext) {
        this.listings = listings;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sublist,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
         Listings listing = listings.get(position);
        String title = listing.getTitle();
        subItemsArrayList = listing.getSubItemsArrayList();
        holder.title.setText(title);

        sublistItemAdapter = new SublistItemAdapter(subItemsArrayList,mContext);
        lln = new LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false);
        holder.sublistRecyclerview.setHasFixedSize(true);
        holder.sublistRecyclerview.setLayoutManager(lln);
        holder.sublistRecyclerview.setAdapter(sublistItemAdapter);

    }

    @Override
    public int getItemCount() {
        return listings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView sublistRecyclerview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txt_title);
            sublistRecyclerview = itemView.findViewById(R.id.recycler_sublist);

        }

    }
}
