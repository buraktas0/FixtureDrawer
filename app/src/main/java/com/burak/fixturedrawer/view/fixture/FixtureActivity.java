package com.burak.fixturedrawer.view.fixture;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Fixture;
import com.burak.fixturedrawer.domain.model.Matchup;

import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FixtureActivity extends AppCompatActivity {

    FixtureViewModel viewModel;
    List<MatchupAdapter> matchupAdapterList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixture);

        initView();
    }

    private void initView() {
        viewModel = new ViewModelProvider(this).get(FixtureViewModel.class);
        viewModel.fixtureLiveData.observe(this, new Observer<Fixture>() {
            @Override
            public void onChanged(Fixture fixture) {
                matchupAdapterList = new ArrayList<>();
                for (int i = 0; i < fixture.weekCount; i++) {
                    MatchupAdapter matchupAdapter = new MatchupAdapter();
                    matchupAdapter.setMatchupList(fixture.getWeeklyFixture(i + 1));
                    matchupAdapterList.add(matchupAdapter);
                }

                ViewPager2 viewPager = findViewById(R.id.pager);
                viewPager.setAdapter(new FixturePagerAdapter(matchupAdapterList));
            }
        });
        viewModel.errorsLivedata.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer errorResId) {
                Toast.makeText(FixtureActivity.this, getString(errorResId), Toast.LENGTH_SHORT).show();
            }
        });

        viewModel.load();
    }
}
