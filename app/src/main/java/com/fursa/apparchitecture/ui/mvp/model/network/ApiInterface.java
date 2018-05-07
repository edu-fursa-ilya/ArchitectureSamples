package com.fursa.apparchitecture.ui.mvp.model.network;

import com.fursa.apparchitecture.ui.mvp.pojo.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface ApiInterface {
    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepositories(@Path("user") String user);
}
