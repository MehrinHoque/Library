package mehrin6399940;

import javax.swing.*;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class BookQueryGUI extends JFrame {
    private BookRegisterSystem bookSys;

    private JTextField searchFieldForAuthorName;
    private JTextField searchFieldForBookTitle;

    public BookQueryGUI(BookRegisterSystem bookSys) {
        this.bookSys = bookSys;

        JPanel panelForSearchFunction = new JPanel();

        JLabel searchLabel = new JLabel("You can search using only one of the following fields,leave other blank: ");
        JButton backToMainMenu = new JButton("Back To Main Menu");

        searchFieldForAuthorName = new JTextField("Enter author name");
        searchFieldForBookTitle = new JTextField("Enter book title");
        JButton searchForBookButton = new JButton("Search");


        searchForBookButton.addActionListener(e -> {
            returnQueryInfoToSystem(searchFieldForBookTitle.getText() + searchFieldForAuthorName.getText());
            clear();

        });

        backToMainMenu.addActionListener(e -> {
            bookSys.bookSysBackToMainMenu();
            clear();
        });
        panelForSearchFunction.add(searchLabel);
        panelForSearchFunction.add(searchFieldForAuthorName);
        panelForSearchFunction.add(searchFieldForBookTitle);
        panelForSearchFunction.add(searchForBookButton);
        panelForSearchFunction.add(backToMainMenu);

        getRootPane().setContentPane(panelForSearchFunction);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void clear() {
        searchFieldForAuthorName.setText("Enter author name");
        searchFieldForBookTitle.setText("Enter book title");
        setVisible(false);
    }

    public void startBookQueryGUI() {
        setVisible(true);
    }

    private void returnQueryInfoToSystem(String query) {
        bookSys.searchBook(query);
    }


}
