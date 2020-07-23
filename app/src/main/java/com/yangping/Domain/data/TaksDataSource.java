package com.yangping.Domain.data;

import com.yangping.Domain.bean.TaskBean;
import com.yangping.Domain.view.TaskType;

import java.util.List;

/**
 * @author yangping on 2020/7/23
 */
public interface TaksDataSource {

    void getTasks(TaskType taskType, GetTasksCallback getTasksCallback);

    interface GetTasksCallback{

        void onTasksLoaded(List<TaskBean> tasks);

        void onTasksDataError();
    }
}
