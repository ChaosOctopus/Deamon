package com.yangping.Domain.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.yangping.Domain.R;
import com.yangping.Domain.presenter.TaskPresenter;
import com.yangping.Domain.utils.ActivityUtils;

/**
 * @author yangping
 * 获取一个简单列表为例子
 */
public class MainActivity extends AppCompatActivity{

    private TaskPresenter mTaskPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TaskFragment taksFragment = (TaskFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (taksFragment == null){
            taksFragment = TaskFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),taksFragment,
                    R.id.contentFrame);
        }

        mTaskPresenter = new TaskPresenter(
                taksFragment,
                Injection.provideUseCaseHandler(),
                Injection.provideTaskUseCase());
    }

}