package testData.classes;

import org.json.simple.JSONObject;
import utils.Reader;

public class CheckoutData {
    //valid
    private String firstName;
    private String lastName;
    private String postalCode;

    //invalid
    private String invalidFirstName;
    private String invalidLastName;
    private String invalidPostalCode;

    //constructor
    public CheckoutData(String filename) {

        JSONObject root = Reader.json(filename);

        JSONObject validUser = (JSONObject) root.get("validUser");
        JSONObject invalidUser = (JSONObject) root.get("invalidUser");

        this.firstName = validUser.get("firstName").toString();
        this.lastName = validUser.get("lastName").toString();
        this.postalCode = validUser.get("postalCode").toString();

        this.invalidFirstName = invalidUser.get("invalidFirstName").toString();
        this.invalidLastName = invalidUser.get("invalidLastName").toString();
        this.invalidPostalCode = invalidUser.get("invalidPostalCode").toString();
    }

    //getters
    public String getfirstName() {
        return firstName;
    }
    public String getlastName() {
        return lastName;
    }
    public String getpostalCode() {
        return postalCode;
    }
    public String getinvalidFirstName() {
        return invalidFirstName;
    }
    public String getinvalidLastName() {
        return invalidLastName;
    }
    public String getinvalidPostalCode() {
        return invalidPostalCode;
    }

    //setters
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setpostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
    public void setinvalidFirstName(String invalidFirstName) {
        this.invalidFirstName = invalidFirstName;
    }
    public void setinvalidLastName(String invalidLastName) {
        this.invalidLastName = invalidLastName;
    }
    public void setinvalidPostalCode(String invalidPostalCode) {
        this.invalidPostalCode = invalidPostalCode;
    }
}