package com.fursa.apparchitecture.presenter;

import com.fursa.apparchitecture.model.Model;
import com.fursa.apparchitecture.model.data.Repo;
import com.fursa.apparchitecture.model.ModelImpl;
import com.fursa.apparchitecture.view.MyView;

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
