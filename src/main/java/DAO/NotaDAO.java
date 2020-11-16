package DAO;

import Java.Database;
import Model.Nota;
import com.google.common.hash.Hashing;

import javax.xml.crypto.Data;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class NotaDAO implements DAONota {

    @Override
    public void createNota(String title, String text, int OwnerId, String creationDate) {

        try {

            Connection connection = Database.getConnection();
            String url = "INSERT INTO nota(titulo,body,owner,creationDate) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, text);
            preparedStatement.setInt(3, OwnerId);
            preparedStatement.setString(4, creationDate);

            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public LinkedList<Nota> getNotas(int idOwner){
        try{
            Connection connection = Database.getConnection();
            String url = "SELECT * FROM nota WHERE owner = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(url);
            preparedStatement.setInt(1,idOwner);
            ResultSet rs = preparedStatement.executeQuery();

            LinkedList<Nota> notas = new LinkedList<Nota>();
            while (rs.next()){
                notas.push(new Nota(rs.getInt("id"),rs.getString("titulo"),rs.getString("text"),rs.getInt("owner"),rs.getString("creationDate")));
            }

            return notas;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
