package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        //userService.createUsersTable();
        //userService.createUsersTable();
        //userService.saveUser("Ivan","Ivanov", (byte) 43);
        //userService.saveUser("Petr","Petrov", (byte) 20);
        //userService.saveUser("Vasily","Sidorov", (byte) 30);
        //userService.saveUser("Test","Test", (byte) 1);
        //List<User> allUsers = userService.getAllUsers();
        //for(User user : allUsers){
        //    System.out.println(user.toString());
        //}
        //userService.removeUserById(1);
        userService.cleanUsersTable();
        //userService.dropUsersTable();
        Util.getSessionFactory().close();
    }
}
