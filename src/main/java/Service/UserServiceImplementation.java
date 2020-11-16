package Service;

import DAO.DAOUser;
import DAO.UserDAO;

public class UserServiceImplementation implements UserService{

    @Override
    public boolean checkLogin(String username, String password) {
        DAOUser daoUser = new UserDAO();
        return daoUser.checkLogin(username,password);
    }

    @Override
    public void getUsers() {
        DAOUser daoUser = new UserDAO();
        daoUser.getUsers();
    }

    @Override
    public boolean checkUserExists(String username) {
        DAOUser daoUser = new UserDAO();
        return daoUser.checkUserExists(username);
    }

    @Override
    public void createUser(String username, String password) {
        DAOUser daoUser = new UserDAO();
        daoUser.createUser(username,password);
    }

    @Override
    public int getUserId(String username) {
        DAOUser daoUser = new UserDAO();
        return daoUser.getUserId(username);
    }

    @Override
    public String getUsername(int id) {
        DAOUser daoUser = new UserDAO();
        return daoUser.getUsername(id);
    }
}
