package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class Staff extends User implements Serializable {
    private String position;

    public Staff(String identityNumber, String firstName, String lastName, String username, String password, UserType userType, String position) {
        super(identityNumber, firstName, lastName, username, password, userType);
        this.position = position;
    }

    @Override
    public String toString() {
        return "StaffInfo: " + position + ',' + userId + ',' + firstName + ',' + lastName + ',' +
                username + ',' + password + ',' + userType;
    }

    public String getPosition() {
        return position;
    }
}
