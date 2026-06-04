import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

abstract public class Request {
    private int requestID;
    private LocalDate requestDate;
    private String requestStatus;
    private String description;

    private School thisSchool;
    private ArrayList<Offer> offerList = new ArrayList<>();

    public Request(LocalDate requestDate, String description, School thisSchool){
        setRequestID(validateRequestID(requestID));
        setRequestDate(requestDate);
        setRequestStatus("NEW");
        setDescription(description);
        setThisSchool(thisSchool);
    }

    public void setRequestID(int requestID){
        this.requestID = requestID;
    }

    public void setRequestDate(LocalDate requestDate){
        this.requestDate = requestDate;
    }

    public void setRequestStatus(String requestStatus){
        this.requestStatus = requestStatus;
    }

    public void setDescription(String description){
        this.description = description;
    } 

    public void setThisSchool(School thisSchool){
        this.thisSchool = thisSchool;
    }

    public void setOfferList(ArrayList<Offer> offerList){
        this.offerList = offerList;
    }

    public int getRequestID(){
        return requestID;
    }

    public LocalDate getRequestDate(){
        return requestDate;
    }

    public String getRequestStatus(){
        return requestStatus;
    }

    public String getDescription(){
        return description;
    }

    public School getThisSchool(){
        return thisSchool;
    }

    public ArrayList<Offer> getOfferList(){
        return offerList;
    }

    public int validateRequestID(int validID){
        if((validID < 100000) || (validID > 999999)){
            validID = (int) (Math.random() * 900000) + 100000;
        }
        return validID;
    }

    @Override
    public String toString(){
        DateTimeFormatter dtFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String details = "";
        details += "[ Request ID: " + getRequestID() + ", Request Date: " + getRequestDate()
                + ", Status: " + getRequestStatus() + ", Date: " + requestDate.format(dtFormat)
                + ", Description: " + getDescription();
        return details;
    }

    public String getRequestCategory(){
        if(this instanceof TutorialRequest){
            return "Tutorial Request";
        } else if(this instanceof ResourceRequest){
            return "Resource Request";
        } else {
            return "Invalid Request";
        }
    }

    public void addOffer(Offer newOffer){
        getOfferList().add(newOffer);
    }
}