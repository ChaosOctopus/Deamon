package com.yangping.Domain.data;


import com.yangping.Domain.view.TaskType;

/**
 * @author yangping on 2020/7/23
 */
public class TasksRepository implements TaksDataSource {
    private TaksDataSource taskLocalDateSource;
    private static TasksRepository INSTANCE = null;

    public static TasksRepository getInstance(TaksDataSource tasksLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new TasksRepository(tasksLocalDataSource);
        }
        return INSTANCE;
    }

    public TasksRepository(TaksDataSource taskLocalDateSource) {
        this.taskLocalDateSource = taskLocalDateSource;
    }

    @Override
    public void getTasks(TaskType taskType, GetTasksCallback getTasksCallback) {
        taskLocalDateSource.getTasks(taskType,getTasksCallback);
    }
}
