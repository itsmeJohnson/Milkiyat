package com.johnsonsoftwares.milkiyat.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonsoftwares.milkiyat.R;
import com.johnsonsoftwares.milkiyat.model.Items;
import com.johnsonsoftwares.milkiyat.model.SubItems;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SublistItemAdapter extends RecyclerView.Adapter<SublistItemAdapter.ViewHolder> {

   private List<SubItems> itemsList;
    Context mContext;

    public SublistItemAdapter(List<SubItems> itemsList, Context mContext) {
        this.itemsList = itemsList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_top_picks,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        SubItems items = itemsList.get(position);
        String imageUrl = items.getThumbnail();
        String subTitle = items.getTitle();
        int price = items.getPrice();
        String  pr = convertPrice(price);
        String locality = items.getLocality();
        holder.price.setText(pr);
        holder.sub_title.setText(subTitle);
        holder.locality.setText(locality);
        Picasso.with(mContext).load(imageUrl).into(holder.cardView);
    }

    private String convertPrice(int price) {
        String values = "";
        float val = Math.abs(price);
        if(val>=10000000){
            val = (val / 10000000);
            values = (val) + " Crore";
        } else if (val >= 100000) {
            val = (val / 100000);
            values = val + " Lakh";
        }
        return values;
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cardView, favourite_icon;
        TextView locality, sub_title, price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.items);
            favourite_icon = itemView.findViewById(R.id.favourite_icon);
            locality = itemView.findViewById(R.id.locality);
            sub_title = itemView.findViewById(R.id.sub_title);
            price = itemView.findViewById(R.id.price);
        }
    }
}
