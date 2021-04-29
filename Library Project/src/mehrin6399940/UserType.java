package mehrin6399940;
/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public enum UserType {
    STUDENT("stu", "Student"),
    GENERALSTAFF("genstaff", "General Staff"),
    ADMINSTAFF("ad", "Admin Staff"),
    ACADEMICSTAFF("acastaff","Academic Staff"),
    LIBRARIAN("lib", "Librarian");


    private String code;
    private String fullName;

    UserType(String code, String fullName) {
        this.code = code;
        this.fullName = fullName;
    }

    public String getCode() {
        return code;
    }

    public static UserType getUserTypeByCode(String code) {
        for(UserType userType : UserType.values()){
            if(userType.getCode().equals(code)){
                return userType;
            }
        }
        return null;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}
