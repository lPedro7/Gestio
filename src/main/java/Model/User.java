package Model;

public class User {
    int id;
    String username;
    String hashPasswd;

    User(int id, String username, String hashPasswd){
        this.id=id;
        this.username = username;
        this.hashPasswd = hashPasswd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPasswd() {
        return hashPasswd;
    }

    public void setHashPasswd(String hashPasswd) {
        this.hashPasswd = hashPasswd;
    }


}
