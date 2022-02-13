package com.burak.fixturedrawer.view.fixture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Matchup;

import java.util.ArrayList;
import java.util.List;

public class MatchupAdapter extends RecyclerView.Adapter<MatchupAdapter.MatchupViewHolder> {

    private List<Matchup> matchupList = new ArrayList<>();

    @NonNull
    @Override
    public MatchupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.matchup_adapter_list_item, parent, false);
        return new MatchupViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchupViewHolder holder, int position) {
        holder.bind(matchupList.get(position));
    }

    @Override
    public int getItemCount() {
        return matchupList.size();
    }

    public class MatchupViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewHomeTeam;
        private TextView textViewAwayTeam;

        public MatchupViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewHomeTeam = itemView.findViewById(R.id.textViewHomeTeamName);
            textViewAwayTeam = itemView.findViewById(R.id.textViewAwayTeamName);
        }

        public void bind(Matchup matchup) {
            textViewHomeTeam.setText(matchup.homeTeam.name);
            textViewAwayTeam.setText(matchup.awayTeam.name);
        }
    }

    public void setMatchupList(List<Matchup> matchupList) {
        this.matchupList = matchupList;
        notifyDataSetChanged();
    }
}
