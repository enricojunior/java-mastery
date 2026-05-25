public class SchoolAdmin extends User {
    private int staffID;
    private String position;
    private School thisSchool;

    public SchoolAdmin(String username, String password, String fullname, String email, String phone, int staffID, String position, School thisSchool){
        super(username, password, fullname, email, phone);
        this.staffID = staffID;
        this.position = position;
        this.thisSchool = thisSchool;
    }

    public void setStaffID(int staffID){
        this.staffID = staffID;
    }

    public void setPosition(String position){
        this.position = position;
    }

    public void setSchool(School thisSchool){
        this.thisSchool = this.thisSchool;
    }

    public int getStaffID(){
        return staffID;
    }

    public String getPosition(){
        return position;
    }

    public School getSchool(){
        return thisSchool;
    }
}