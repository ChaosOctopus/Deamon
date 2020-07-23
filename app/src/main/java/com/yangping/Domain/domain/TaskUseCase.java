package com.yangping.Domain.domain;

import com.yangping.Domain.bean.TaskBean;

import com.yangping.Domain.data.TaksDataSource;
import com.yangping.Domain.view.TaskType;
import com.yangping.Domain.data.TasksRepository;
import com.yangping.Domain.base.UseCase;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author yangping on 2020/7/23
 */
public class TaskUseCase extends UseCase<TaskUseCase.RequestValues,TaskUseCase.ResponseValue> {

    private final TasksRepository mTasksRepository;

    public TaskUseCase(TasksRepository tasksRepository) {
        mTasksRepository = checkNotNull(tasksRepository, "tasksRepository cannot be null!");;
    }

    @Override
    protected void executeUseCase(RequestValues requestValues) {
        mTasksRepository.getTasks(requestValues.getType(), new TaksDataSource.GetTasksCallback() {
            @Override
            public void onTasksLoaded(List<TaskBean> tasks) {
                ResponseValue responseValue = new ResponseValue(tasks);
                getUseCaseCallback().onSuccess(responseValue);
            }

            @Override
            public void onTasksDataError() {
                getUseCaseCallback().onError();
            }
        });
    }

    public static final class RequestValues implements UseCase.RequestValues{
        private final TaskType mType;

        public RequestValues(TaskType type) {
            mType = type;
        }

        public TaskType getType() {
            return mType;
        }
    }

    public static final class ResponseValue implements UseCase.ResponseValue{

        private final List<TaskBean> mTaskBeans;

        public ResponseValue(List<TaskBean> taskBeans) {
            mTaskBeans = checkNotNull(taskBeans, "tasks cannot be null!");
        }

        public List<TaskBean> getTaskBeans(){
            return mTaskBeans;
        }
    }
}
