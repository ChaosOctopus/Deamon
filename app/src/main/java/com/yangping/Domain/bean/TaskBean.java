package com.yangping.Domain.bean;

/**
 * @author yangping on 2020/7/23
 */
public class TaskBean {
    public String taskName;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public TaskBean(String taskName) {
        this.taskName = taskName;
    }
}
