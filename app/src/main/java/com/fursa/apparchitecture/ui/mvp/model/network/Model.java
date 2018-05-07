package com.fursa.apparchitecture.ui.mvp.model.network;

import com.fursa.apparchitecture.ui.mvp.pojo.Repo;

import java.util.List;

import rx.Observable;

public interface Model {
    Observable<List<Repo>> getRepoList(String name);
}
