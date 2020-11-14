package Service;

public interface UserService {
    boolean checkLogin(String username, String password);
    void getUsers();
}
