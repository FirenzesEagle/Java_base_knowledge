package me.liumingbo.designPattern.abstractFactoryPattern.dao.role;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.Role;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public interface IRoleDao {
    void addRole(Role role);

    void removeRole(Role role);

    Role getRole(String rolename);
}
