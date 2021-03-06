package com.fursa.apparchitecture.model;

import com.fursa.apparchitecture.model.api.ApiInterface;
import com.fursa.apparchitecture.model.api.ApiModule;
import com.fursa.apparchitecture.model.data.Repo;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ModelImpl implements Model {

    ApiInterface mApiInterface = ApiModule.getApiInterface();

    @Override
    public Observable<List<Repo>> getRepoList(String name) {
        return mApiInterface.getRepositories(name)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
