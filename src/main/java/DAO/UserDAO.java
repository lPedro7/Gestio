package DAO;

import Java.Database;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements DAOUser {


    @Override
    public void getUsers() {

        Connection connection = Database.getConnection();
        String url = "SELECT * FROM user";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.executeQuery();
            preparedStatement.close();
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
            preparedStatement.setString(1, username);
            password = Hashing.sha256()
                    .hashString(password, StandardCharsets.UTF_8)
                    .toString();
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                preparedStatement.close();
                rs.close();
                return true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkUserExists(String username) {

        try {
            Connection connection = Database.getConnection();
            String url = "SELECT * FROM user WHERE ? =username";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                preparedStatement.close();
                rs.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public int getUserId(String username) {
        try {
            Connection connection = Database.getConnection();

            String url = "SELECT * FROM user WHERE ? = username";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                preparedStatement.close();
                rs.close();
                return id;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void createUser(String username, String password) {
        try {
            if (password.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$")) {
                Connection connection = Database.getConnection();
                String url = "INSERT INTO user(username,password) VALUES(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(url);
                preparedStatement.setString(1, username);
                password = Hashing.sha256()
                        .hashString(password, StandardCharsets.UTF_8)
                        .toString();

                preparedStatement.setString(2, password);
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }else System.out.println("La contraseña debe tener al entre 8 y 16 caracteres, al menos un dígito, al menos una minúscula y al menos una mayúscula.\n" +
                    "Puede tener otros símbolos.");
        } catch (Exception e) {
            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }

    }

    @Override
    public String getUsername(int id) {

        try {
            Connection connection = Database.getConnection();
            String url = "SELECT username FROM user WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String user = rs.getString(0);
                rs.close();
                preparedStatement.close();
                return user;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Error";
    }

    public void createNota(String title, String text, int OwnerId) {

        try {

            Connection connection = Database.getConnection();
            String url = "INSERT INTO nota(titulo,body,owner) VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, text);
            preparedStatement.setInt(3, OwnerId);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
