package com.yangping.Domain.presenter;

import com.yangping.Domain.view.TaskContract;
import com.yangping.Domain.view.TaskType;
import com.yangping.Domain.base.UseCase;
import com.yangping.Domain.base.UseCaseHandler;
import com.yangping.Domain.bean.TaskBean;
import com.yangping.Domain.domain.TaskUseCase;

import java.util.List;

/**
 * @author yangping on 2020/7/23
 */
public class TaskPresenter implements TaskContract.Presenter {
    public static final String TAG = TaskPresenter.class.getSimpleName();
    private final TaskContract.View mView;

    private final UseCaseHandler mUseCaseHandler;
    private final TaskUseCase mTaskUseCase;

    public TaskPresenter(TaskContract.View view, UseCaseHandler useCaseHandler,TaskUseCase mTaskUseCas) {
        this.mView = view;
        this.mUseCaseHandler = useCaseHandler;
        this.mTaskUseCase = mTaskUseCas;
        mView.setPresenter(this);
    }

    @Override
    public void start() {
        getData(TaskType.ANIMAL);
    }

    @Override
    public void getData(TaskType taskType) {
        TaskUseCase.RequestValues requestValues = new TaskUseCase.RequestValues(taskType);
        mUseCaseHandler.execute(mTaskUseCase, requestValues, new UseCase.UseCaseCallback<TaskUseCase.ResponseValue>() {
            @Override
            public void onSuccess(TaskUseCase.ResponseValue response) {
                List<TaskBean> taskBeans = response.getTaskBeans();
                mView.showTasks(taskBeans);
            }

            @Override
            public void onError() {
                mView.showError();
            }
        });
    }
}
