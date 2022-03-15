package com.johnsonsoftwares.milkiyat.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonsoftwares.milkiyat.R;
import com.johnsonsoftwares.milkiyat.model.Items;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LatestListAdapter extends RecyclerView.Adapter<LatestListAdapter.ViewHolder> {

   private List<Items> itemsList;
    Context mContext;

    public LatestListAdapter(List<Items> itemsList, Context mContext) {
        this.itemsList = itemsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_latest,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Items items = itemsList.get(position);
        String imageUrl = items.getImage();
        Picasso.with(mContext).load(imageUrl).into(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.items);
        }
    }
}
