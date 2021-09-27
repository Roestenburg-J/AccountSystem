package za.ac.nwu.ac.domain.service;

public class GeneralResponse<String> {
    private boolean successful = false;

    private java.lang.String payload = "No types Found";

    public GeneralResponse(boolean successful, java.lang.String payload) {
        this.successful = successful;
        this.payload = payload;
    }

    public boolean getSuccessful(){
        return successful;
    }

    public java.lang.String getPayload(){
        return  payload;
    }
}
