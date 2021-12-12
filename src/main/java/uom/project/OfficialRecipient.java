package uom.project;

import java.io.Serializable;

class OfficialRecipient extends Recipient implements Serializable {

    private final String designation;

    // set details
    public OfficialRecipient(String name, String email, String designation) {
        super(name, email);
        this.designation = designation;
    }

    // get details
    public final String getDesignation() {
        return this.designation;
    }
}
