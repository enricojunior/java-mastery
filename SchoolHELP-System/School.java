import java.util.ArrayList;

public class School {
    private int schoolID;
    private String schoolName;
    private String address;
    private String city;

    private ArrayList<SchoolAdmin> schoolAdminList = new ArrayList<>();
    private ArrayList<Request> requestList = new ArrayList<>();
    
    public School(String schoolName, String address, String city){
        setSchoolID(validateSchoolID(schoolID));
        setSchoolName(schoolName);
        setAddress(address);
        setCity(city);
    }

    public void setSchoolID(int schoolID){
        this.schoolID = schoolID;
    }

    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setRequestList(ArrayList<Request> requestList){
        this.requestList = requestList;
    }

    public void setSchoolAdminList(ArrayList<SchoolAdmin> schoolAdminList){
        this.schoolAdminList = schoolAdminList;
    }

    public String getSchoolName(){
        return schoolName;
    }

    public int getSchoolID(){
        return schoolID;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public ArrayList<Request> getRequestList(){
        return requestList;
    }

    public ArrayList<SchoolAdmin> getSchoolAdminList(){
        return schoolAdminList;
    }

    public void addRequest(Request newRequest){
        getRequestList().add(newRequest);
    }

    public void addSchoolAdmin(SchoolAdmin newSchoolAdmin){
        getSchoolAdminList().add(newSchoolAdmin);
    }

    public int validateSchoolID(int validID){
        if((validID < 100000) || (validID > 999999)){
            validID = (int) (Math.random() * 900000) + 100000;
        }
        return validID;
    }
}