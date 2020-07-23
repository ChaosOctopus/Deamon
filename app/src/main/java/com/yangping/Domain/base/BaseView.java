package com.yangping.Domain.base;

import com.yangping.Domain.base.BasePresenter;

/**
 * @author yangping on 2020/7/23
 */
public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
}
