import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Offer {
    private LocalDate offerDate;
    private String remarks;
    private String offerStatus;

    private Volunteer thisVolunteer;

    public Offer(LocalDate offerDate, String remarks, Volunteer thisVolunteer){
        setOfferDate(offerDate);
        setRemarks(remarks);
        setThisVolunteer(thisVolunteer);
        setOfferStatus("PENDING");
    }

    public void setOfferDate(LocalDate offerDate){
        this.offerDate = offerDate;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }

    public void setOfferStatus(String offerStatus){
        this.offerStatus = offerStatus;
    }

    public void setThisVolunteer(Volunteer thisVolunteer){
        this.thisVolunteer = thisVolunteer;
    }

    public LocalDate getOfferDate(){
        return offerDate;
    }

    public String getRemarks(){
        return remarks;
    }

    public String getOfferStatus(){
        return offerStatus;
    }

    public Volunteer getThisVolunteer(){
        return thisVolunteer;
    }
}