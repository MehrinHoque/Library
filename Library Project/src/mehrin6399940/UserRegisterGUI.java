package mehrin6399940;

import javax.swing.*;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class UserRegisterGUI extends JFrame {
    private UserRegisterSystem userSys;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    private JTextField degreeTextField;
    private JTextField courseTextField;
    private JTextField userTypeTextField;
    private JTextField positionTextField;

    public UserRegisterGUI(UserRegisterSystem userSys) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.userSys = userSys;
        JPanel panelForRegisterFunction = new JPanel();

        JLabel studentLabel = new JLabel("Student please type in these fields(if not leave blank)");
        JLabel staffLabel = new JLabel("Staff please type in these fields(if not leave blank)");

        JButton backToMain = new JButton("Back main menu");
        JButton createUser = new JButton("Create");

        firstNameTextField = new JTextField("firstName");
        lastNameTextField = new JTextField("lastName");
        usernameTextField = new JTextField("username");
        passwordTextField = new JTextField("password");
        positionTextField = new JTextField("position");
        degreeTextField = new JTextField("degree");
        courseTextField = new JTextField("course");

        userTypeTextField = new JTextField("fill in one: stu,genstaff,ad,acastaff,lib");
        backToMain.addActionListener(e -> {
            clear();
            userSys.backToMainSystemPage();
        });
        createUser.addActionListener(e -> {
            String[] userDetails = {
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    usernameTextField.getText(),
                    passwordTextField.getText(),
                    userTypeTextField.getText(),
                    positionTextField.getText(),
                    degreeTextField.getText(),
                    courseTextField.getText()
            };

            checkInput(userDetails,userDetails[4]);
            if(checkInput(userDetails,userDetails[4])){
                returnInfoToSys(userDetails);
                clear();
            }
            else{

                firstNameTextField.setText("firstName");
                usernameTextField.setText("username");
                lastNameTextField.setText("lastName");
                degreeTextField.setText("degree");
                courseTextField.setText("course");
                passwordTextField.setText("password");
                positionTextField.setText("position");
                userTypeTextField.setText("fill in one of these type: stu,genstaff,ad,acastaff,lib");
            }


        });

        panelForRegisterFunction.add(firstNameTextField);
        panelForRegisterFunction.add(lastNameTextField);
        panelForRegisterFunction.add(usernameTextField);
        panelForRegisterFunction.add(passwordTextField);
        panelForRegisterFunction.add(userTypeTextField);
        panelForRegisterFunction.add(staffLabel);
        panelForRegisterFunction.add(positionTextField);
        panelForRegisterFunction.add(studentLabel);
        panelForRegisterFunction.add(degreeTextField);
        panelForRegisterFunction.add(courseTextField);
        panelForRegisterFunction.add(createUser);
        panelForRegisterFunction.add(backToMain);

        getRootPane().setContentPane(panelForRegisterFunction);
        pack();

    }

    public void startUserRegister() {
        setVisible(true);
    }

    public void clear() {
        firstNameTextField.setText("firstName");
        usernameTextField.setText("username");
        lastNameTextField.setText("lastName");
        degreeTextField.setText("degree");
        courseTextField.setText("course");
        passwordTextField.setText("password");
        positionTextField.setText("position");
        userTypeTextField.setText("fill in one of these type: stu,genstaff,ad,acastaff,lib");
        setVisible(false);
    }

    public void returnInfoToSys(String[] info) {
        userSys.registerUser(info);
    }

    public boolean checkInput(String[] info, String userType) {
        for (int i = 0; i < 4;i++ ) {
            if (info[i].length() == 0) {
                return false;
            }
        }
        System.out.println(userType);
        System.out.println(UserType.getUserTypeByCode(userType));
        if (UserType.getUserTypeByCode(userType) == null) {
            return false;
        }
        int countHowManyNonEmptyElement = 0;
        for(String i : info){
            if(i.length() != 0){
                countHowManyNonEmptyElement ++ ;
            }
        }
        if(UserType.getUserTypeByCode(userType) == UserType.STUDENT){
            if(countHowManyNonEmptyElement != 7) {
                return false;
            }
        }
        else{
            if(countHowManyNonEmptyElement !=6){
                return false;
            }
        }

        return true;
    }
}
