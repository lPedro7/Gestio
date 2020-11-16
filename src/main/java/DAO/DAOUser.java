package DAO;

public interface DAOUser {
    boolean checkLogin(String username, String password);
    void getUsers();
    boolean checkUserExists(String username);
    void createUser(String username, String password);
    int getUserId(String username);
    String getUsername(int id);
}
