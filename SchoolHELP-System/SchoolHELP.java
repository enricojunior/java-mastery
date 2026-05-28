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

    public boolean isValidDate(String strDate){
        int parseDay = Integer.parseInt(strDate.substring(0,2));
        int parseMonth = Integer.parseInt(strDate.substring(3,5));
        int parseYear = Integer.parseInt(strDate.substring(6,10));
        boolean isLeapYear;

        if((parseYear % 4 == 0 && parseYear % 100 != 0) || (parseYear % 400 == 0)){
            isLeapYear = true;
        } else {
            isLeapYear = false;
        }

        if(parseMonth == 2){
            if((isLeapYear && parseDay >= 1 && parseDay <= 29)){
                return true;
            } else if(!isLeapYear && parseDay >= 1 && parseDay <= 28){
                return true;
            } // no else-statement
        } else if((parseMonth == 1 || parseMonth == 3 || parseMonth == 5 || parseMonth == 7 || 
            parseMonth == 8 || parseMonth == 10 || parseMonth == 12)){
            if(parseDay >= 1 && parseDay <= 31){
                return true;
            }
        } else if((parseMonth == 4 || parseMonth == 6 || parseMonth == 9 || parseMonth == 11)){
            if(parseDay >= 1 && parseDay <= 30){
                return true;
            }
        } // no else-statement

        return false;
    }
}