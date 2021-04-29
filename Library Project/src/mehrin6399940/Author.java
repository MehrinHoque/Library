package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */

public class Author implements Serializable {
    private String id;
    private String title;
    private String firstName;
    private String lastName;
    private String middleName;

    public Author(String id, String title, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getTitle() {
        return title;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    @Override
    public String toString() {
        return title + firstName + lastName + middleName;
    }

}
