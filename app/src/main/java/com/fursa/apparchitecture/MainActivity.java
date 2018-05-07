package com.fursa.apparchitecture;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fursa.apparchitecture.ui.mvp.pojo.Repo;
import com.fursa.apparchitecture.ui.mvp.ui.MyView;
import com.fursa.apparchitecture.ui.mvp.ui.RepoListPresenter;
import com.fursa.apparchitecture.ui.mvp.ui.adapters.RecyclerViewAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyView {
    private RecyclerViewAdapter recyclerViewAdapter;
    private RepoListPresenter presenter;
    private LinearLayoutManager layoutManager;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.editText)
    EditText etRepoName;

    @BindView(R.id.button)
    Button btnSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        presenter = new RepoListPresenter(this);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSearchClick();
            }
        });

    }

    @Override
    public void showData(List<Repo> repos) {
        recyclerViewAdapter.setRepoList(repos);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(presenter != null) {
            presenter.onStop();
        }
    }

    private void makeToast(String text) {
        Snackbar.make(toolbar, text, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        makeToast(error);
    }

    @Override
    public void showEmptyList() {
        makeToast(getString(R.string.empty_repo_list));
    }

    @Override
    public String getUserName() {
        return etRepoName.getText().toString();
    }
}
