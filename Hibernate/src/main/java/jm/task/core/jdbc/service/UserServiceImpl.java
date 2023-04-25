package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {
    //private UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    private UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
    public void createUsersTable() throws Exception {
        //userDaoJDBC.createUsersTable();
        userDaoHibernate.createUsersTable();
    }

    public void dropUsersTable() throws Exception {
        //userDaoJDBC.dropUsersTable();
        userDaoHibernate.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) throws Exception {
        //userDaoJDBC.saveUser(name, lastName, age);
        userDaoHibernate.saveUser(name, lastName, age);
        System.out.println("User с именем – " + name + " добавлен в базу данных");
    }

    public void removeUserById(long id) throws Exception {
        //userDaoJDBC.removeUserById(id);
        userDaoHibernate.removeUserById(id);
    }

    public List<User> getAllUsers() throws Exception {
        //List<User> allUsers = userDaoJDBC.getAllUsers();
        List<User> allUsers = userDaoHibernate.getAllUsers();
        return allUsers;
    }

    public void cleanUsersTable() throws Exception {
        //userDaoJDBC.cleanUsersTable();
        userDaoHibernate.cleanUsersTable();
    }
}
