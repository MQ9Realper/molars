package com.molars.molars.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.molars.molars.R;
import com.molars.molars.models.Staff;
import com.molars.molars.views.TxtRegular;
import com.molars.molars.views.TxtSemiBold;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by dennis on 11/15/17.
 */

public class TeamMembersAdapter extends RecyclerView.Adapter<TeamMembersAdapter.ViewHolder> {
    private List<Staff> staffList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TxtSemiBold txtStaffName;
        private TxtRegular txtStaffTitle;
        private CircleImageView imageStaff;
        private CardView itemCardView;

        public ViewHolder(View v) {
            super(v);
            txtStaffName = (TxtSemiBold) v.findViewById(R.id.txtStaffName);
            txtStaffTitle = (TxtRegular) v.findViewById(R.id.txtStaffTitle);
            imageStaff = (CircleImageView) v.findViewById(R.id.profile_image);
            itemCardView = (CardView) v.findViewById(R.id.itemCardView);
        }
    }

    public TeamMembersAdapter(Context context, List<Staff> staffList) {
        this.context = context;
        this.staffList = staffList;
    }

    @Override
    public void onBindViewHolder(TeamMembersAdapter.ViewHolder holder, final int position) {
        holder.txtStaffName.setText(staffList.get(position).getStaff_name());
        holder.txtStaffTitle.setText(staffList.get(position).getStaff_title());
        Glide.with(context).load(staffList.get(position).getStaff_photo()).into(holder.imageStaff);

        holder.itemCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return staffList.size();
    }

    @Override
    public TeamMembersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_team_list_item, parent, false);
        return new TeamMembersAdapter.ViewHolder(view);
    }
}
