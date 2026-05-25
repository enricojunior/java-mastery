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

    public ArrayList<SchoolAdmin> getSchoolAdminList(){
        ArrayList<SchoolAdmin> schoolAdminList = new ArrayList<>();
        getUserList().stream().filter(e -> e.isSchoolAdmin()).map(e -> (SchoolAdmin) e).forEach(schoolAdminList::add);
        return schoolAdminList;        
    }

    public boolean isUserTaken(String username, String fullname, String email){
        for(User user : userList){
            if(user.getUsername().equals(username) 
               && user.getfullName().equals(fullname)
               && user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    public boolean isUserSchoolAdmin(String schoolAdminUsername, String schoolAdminPassword){
        User user = getUserList().stream().filter(e -> e.getUsername().equals(schoolAdminUsername) && e.getPassword().equals(schoolAdminPassword)).findAny().orElse(null);
        
        if(user == null){
            return false;
        }

        if(user.isSchoolAdmin() == true){
            return true; 
        } else {
            return false;
        }
    }
}