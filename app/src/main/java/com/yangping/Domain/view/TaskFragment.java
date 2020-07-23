package com.yangping.Domain.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.common.base.Preconditions;
import com.yangping.Domain.R;
import com.yangping.Domain.bean.TaskBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangping
 */
public class TaskFragment extends Fragment implements TaskContract.View, View.OnClickListener {

    private TaskContract.Presenter mPresenter;

    private Button btnSport,btnFood,btnAnimal;
    private RecyclerView mRecyclerView;
    private TasksAdapter mTasksAdapter;
    private List<TaskBean> mTaskBeans = new ArrayList<>();

    public static TaskFragment newInstance() {
        return new TaskFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.fragment_taks, container, false);
        btnAnimal = mContentView.findViewById(R.id.btn_animal);
        btnFood = mContentView.findViewById(R.id.btn_food);
        btnSport = mContentView.findViewById(R.id.btn_sport);
        btnAnimal.setOnClickListener(this);
        btnFood.setOnClickListener(this);
        btnSport.setOnClickListener(this);
        mRecyclerView = mContentView.findViewById(R.id.recyclerview);
        initAdapter();
        return mContentView;
    }

    private void initAdapter() {
        mTasksAdapter = new TasksAdapter(getActivity());
        mRecyclerView.setAdapter(mTasksAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void setPresenter(TaskContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showTasks(List<TaskBean> taskBeans) {
        this.mTaskBeans.clear();
        this.mTaskBeans = taskBeans;
        mTasksAdapter.setTaskBeans(mTaskBeans);
    }

    @Override
    public void showError() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_animal:
                mPresenter.getData(TaskType.ANIMAL);
                break;
            case R.id.btn_food:
                mPresenter.getData(TaskType.FOOD);
                break;
            case R.id.btn_sport:
                mPresenter.getData(TaskType.SPORT);
                break;
            default:
                break;
        }
    }
}