package mehrin6399940;


/**
 * @author Mosammat Mehrin Fatima Hoque
 */

import javax.swing.*;

public class BookRegisterGUI extends JFrame {
    private JTextField floorTextField;
    private JTextField shelfNumberTextField;
    private JTextField isbnTextField;
    private JTextField callNumberTextField;
    private JTextField titleTextField;
    private JTextField campusNameTextField;
    private JTextField abstractTextField;
    private JTextField publisherTextField;
    private JTextField authorInfo;
    private BookRegisterSystem bookSys;


    public BookRegisterGUI(BookRegisterSystem bookSys) {
        this.bookSys = bookSys;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelForRegisterFunction = new JPanel();



        isbnTextField = new JTextField("isbn: ");
        abstractTextField = new JTextField("abstract: ");
        publisherTextField = new JTextField("publisher");
        callNumberTextField = new JTextField("call number: ");
        titleTextField = new JTextField("title: ");
        JButton registerBookButton = new JButton("Create Book Record");
        JButton backToMainButton = new JButton("Back To Main Menu");
        campusNameTextField = new JTextField("campus name: ");
        floorTextField = new JTextField("floor: ");
        shelfNumberTextField = new JTextField("shelf number: ");


        authorInfo = new JTextField("author of the book (example: Miss Mehrin Mosammat Hoque");

        panelForRegisterFunction.add(isbnTextField);
        panelForRegisterFunction.add(callNumberTextField);
        panelForRegisterFunction.add(titleTextField);
        panelForRegisterFunction.add(abstractTextField);
        panelForRegisterFunction.add(publisherTextField);
        panelForRegisterFunction.add(authorInfo);
        panelForRegisterFunction.add(campusNameTextField);
        panelForRegisterFunction.add(floorTextField);
        panelForRegisterFunction.add(shelfNumberTextField);
        panelForRegisterFunction.add(registerBookButton);
        panelForRegisterFunction.add(backToMainButton);

        registerBookButton.addActionListener(e -> {
            String[] bookInfoStringArray = {
                    isbnTextField.getText(),
                    callNumberTextField.getText(),
                    titleTextField.getText(),
                    abstractTextField.getText(),
                    publisherTextField.getText(),
                    "This Book is Active",
                    authorInfo.getText(),
                    campusNameTextField.getText(),
                    floorTextField.getText(),
                    shelfNumberTextField.getText(),
            };
            if(checkInputValid(bookInfoStringArray,bookInfoStringArray[6])){
                returnInfoToSys(bookInfoStringArray);
                clear();
            }
            else{
                isbnTextField.setText("isbn: ");
                abstractTextField.setText("abstract: ");
                publisherTextField.setText("publisher");
                callNumberTextField.setText("call number: ");
                titleTextField.setText("title: ");
                campusNameTextField.setText("campus name: ");
                floorTextField.setText("floor: ");
                shelfNumberTextField.setText("shelf number: ");
                authorInfo.setText("author of the book (example format: Miss Mehrin Mosammat Hoque");
            }
        });

        backToMainButton.addActionListener(e -> {
            clear();
            bookSys.bookSysBackToMainMenu();
        });
        setVisible(false);

        getRootPane().setContentPane(panelForRegisterFunction);
        pack();
    }

    private void clear() {
        setVisible(false);
    }

    private void returnInfoToSys(String[] info) {
        bookSys.registerBook(info);
    }

    private boolean checkInputValid(String[] arrToCheck,String author){
        for(int i = 0; i < arrToCheck.length; i++){
            if(arrToCheck.length == 0){
                return false;
            }
        }

        author = author.trim();
        if(author.split(" ").length != 4){
            return false;
        }
        return true;

    }
    public void startBookRegisterGUI() {
        setVisible(true);
    }


}