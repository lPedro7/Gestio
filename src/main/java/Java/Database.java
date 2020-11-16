package Java;

import java.sql.*;


public class Database {


    private static Connection connection;

    public static Connection getConnection() {
        try {
            String url = "jdbc:sqlite:C:/Users/Pedro/IdeaProjects/Gestio/notas.db";

            if (connection == null) {
                Class.forName("org.sqlite.JDBC");

                connection = DriverManager.getConnection(url);
            }

            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
