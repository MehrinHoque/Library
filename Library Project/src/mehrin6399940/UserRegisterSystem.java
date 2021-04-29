package mehrin6399940;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class UserRegisterSystem {

    private ArrayList<User> userInSys;
    private UserInfoDisplayGUI userInfoDisplayGUI;
    private UserQueryGUI userQueryGUI;
    private UserRegisterGUI registerGUI;
    private MainSystem mainsystem;

    public UserRegisterSystem(MainSystem mainsystem) {
        this.mainsystem = mainsystem;

        userInSys = new ArrayList<>();
        userInfoDisplayGUI = new UserInfoDisplayGUI(this);
        registerGUI = new UserRegisterGUI(this);
        userQueryGUI = new UserQueryGUI(this);
    }

    public void setUserInSys(ArrayList<User> userInSys) {
        this.userInSys = userInSys;
    }

    public void loadObjectsFromFile(String filename) {
        boolean c = true;
        try {
            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (c) {
                Object a = oi.readObject();
                if (a instanceof Staff) {
                    userInSys.add((Staff) a);
                } else if (a instanceof Student) {
                    userInSys.add((Student) a);
                }

            }
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            c = false;
        } catch (IOException e) {
            c = false;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            c = false;
        }
    }

    public void saveObjsToFile(String filename) throws IOException {
        FileOutputStream f = new FileOutputStream(new File(filename));
        ObjectOutputStream o = new ObjectOutputStream(f);
        for(User user : userInSys){
            o.writeObject(user);
        }
        o.close();
        f.close();
    }

    public void openRegisterUserPage() {
        registerGUI.startUserRegister();
    }

    public void userSysDisplayInfro(String info) {
        userInfoDisplayGUI.displayInfo(info);
    }

    public void backToMainSystemPage() {
        mainsystem.mainSystemBackToMainMenu();
    }

    //search by first name or last name
    public void searchUserByQuery(String query) {
        query = query.trim().toLowerCase();
        ArrayList<User> resultsUser = new ArrayList<>();
        String infoToDisplay = "";
        for (User user : userInSys) {
            if ((user.getFirstName() + user.getLastName()).toLowerCase().contains(query)) {
                infoToDisplay += user.toString() + "\n";
            }
        }
        if (infoToDisplay.length() == 0) {
            infoToDisplay = "Not found 404";
        }
        userSysDisplayInfro(infoToDisplay);
    }

    /*String[] userDetails = {
            firstNameTextField.getText(),
            lastNameTextField.getText(),
            usernameTextField.getText(),
            passwordTextField.getText(),
            userTypeTextField.getText(),
            positionTextField.getText(),
            degreeTextField.getText(),
            courseTextField.getText()
    };*/
    public void registerUser(String[] info) {
        if (info[4].toLowerCase().equals("stu")) {
            Student student = new Student(userInSys.size() + "", info[0], info[1], info[2], info[3], UserType.getUserTypeByCode(info[4]),
                    info[6], info[7]);
            userInSys.add(student);
            userSysDisplayInfro(student.toString());
        } else {
            Staff staff = new Staff(userInSys.size() + "", info[0], info[1], info[2], info[3], UserType.getUserTypeByCode(info[4]),
                    info[5]);
            userInSys.add(staff);
            userSysDisplayInfro(staff.toString());
        }
    }

    public void openSearchUserPage() {
        userQueryGUI.startUserQuery();
    }

}
