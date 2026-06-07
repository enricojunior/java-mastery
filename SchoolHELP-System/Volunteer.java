import java.util.ArrayList;

public class Volunteer extends User {
    private String dateOfBirth;
    private String occupation;

    private ArrayList<Offer> offerList = new ArrayList<>();

    public Volunteer(String username, String password, String fullname, String email, String phone, String dateOfBirth, String occupation){
        super(username, password, fullname, email, phone);
        setDateOfBirth(dateOfBirth);
        setOccupation(occupation);
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public void setOccupation(String occupation){
        this.occupation = occupation;
    }

    public void setOfferList(ArrayList<Offer> offerList){
        this.offerList = offerList;
    }

    public String getDateOfBirth(){
        return dateOfBirth;
    }

    public String getOccupation(){
        return occupation;
    }

    public ArrayList<Offer> getOfferList(){
        return offerList;
    }

    public void addOffer(Offer newOffer){
        getOfferList().add(newOffer);
    }

    public ArrayList<Offer> filteredOfferList(){
        ArrayList<Offer> filteredOfferList = new ArrayList<>();
        getOfferList().stream().filter(e -> e.getOfferStatus().equals("ACCEPTED") || e.getOfferStatus().equals("REJECTED")).forEach(filteredOfferList::add);
        return filteredOfferList;
    }
}