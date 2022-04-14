package pModel;


public class ListUser {
    
    private String idUser;
    private String Username;
    private String Password;
    private String User_Role;

    public ListUser(String idUser, String Username, String Password, String User_Role) {
        this.idUser = idUser;
        this.Username = Username;
        this.Password = Password;
        this.User_Role = User_Role;
    }

    public ListUser() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUser_Role() {
        return User_Role;
    }

    public void setUser_Role(String User_Role) {
        this.User_Role = User_Role;
    }
}
