package com.neaghfoz.component.authorize.service;

import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.service.IBaseService;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 下午8:16
 * To change this template use File | Settings | File Templates.
 */
public interface IUserService extends IBaseService {
    /**
     * 通过Hql查询
     *
     * @param sql 待处理sql串
     * @return 返回查询结果
     */
    public Object findWithSql(String sql);

    /**
     * 通过Hql查询
     *
     * @param hql 待处理hql串
     * @return 返回查询结果
     */
    public Object findWithHql(String hql);

    /**
     * 通过用户名来获取用户的信息
     *
     * @param userName 用户名
     * @return 返回user对象，如果不存在该用户则返回 null;
     */
    public User findUserByUserName(String userName);
}
