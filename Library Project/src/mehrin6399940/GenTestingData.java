package mehrin6399940;

import java.io.IOException;
import java.util.ArrayList;


/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class GenTestingData {
    public static void main(String[] args) throws IOException {
        Book howToDoJava = new Book("23523", "696969", "JAVA/001", "how to do java", "this book is for dummies",
                "UOW", "this book is active");

        Author authorOfHowToDoJava = new Author("1234", "PhD", "Mehrin", "Mossamat", "Hoque");

        BookAuthorRecord bookAuthorRecord = new BookAuthorRecord("134", howToDoJava.getId(), authorOfHowToDoJava.getId(), "1");

        Location locationInLib = new Location("154", "UNSW", "5", "3");

        BookLocationRecord bookLocationRecord1 = new BookLocationRecord("100", howToDoJava.getId(), locationInLib.getId());

        Student uowStudent = new Student("523564", "Json", "Peter", "Mohammad", "123456", UserType.STUDENT,
                "BchCompSci", "MasterCompsi");

        Staff uowStaff = new Staff("415325", "Peter", "John", "hello", "123456", UserType.GENERALSTAFF,
                "staff2Position");

        MainSystem mainSystem = new MainSystem();
        ArrayList<Book> books = new ArrayList<>();
        books.add(howToDoJava);
        ArrayList<Author> authors = new ArrayList<>();
        authors.add(authorOfHowToDoJava);
        ArrayList<Location> locatio = new ArrayList<>();
        locatio.add(locationInLib);
        ArrayList<BookAuthorRecord> bookAuthorRecords = new ArrayList<>();
        bookAuthorRecords.add(bookAuthorRecord);
        ArrayList<BookLocationRecord> bookLocationRecords = new ArrayList<>();
        bookLocationRecords.add(bookLocationRecord1);

        ArrayList<User> users = new ArrayList<>();
        users.add(uowStaff);
        users.add(uowStudent);

        mainSystem.addAuthorsToSys(authors);
        mainSystem.addLocationsToSys(locatio);
        mainSystem.addBooksToSys(books);
        mainSystem.addBookAuthorRecordsToSys(bookAuthorRecords);
        mainSystem.addBookLocationRecordToSys(bookLocationRecords);
        mainSystem.addUsersToSys(users);

        mainSystem.saveObjFromBookSys("world.txt");
        mainSystem.saveObjFromUserSys("myFriend.txt");
        System.exit(0);
    }
}