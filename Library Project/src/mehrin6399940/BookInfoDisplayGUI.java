package mehrin6399940;

import javax.swing.*;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */

public class BookInfoDisplayGUI extends JFrame {
    private BookRegisterSystem bookSys;
    private JTextArea displayArea;

    public BookInfoDisplayGUI(BookRegisterSystem bookSys) {
        this.bookSys = bookSys;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panelForDisplayFunction = new JPanel();
        JButton backToMainMenuButton = new JButton("Back to Main Menu");
        displayArea = new JTextArea("");

        backToMainMenuButton.addActionListener(e -> {
            clear();
            bookSys.bookSysBackToMainMenu();
        });

        panelForDisplayFunction.add(backToMainMenuButton);
        panelForDisplayFunction.add(displayArea);
        getRootPane().setContentPane(panelForDisplayFunction);
        pack();
        setSize(1000,1000);
    }

    private void clear() {
        displayArea.setText("");
        setVisible(false);
    }

    public void displayInfoOnGUI(String info) {
        setVisible(true);
        displayArea.setText(info);
    }


}