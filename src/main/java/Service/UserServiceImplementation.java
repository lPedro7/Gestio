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

    }
}
