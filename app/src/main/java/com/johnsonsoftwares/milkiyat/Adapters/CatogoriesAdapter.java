package com.johnsonsoftwares.milkiyat.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonsoftwares.milkiyat.R;
import com.johnsonsoftwares.milkiyat.model.Categories;
import com.johnsonsoftwares.milkiyat.model.Items;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CatogoriesAdapter extends RecyclerView.Adapter<CatogoriesAdapter.ViewHolder> {
    private List<Categories> categoriesList;
    Context mContext;

    public CatogoriesAdapter(List<Categories> categoriesList, Context mContext) {
        this.categoriesList = categoriesList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Categories categories = categoriesList.get(position);
        String imageUrl = categories.getIcon();
        Picasso.with(mContext).load(imageUrl).into(holder.cardView);
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.categories_img);
        }
    }
}
