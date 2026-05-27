import java.time.LocalDate;

public class TutorialRequest extends Request {
    private String proposedDate;
    private String proposedTime;
    private int studentLevel;
    private int numStudents;

    public TutorialRequest(LocalDate requestDate, String description, School thisSchool, String proposedDate, String proposedTime, int studentLevel, int numStudents){
        super(requestDate, description, thisSchool);
        setProposedDate(proposedDate);
        setProposedTime(proposedTime);
        setStudentLevel(studentLevel);
        setNumStudents(numStudents);
    }

    public void setProposedDate(String proposedDate){
        this.proposedDate = proposedDate;
    }

    public void setProposedTime(String proposedTime){
        this.proposedTime = proposedTime;
    }

    public void setStudentLevel(int studentLevel){
        this.studentLevel = studentLevel;
    }

    public void setNumStudents(int numStudents){
        this.numStudents = numStudents;
    }

    public String getProposedDate(){
        return proposedDate;
    }

    public String getProposedTime(){
        return proposedTime;
    }

    public int getStudentLevel(){
        return studentLevel;
    }

    public int getNumStudents(){
        return numStudents;
    }

    @Override
    public String toString(){
        String details = "";
        details += super.toString() + ", Proposed Date and Time: " + getProposedDate() + ". " 
                + getProposedTime() + ", Student Level: " + getStudentLevel() + ", Number of Students: "
                + getNumStudents() + " ].";
        return details;
    }
}