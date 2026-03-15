package testData.classes;

import org.json.simple.JSONObject;
import utils.Reader;

public class CheckoutData {

    private String firstName;
    private String lastName;
    private String postalCode;

    public CheckoutData(String filename) {
        JSONObject root = Reader.json(filename);

        this.firstName = root.get("firstName").toString();
        this.lastName = root.get("lastName").toString();
        this.postalCode = root.get("postalCode").toString();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}