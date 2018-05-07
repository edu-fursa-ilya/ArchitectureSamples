package com.fursa.apparchitecture.ui.mvp.ui;

import com.fursa.apparchitecture.ui.mvp.model.network.Model;
import com.fursa.apparchitecture.ui.mvp.pojo.Repo;
import com.fursa.apparchitecture.ui.mvp.model.network.ModelImpl;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

public class RepoListPresenter implements Presenter {

    Model mModel = new ModelImpl();
    private MyView mMyView;
    private Subscription mSubscription = Subscriptions.empty();

    public RepoListPresenter(MyView view) {
        this.mMyView = view;
    }

    @Override
    public void onSearchClick() {
        if(!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }

        mSubscription = mModel.getRepoList(mMyView.getUserName()).subscribe(new Observer<List<Repo>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mMyView.showError(e.getMessage());
            }

            @Override
            public void onNext(List<Repo> repos) {
                if(repos != null && !repos.isEmpty()) {
                    mMyView.showData(repos);
                } else {
                    mMyView.showEmptyList();
                }
            }
        });
    }

    @Override
    public void onStop() {
        if(!mSubscription.isUnsubscribed()) {
            mSubscription.unsubscribe();
        }
    }
}
