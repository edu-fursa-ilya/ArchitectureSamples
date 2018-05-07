package com.fursa.apparchitecture.model;

import com.fursa.apparchitecture.model.data.Repo;

import java.util.List;

import rx.Observable;

public interface Model {
    Observable<List<Repo>> getRepoList(String name);
}
