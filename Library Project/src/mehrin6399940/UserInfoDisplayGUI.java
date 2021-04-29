package mehrin6399940;

import javax.swing.*;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class UserInfoDisplayGUI extends JFrame {
    private JTextArea displayArea;

    private UserRegisterSystem userSys;

    public UserInfoDisplayGUI(UserRegisterSystem userSys) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.userSys = userSys;
        JButton backToMainMenuButton = new JButton("Back To Main Menu");
        displayArea = new JTextArea("");
        JPanel panelForDisplayFunction = new JPanel();
        panelForDisplayFunction.add(displayArea);
        panelForDisplayFunction.add(backToMainMenuButton);

        backToMainMenuButton.addActionListener(e -> {
            clear();
            userSys.backToMainSystemPage();
        });

        getRootPane().setContentPane(panelForDisplayFunction);
        setSize(1000,1000);
    }

    private void clear() {
        setVisible(false);
    }

    public void displayInfo(String infoToDisplay) {
        setVisible(true);
        displayArea.setText(infoToDisplay);
    }

}
