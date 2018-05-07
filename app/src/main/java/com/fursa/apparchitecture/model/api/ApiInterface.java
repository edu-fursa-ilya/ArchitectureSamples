package com.fursa.apparchitecture.model.api;

import com.fursa.apparchitecture.model.data.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface ApiInterface {
    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepositories(@Path("user") String user);
}
