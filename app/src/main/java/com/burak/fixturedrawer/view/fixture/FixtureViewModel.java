package com.burak.fixturedrawer.view.fixture;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import com.burak.fixturedrawer.R;
import com.burak.fixturedrawer.domain.model.Fixture;
import com.burak.fixturedrawer.domain.usecase.FixtureUseCase;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class FixtureViewModel extends ViewModel {

    private final FixtureUseCase fixtureUseCase;

    private CompositeDisposable disposable = new CompositeDisposable();
    public MutableLiveData<Fixture> fixtureLiveData = new MutableLiveData<>();
    public MutableLiveData<Integer> errorsLivedata = new MutableLiveData<>();

    @Inject
    public FixtureViewModel(FixtureUseCase fixtureUseCase) {
        this.fixtureUseCase = fixtureUseCase;
    }

    public void load() {
        fetchFixture();
    }

    private void fetchFixture() {
        disposable.add(
                fixtureUseCase.execute()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Fixture>() {
                            @Override
                            public void accept(Fixture fixture) throws Throwable {
                                fixtureLiveData.postValue(fixture);
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
