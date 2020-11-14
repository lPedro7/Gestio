package DAO;

import Java.Database;

import javax.xml.crypto.Data;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NotaDAO implements DAONota{


    @Override
    public void getUsers(){

        Connection connection = Database.getConnection();
        String url = "SELECT * FROM user";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println(rs.getString("username"));
                System.out.println(rs.getString("password"));

            }
         //   Database.closeConnection(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public boolean checkLogin(String username, String password) {

        try {
            Connection connection = Database.getConnection();
            String url = "SELECT * FROM user WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);

                ResultSet rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    return true;
                }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
