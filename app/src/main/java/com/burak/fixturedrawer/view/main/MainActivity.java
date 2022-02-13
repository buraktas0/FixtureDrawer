package com.burak.fixturedrawer.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Team;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;
    TeamAdapter teamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        viewModel.teamsLiveData.observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(List<Team> teamList) {

            }
        });
        viewModel.errorsLivedata.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewTeams);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamAdapter = new TeamAdapter();
        recyclerView.setAdapter(teamAdapter);

        viewModel.load();
    }
}