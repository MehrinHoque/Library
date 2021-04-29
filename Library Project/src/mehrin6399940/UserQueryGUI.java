package mehrin6399940;

import javax.swing.*;


/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class UserQueryGUI extends JFrame {
    private UserRegisterSystem userSys;
    private JTextField searchField;

    public UserQueryGUI(UserRegisterSystem userSys) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.userSys = userSys;

        JPanel panelForQueryFunctions = new JPanel();

        JButton backToMainButton = new JButton("Back to Main");
        JButton searchUserButton = new JButton("Search user");
        searchField = new JTextField("Enter part of firstname or last name  to search");
        panelForQueryFunctions.add(searchField);
        panelForQueryFunctions.add(searchUserButton);
        panelForQueryFunctions.add(backToMainButton);

        backToMainButton.addActionListener(e -> {
            userSys.backToMainSystemPage();
            clear();
        });

        searchUserButton.addActionListener(e -> {
            String query = searchField.getText();
            if(query.length() == 0){
                searchField.setText("Enter part of firstname or last name  to search");
            }
            else{
                returnQueryInfoToSystem(query);
                clear();
            }

        });

        getRootPane().setContentPane(panelForQueryFunctions);
        pack();

    }

    public void startUserQuery() {
        setVisible(true);
    }

    public void clear() {
        setVisible(false);
    }

    public void returnQueryInfoToSystem(String query) {
        userSys.searchUserByQuery(query);
    }
}
