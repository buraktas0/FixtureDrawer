package com.burak.fixturedrawer.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Team;
import com.burak.fixturedrawer.view.fixture.FixtureActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
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
                teamAdapter.setTeams(teamList);
            }
        });
        viewModel.errorsLivedata.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer errorResId) {
                Toast.makeText(MainActivity.this, getString(errorResId), Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewTeams);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        teamAdapter = new TeamAdapter();
        recyclerView.setAdapter(teamAdapter);

        FloatingActionButton fabDraw = findViewById(R.id.fabDraw);
        fabDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, FixtureActivity.class));
            }
        });

        viewModel.load();
    }
}