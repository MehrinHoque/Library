package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public abstract class User implements Serializable {
    protected String userId;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;
    protected UserType userType;

    public User(String userId, String firstName, String lastName, String username, String password, UserType userType) {
        this.userId = userId;
        this.username = username;
        this.lastName = lastName;
        this.password = password;
        this.firstName = firstName;
        this.userType = userType;

    }
    @Override
    public String toString() {
        return "User{}";
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserType getUserType() {
        return userType;
    }

}
