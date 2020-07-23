package com.yangping.Domain.view;

import com.yangping.Domain.base.UseCaseHandler;
import com.yangping.Domain.data.TaksLocalDataSource;
import com.yangping.Domain.data.TasksRepository;
import com.yangping.Domain.domain.TaskUseCase;
import com.yangping.Domain.utils.AppExecutors;

/**
 * @author yangping on 2020/7/23
 */
public class Injection {

    public static TasksRepository provideTasksRepository(){
        return TasksRepository.getInstance(TaksLocalDataSource.getInstance(new AppExecutors()));
    }
    public static UseCaseHandler provideUseCaseHandler(){
        return UseCaseHandler.getInstance();
    }

    public static TaskUseCase provideTaskUseCase(){
        return new TaskUseCase(provideTasksRepository());
    }
}
