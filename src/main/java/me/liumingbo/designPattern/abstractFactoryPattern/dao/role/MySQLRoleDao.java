package me.liumingbo.designPattern.abstractFactoryPattern.dao.role;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class MySQLRoleDao implements IRoleDao {
    private static Logger logger = LoggerFactory.getLogger(MySQLRoleDao.class);

    @Override
    public void addRole(Role role) {
        logger.info("MySQL added Role {}", role);
    }

    @Override
    public void removeRole(Role role) {
        logger.info("MySQL removed Role {}", role);
    }

    @Override
    public Role getRole(String rolename) {
        Role role = new Role();
        role.setRolename(rolename);
        return role;
    }
}
