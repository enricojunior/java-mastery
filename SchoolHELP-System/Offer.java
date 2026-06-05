import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Offer {
    private LocalDate offerDate;
    private String remarks;
    private String offerStatus;
    private int offerID;

    private Volunteer thisVolunteer;
    private Request thisRequest;

    public Offer(LocalDate offerDate, String remarks, Volunteer thisVolunteer, Request thisRequest){
        setOfferID(validateOfferID(offerID));
        setOfferDate(offerDate);
        setRemarks(remarks);
        setThisVolunteer(thisVolunteer);
        setThisRequest(thisRequest);
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

    public void setOfferID(int offerID){
        this.offerID = offerID;
    }

    public void setThisVolunteer(Volunteer thisVolunteer){
        this.thisVolunteer = thisVolunteer;
    }

    public void setThisRequest(Request thisRequest){
        this.thisRequest = thisRequest;
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

    public int getOfferID(){
        return offerID;
    }

    public Volunteer getThisVolunteer(){
        return thisVolunteer;
    }

    public Request getThisRequest(){
        return thisRequest;
    }

    public int validateOfferID(int validID){
        if((validID < 100000) || (validID > 999999)){
            validID = (int) (Math.random() * 900000) + 100000;
        }
        return validID;
    }
}