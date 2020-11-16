package Service;

import DAO.DAONota;
import DAO.DAOUser;
import DAO.NotaDAO;
import DAO.UserDAO;
import Model.Nota;

import java.util.LinkedList;

public class NotaServiceImplementation implements NotaService {

    @Override
    public void createNota(String titulo, String text, int ownerId, String creationDate) {
        DAONota daoNota = new NotaDAO();
        daoNota.createNota(titulo, text, ownerId,creationDate);
    }

    @Override
    public LinkedList<Nota> getNotas(int idOwner) {
        DAONota daoNota = new NotaDAO();
        return daoNota.getNotas(idOwner);
    }
}
