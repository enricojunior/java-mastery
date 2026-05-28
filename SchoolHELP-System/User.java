import java.util.Random;

abstract public class User implements Comparable<User> {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phone;

    public User(){
        setUsername("SchoolAdmin");
        setPassword("admin123");
        setfullName("Admin");
        setEmail("schooladmin@gmail.com");
        setPhone("123");
    }

    public User(String username, String password, String fullname, String email, String phone){
        setUsername(username);
        setPassword(password);
        setfullName(fullname);
        setEmail(email);
        setPhone(phone);
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

    public String getPassword(){
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

    public boolean isVolunteer(){
        if(this instanceof Volunteer){
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