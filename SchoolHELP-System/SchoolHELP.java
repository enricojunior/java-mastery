import java.util.ArrayList;
import java.time.LocalDate;

public class SchoolHELP {
    private ArrayList<School> schoolList;
    private ArrayList<User> userList;

    public SchoolHELP(){
        schoolList = new ArrayList<>();
        userList = new ArrayList<>();
    }

    public void setSchoolList(ArrayList<School> schoolList){
        this.schoolList = schoolList;
    }

    public void setUserList(ArrayList<User> userList){
        this.userList = userList;
    }

    public void addSchool(School newSchool){
        schoolList.add(newSchool);
    }

    public void addUser(User newUser){
        userList.add(newUser);
    }

    public ArrayList<School> getSchoolList(){
        return schoolList;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }
}