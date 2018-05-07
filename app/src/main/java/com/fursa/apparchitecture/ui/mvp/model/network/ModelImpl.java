package com.fursa.apparchitecture.ui.mvp.model.network;

import com.fursa.apparchitecture.ui.mvp.pojo.Repo;

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
