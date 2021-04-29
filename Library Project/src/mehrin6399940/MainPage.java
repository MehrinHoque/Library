package mehrin6399940;

import javax.swing.*;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class MainPage extends JFrame {
    private MainSystem mainSys;

    public MainPage(MainSystem mainSys) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainSys = mainSys;
        JButton bookCreateButton = new JButton("Create Book Record");
        JButton searchBookButton = new JButton("Query Book");
        JButton exitProgram = new JButton("Exit");
        JButton userCreateButton = new JButton("Create User");
        JButton userSearchButton = new JButton("Query User");


        JPanel panelForMainPage = new JPanel();
        panelForMainPage.add(bookCreateButton);
        bookCreateButton.addActionListener(e -> {
            mainPageRegisterNewBook();
        });

        panelForMainPage.add(userCreateButton);
        userCreateButton.addActionListener(e -> {
            mainPageCreateNewUser();
        });

        panelForMainPage.add(exitProgram);
        exitProgram.addActionListener(e -> {
            System.exit(0);
        });

        panelForMainPage.add(searchBookButton);

        searchBookButton.addActionListener(e -> {
            mainPageQueryBook();
        });

        panelForMainPage.add(userSearchButton);
        userSearchButton.addActionListener(e -> {
            mainPageQueryUser();
        });

        getRootPane().setContentPane(panelForMainPage);

        setVisible(true);
        pack();
    }

    public void clear() {
        setVisible(false);
    }

    public void mainPageGoesToMainMenu() {
        setVisible(true);
    }

    public void mainPageRegisterNewBook() {
        clear();
        mainSys.createBook();
    }

    public void mainPageQueryBook() {
        clear();
        mainSys.queryBook();
    }

    public void mainPageCreateNewUser() {
        clear();
        mainSys.createUser();
    }

    public void mainPageQueryUser() {
        clear();
        mainSys.queryUser();
    }

}
