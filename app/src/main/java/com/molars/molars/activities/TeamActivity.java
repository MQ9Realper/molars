package com.molars.molars.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.molars.molars.R;
import com.molars.molars.adapters.MainMenuAdapter;
import com.molars.molars.adapters.TeamMembersAdapter;
import com.molars.molars.models.Staff;
import com.molars.molars.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class TeamActivity extends AppCompatActivity {
    private Utils utils;
    private Toolbar toolbar;
    private List<Staff> staffList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        utils = new Utils(this, this);
        toolbar = (Toolbar) findViewById(R.id.toolbarTeam);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        utils.initToolbar(toolbar, "Our Team", DashboardActivity.class);

        initTeamMembers();

        initTeamMemberList();
    }

    private void initTeamMembers() {
        staffList = new ArrayList<>();
        staffList.add(new Staff("Dr. Justin Muendo", "Chief Dental Surgeon", R.drawable.justin_muendo));
        staffList.add(new Staff("Dr. Justin Muendo", "Chief Dental Surgeon", R.drawable.justin_muendo));
        staffList.add(new Staff("Dr. Justin Muendo", "Chief Dental Surgeon", R.drawable.justin_muendo));
        staffList.add(new Staff("Dr. Justin Muendo", "Chief Dental Surgeon", R.drawable.justin_muendo));
        staffList.add(new Staff("Dr. Justin Muendo", "Chief Dental Surgeon", R.drawable.justin_muendo));
        staffList.add(new Staff("Dr. Justin Muendo", "Chief Dental Surgeon", R.drawable.justin_muendo));
    }

    private void initTeamMemberList() {
        RecyclerView listTeamMembers = (RecyclerView) findViewById(R.id.listTeam);
        TeamMembersAdapter teamMemberAdapter = new TeamMembersAdapter(this, staffList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        listTeamMembers.setLayoutManager(layoutManager);
        listTeamMembers.setItemAnimator(new DefaultItemAnimator());
        listTeamMembers.setAdapter(teamMemberAdapter);
    }
}
