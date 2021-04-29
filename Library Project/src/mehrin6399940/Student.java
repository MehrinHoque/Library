package mehrin6399940;

import java.io.Serializable;


/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class Student extends User implements Serializable {
    private String course;
    private String degree;

    public Student(String identityNumber, String firstName, String lastName, String username, String password, UserType userType, String course, String degree) {
        super(identityNumber, firstName, lastName, username, password, userType);
        this.course = course;
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Student: " + course + ',' + degree + ',' + userId + ',' + firstName + ',' + lastName + ',' + username + ',' + password + ',' + userType;
    }

    public String getCourse() {
        return course;
    }

    public String getDegree() {
        return degree;
    }

}
