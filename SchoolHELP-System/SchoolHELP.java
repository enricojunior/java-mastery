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

    public boolean isSchoolRegistered(String schoolName){
        School school = getSchoolList().stream().filter(e -> e.getSchoolName().equalsIgnoreCase(schoolName))
                                                .findFirst().orElse(null);
        if(school != null){
            return true;
        }
        return false;
    }

    public School findSchoolByName(String schoolName){
        return getSchoolList().stream().filter(e -> e.getSchoolName().equalsIgnoreCase(schoolName)).findFirst().orElse(null);
    }

    public User getUser(String username, String password){
        for(User user : getUserList()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
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