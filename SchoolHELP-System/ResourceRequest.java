import java.time.LocalDate;

public class ResourceRequest extends Request {
    private String resourceType;
    private int numRequired;

    public ResourceRequest(LocalDate requestDate, String description, School thisSchool, String resourceType, int numRequired){
        super(requestDate, description, thisSchool);
        setResourceType(resourceType);
        setNumRequired(numRequired);
    }

    public void setResourceType(String resourceType){
        this.resourceType = resourceType;
    }

    public void setNumRequired(int numRequired){
        this.numRequired = numRequired;
    }

    public String getResourceType(){
        return resourceType;
    }

    public int getNumRequired(){
        return numRequired;
    }

    @Override
    public String toString(){
        String details = "";
        details += super.toString() + ", Resource Type: " + getResourceType() + ", "
                + "Numbers required: " + getNumRequired() + " ].";
        return details;            
    }
}