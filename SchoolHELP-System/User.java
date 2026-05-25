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

    public User(String username, String password, String fullname, String email, String phone){
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setfullName(String fullname){
        this.fullname = fullname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getUsername(){
        return username;
    }

    public String Password(){
        return password;
    }

    public String getfullName(){
        return fullname;
    }

    public String getEmail(){
        return email;
    }

    public String getPhone(){
        return phone;
    }

    public boolean isSchoolAdmin(){
        if(this instanceof SchoolAdmin){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(!(obj instanceof User)){
            return false;
        }

        User user = (User) obj;
        if(user.getUsername().equals(this.username)){
            return true;
        } else {
            return false;
        }
    }

    public int compareTo(User user){
        if(this == user){
            return 0;
        }
        return (this.getfullName().compareTo(user.fullname));
    }
}