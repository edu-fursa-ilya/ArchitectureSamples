package com.fursa.apparchitecture.view;

import com.fursa.apparchitecture.model.data.Repo;

import java.util.List;

public interface MyView {

    void showData(List<Repo> repos);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
