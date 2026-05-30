import java.util.ArrayList;
import java.time.LocalDate;

public class SchoolHELP {
    private ArrayList<School> schoolList;
    private ArrayList<User> userList;
    private ArrayList<Request> requestList;

    public SchoolHELP(){
        schoolList = new ArrayList<>();
        userList = new ArrayList<>();
        requestList = new ArrayList<>();
    }

    public void setSchoolList(ArrayList<School> schoolList){
        this.schoolList = schoolList;
    }

    public void setUserList(ArrayList<User> userList){
        this.userList = userList;
    }

    public void setRequestList(ArrayList<Request> requestList){
        this.requestList = requestList;
    }

    public void addSchool(School newSchool){
        schoolList.add(newSchool);
    }

    public void addUser(User newUser){
        userList.add(newUser);
    }

    public void addRequest(Request newRequest){
        requestList.add(newRequest);
    }

    public ArrayList<School> getSchoolList(){
        return schoolList;
    }

    public ArrayList<User> getUserList(){
        return userList;
    }

    public ArrayList<Request> getRequestList(){
        return requestList;
    }

    public ArrayList<SchoolAdmin> getSchoolAdminList(){
        ArrayList<SchoolAdmin> schoolAdminList = new ArrayList<>();
        getUserList().stream().filter(e -> e.isSchoolAdmin()).map(e -> (SchoolAdmin) e).forEach(schoolAdminList::add);
        return schoolAdminList;        
    }

    public ArrayList<Volunteer> getVolunteerList(){
        ArrayList<Volunteer> volunteerList = new ArrayList<>();
        getUserList().stream().filter(e -> e.isVolunteer()).map(e -> (Volunteer) e).forEach(volunteerList::add);
        return volunteerList;
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

    public boolean isUserVolunteer(String volunteerUsername, String volunteerPassword){
        User user = getUserList().stream().filter(e -> e.getUsername().equals(volunteerUsername) && e.getPassword().equals(volunteerPassword)).findAny().orElse(null);

        if(user == null){
            return false;
        }

        if(user.isVolunteer() == true){
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

    public boolean isValidTime(String strTime){
        if(strTime == null || strTime.length() != 5){
            return false;
        }

        if(strTime.charAt(2) != ':'){
            return false;
        }

        int parseHour = Integer.parseInt(strTime.substring(0,2));
        int parseMinute = Integer.parseInt(strTime.substring(3,5));

        if(parseHour >= 0 && parseHour <= 23){
            if(parseMinute >=0 && parseMinute <= 59){
                return true;
            }
        }

        return false;
    }
}