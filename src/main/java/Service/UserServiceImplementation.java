package Service;

import DAO.DAONota;
import DAO.NotaDAO;

public class UserServiceImplementation implements UserService{

    @Override
    public boolean checkLogin(String username, String password) {
        DAONota daoNota = new NotaDAO();
        return daoNota.checkLogin(username,password);
    }

    @Override
    public void getUsers() {
        DAONota daoNota = new NotaDAO();
        daoNota.getUsers();
    }

    @Override
    public boolean checkUserExists(String username) {
        DAONota daoNota = new NotaDAO();
        return daoNota.checkUserExists(username);
    }

    @Override
    public void createUser(String username, String password) {
        DAONota daoNota = new NotaDAO();
        daoNota.createUser(username,password);
    }

    @Override
    public int getUserId(String username) {
        DAONota daoNota = new NotaDAO();
        return daoNota.getUserId(username);
    }

    @Override
    public String getUsername(int id) {
        DAONota daoNota = new NotaDAO();
        return daoNota.getUsername(id);
    }
}
