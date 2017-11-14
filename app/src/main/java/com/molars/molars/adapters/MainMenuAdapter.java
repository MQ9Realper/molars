package com.molars.molars.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.molars.molars.R;
import com.molars.molars.models.Menu;
import com.molars.molars.views.TxtSemiBold;

import java.util.List;

/**
 * Created by dennis on 11/14/17.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {
    private List<Menu> listDashboardItems;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TxtSemiBold txtMenuTitle;
        private ImageView imageMenu;
        private CardView itemCardView;

        public ViewHolder(View v) {
            super(v);
            txtMenuTitle = (TxtSemiBold) v.findViewById(R.id.txtMenuTitle);
            imageMenu = (ImageView) v.findViewById(R.id.imageMenu);
            itemCardView = (CardView) v.findViewById(R.id.itemCardView);
        }
    }

    public MainMenuAdapter(Context context, List<Menu> listDashboardItems) {
        this.context = context;
        this.listDashboardItems = listDashboardItems;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtMenuTitle.setText(listDashboardItems.get(position).getMenu_title());
        Glide.with(context).load(listDashboardItems.get(position).getMenu_icon()).into(holder.imageMenu);

        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return listDashboardItems.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_menu_list_item, parent, false);
        return new ViewHolder(view);
    }

}
