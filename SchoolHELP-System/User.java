import java.util.Random;

abstract public class User implements Comparable<User> {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;

    public User(){
        this.username = "SchoolAdmin";
        this.password = "admin123";
        this.fullname = "Admin";
        this.email = "schooladmin@gmail.com";
        this.phone = "123";
    }

    public User(username, password, fullname, email, phone){
        setUsername(username);
        setPassword(password);
        setfullName(fullname);
        setEmail(email);
        setPassword(password);
    }

    public void setUsername(username){
        this.username = username;
    }

    public void setPassword(password){
        this.password = password;
    }

    public void setfullName(fullname){
        this.fullname = fullname;
    }

    public void setEmail(email){
        this.email = email;
    }

    public void setPassword(password){
        this.password = password;
    }
}