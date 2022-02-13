package com.burak.fixturedrawer.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamAdapter extends RecyclerView.Adapter<TeamAdapter.TeamViewHolder> {

    private List<Team> teams = new ArrayList<>();

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_adapter_list_item,parent,false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        holder.bind(teams.get(position));
    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public class TeamViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewTeamName;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTeamName = itemView.findViewById(R.id.textViewTeamName);
        }

        public void bind(Team team) {
            textViewTeamName.setText(team.name);
        }
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
        notifyDataSetChanged();
    }
}
