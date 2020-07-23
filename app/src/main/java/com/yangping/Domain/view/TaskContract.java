package com.yangping.Domain.view;

import com.yangping.Domain.base.BasePresenter;
import com.yangping.Domain.base.BaseView;
import com.yangping.Domain.bean.TaskBean;

import java.util.List;

/**
 * @author yangping on 2020/7/23
 */
public interface TaskContract {

    interface View extends BaseView<Presenter> {
        void showTasks(List<TaskBean> taskBeans);
        void showError();
    }

    interface Presenter extends BasePresenter {
        void getData(TaskType taskType);
    }
}
