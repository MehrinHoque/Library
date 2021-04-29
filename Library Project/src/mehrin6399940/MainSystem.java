package mehrin6399940;


import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class MainSystem {
    private MainPage main;
    private BookRegisterSystem bookSys;
    private UserRegisterSystem userSys;


    public MainSystem() {
        userSys = new UserRegisterSystem(this);
        main = new MainPage(this);
        bookSys = new BookRegisterSystem(this);
    }

    public void queryBook() {
        bookSys.bookSysOpenSearchGUI();
    }

    public void queryUser() {
        userSys.openSearchUserPage();
    }

    public void saveObjFromBookSys(String filePath) throws IOException {
        bookSys.saveObjsToFile(filePath);
    }

    public void loadObjectsToBothSystems(String filePath) {
        userSys.loadObjectsFromFile(filePath);
        bookSys.loadObjectsFromFile(filePath);
    }

    public void saveObjFromUserSys(String filePath) throws IOException {
        userSys.saveObjsToFile(filePath);
    }

    public void createBook() {
        bookSys.bookSysOpenRegisterGUI();
    }

    public void createUser() {
        userSys.openRegisterUserPage();
    }

    public void mainSystemBackToMainMenu() {
        main.mainPageGoesToMainMenu();
    }

    public void addBooksToSys(ArrayList<Book> books) {
        bookSys.setBooksInSystem(books);
    }

    public void addLocationsToSys(ArrayList<Location> locations) {
        bookSys.setLocationsInSystem(locations);
    }

    public void addAuthorsToSys(ArrayList<Author> authors) {
        bookSys.setAuthorsInSystem(authors);
    }

    public void addBookAuthorRecordsToSys(ArrayList<BookAuthorRecord> records) {
        bookSys.setBookAuthorRecordsInSystem(records);
    }

    public void addBookLocationRecordToSys(ArrayList<BookLocationRecord> locations) {
        bookSys.setBookLocationRecordsInSystem(locations);
    }

    public void addUsersToSys(ArrayList<User> users) {
        userSys.setUserInSys(users);
    }

}
