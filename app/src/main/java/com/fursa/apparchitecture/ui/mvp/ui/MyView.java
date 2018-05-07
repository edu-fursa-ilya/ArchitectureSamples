package com.fursa.apparchitecture.ui.mvp.ui;

import com.fursa.apparchitecture.ui.mvp.pojo.Repo;

import java.util.List;

public interface MyView {

    void showData(List<Repo> repos);

    void showError(String error);

    void showEmptyList();

    String getUserName();
}
