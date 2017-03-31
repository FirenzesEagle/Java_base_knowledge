package me.liumingbo.designPattern.abstractFactoryPattern.dao.role;

import me.liumingbo.designPattern.abstractFactoryPattern.bean.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bjliumingbo on 2017/3/31.
 */
public class PostgreSQLRoleDao implements IRoleDao {
    private static Logger logger = LoggerFactory.getLogger(PostgreSQLRoleDao.class);

    @Override
    public void addRole(Role role) {
        logger.info("PostgreSQL added Role {}", role);
    }

    @Override
    public void removeRole(Role role) {
        logger.info("PostgreSQL removed Role {}", role);
    }

    @Override
    public Role getRole(String rolename) {
        Role role = new Role();
        role.setRolename(rolename);
        return role;
    }
}
