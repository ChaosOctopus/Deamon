package com.yangping.Domain.data;

import androidx.annotation.NonNull;

import com.yangping.Domain.utils.AppExecutors;


import com.yangping.Domain.bean.TaskBean;
import com.yangping.Domain.view.TaskType;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangping on 2020/7/23
 * 模拟本地缓存
 */
public class TaksLocalDataSource implements TaksDataSource {
    private static volatile TaksLocalDataSource INSTANCE;
    private AppExecutors mAppExecutors;

    private List<TaskBean> foods = new ArrayList<>();
    private List<TaskBean> animal = new ArrayList<>();
    private List<TaskBean> sport = new ArrayList<>();


    private TaksLocalDataSource(@NonNull AppExecutors appExecutors) {
        mAppExecutors = appExecutors;
    }

    public static TaksLocalDataSource getInstance(@NonNull AppExecutors appExecutors) {
        if (INSTANCE == null) {
            synchronized (TaksLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new TaksLocalDataSource(appExecutors);
                }
            }
        }
        return INSTANCE;
    }
    private void initData() {
        clearData();
        for (int i = 0; i < 30; i++) {
            foods.add(new TaskBean("food"+i));
            animal.add(new TaskBean("animal"+i));
            sport.add(new TaskBean("sport"+i));
        }
    }

    private void clearData() {
        foods.clear();
        animal.clear();
        sport.clear();
    }

    @Override
    public void getTasks(final TaskType taskType, final GetTasksCallback getTasksCallback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                initData();
                switch (taskType){
                    case FOOD:
                        getTasksCallback.onTasksLoaded(foods);
                        break;
                    case ANIMAL:
                        getTasksCallback.onTasksLoaded(animal);
                        break;
                    case SPORT:
                        getTasksCallback.onTasksLoaded(sport);
                        break;
                    default:
                        getTasksCallback.onTasksDataError();
                        break;
                }

            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }
}
