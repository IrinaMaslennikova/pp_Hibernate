package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException { //create
        String s = "CREATE TABLE `User` (\n" +
                "  `Id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `lastname` VARCHAR(45) NULL,\n" +
                "  `age` TINYINT(1) NULL,\n" +
                "  PRIMARY KEY (`Id`));\n";
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(s)) {
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
    }

    public void dropUsersTable() throws SQLException {  //drop
        String s = "DROP TABLE User";
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(s)) {
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {  //insert
        User user = new User(name, lastName, age);
        String s = "INSERT INTO User (name, lastname, age) VALUE (?, ?, ?)";
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(s)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setByte(3, user.getAge());
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) throws SQLException {  //delete
        String s = "DELETE FROM User WHERE Id = ?";
        Connection connection = getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(s)) {
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() throws SQLException {  //select
        List<User> allUsers = new ArrayList<>();
        String s = "SELECT * FROM User";
        Connection connection = getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(s);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("Id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                allUsers.add(user);
                connection.commit();
            }
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }
        return allUsers;
    }

    public void cleanUsersTable() throws SQLException {
        String s = "DELETE FROM User";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(s)) {
            preparedStatement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            getConnection().rollback();
            e.printStackTrace();
        }

    }
}
