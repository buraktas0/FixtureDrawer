package com.burak.fixturedrawer.view.fixture;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.burak.fixturedrawer.R;

import java.util.List;

public class FixturePagerAdapter extends RecyclerView.Adapter<FixturePagerAdapter.FixtureViewHolder> {

    private List<MatchupAdapter> matchupAdapterList;

    public FixturePagerAdapter(List<MatchupAdapter> matchupAdapterList) {
        this.matchupAdapterList = matchupAdapterList;
    }

    @NonNull
    @Override
    public FixtureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fixture_weekly_view, parent, false);
        return new FixtureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FixtureViewHolder holder, int position) {
        ((TextView)holder.itemView.findViewById(R.id.textWeekNo)).setText("WEEK " + (position + 1));

        MatchupAdapter matchupAdapter = matchupAdapterList.get(position);
        RecyclerView recyclerView = holder.itemView.findViewById(R.id.recyclerViewMatchups);
        recyclerView.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        recyclerView.setAdapter(matchupAdapter);
    }

    @Override
    public int getItemCount() {
        return matchupAdapterList.size();
    }

    public class FixtureViewHolder extends RecyclerView.ViewHolder {

        public FixtureViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
