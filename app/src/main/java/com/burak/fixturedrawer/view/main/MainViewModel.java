package com.burak.fixturedrawer.view.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Team;
import com.burak.fixturedrawer.domain.usecase.TeamsUseCase;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.internal.disposables.CancellableDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class MainViewModel extends ViewModel {

    private final TeamsUseCase teamsUseCase;

    private CompositeDisposable disposable = new CompositeDisposable();
    public MutableLiveData<List<Team>> teamsLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> errorsLivedata = new MutableLiveData<>();

    @Inject
    public MainViewModel(TeamsUseCase teamsUseCase) {
        this.teamsUseCase = teamsUseCase;
    }

    public void load() {
        fetchTeams();
    }

    private void fetchTeams() {
        disposable.add(
            teamsUseCase.execute()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<List<Team>>() {
                        @Override
                        public void accept(List<Team> teamList) throws Throwable {
                            teamsLiveData.setValue(teamList);
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Throwable {
                            errorsLivedata.setValue(R.string.common_error_message);
                        }
                })
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
