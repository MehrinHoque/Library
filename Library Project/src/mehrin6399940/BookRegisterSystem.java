package mehrin6399940;

import java.io.*;
import java.util.ArrayList;


/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class BookRegisterSystem {
    private ArrayList<Book> booksInSystem;
    private ArrayList<BookAuthorRecord> bookAuthorRecordsInSystem;
    private ArrayList<BookLocationRecord> bookLocationRecordsInSystem;
    private ArrayList<Author> authorsInSystem;
    private ArrayList<Location> locationsInSystem;
    private BookRegisterGUI bookRegisterGUI;
    private BookInfoDisplayGUI bookInfoDisplayGUI;
    private BookQueryGUI bookQueryGUI;
    private MainSystem main;


    public BookRegisterSystem(MainSystem main) {
        this.main = main;

        bookAuthorRecordsInSystem = new ArrayList<>();
        bookLocationRecordsInSystem = new ArrayList<>();
        booksInSystem = new ArrayList<>();
        authorsInSystem = new ArrayList<>();
        bookInfoDisplayGUI = new BookInfoDisplayGUI(this);
        bookRegisterGUI = new BookRegisterGUI(this);
        locationsInSystem = new ArrayList<>();
        bookQueryGUI = new BookQueryGUI(this);
    }


    public void setBooksInSystem(ArrayList<Book> booksInSystem) {
        this.booksInSystem = booksInSystem;
    }

    public void setBookAuthorRecordsInSystem(ArrayList<BookAuthorRecord> bookAuthorRecordsInSystem) {
        this.bookAuthorRecordsInSystem = bookAuthorRecordsInSystem;
    }

    public void setBookLocationRecordsInSystem(ArrayList<BookLocationRecord> bookLocationRecordsInSystem) {
        this.bookLocationRecordsInSystem = bookLocationRecordsInSystem;
    }

    public void setAuthorsInSystem(ArrayList<Author> authorsInSystem) {
        this.authorsInSystem = authorsInSystem;
    }

    public void setLocationsInSystem(ArrayList<Location> locationsInSystem) {
        this.locationsInSystem = locationsInSystem;
    }

    public void loadObjectsFromFile(String filename) {
        boolean c = true;
        try {
            FileInputStream fi = new FileInputStream(new File(filename));
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (c) {
                Object a = oi.readObject();

                if (a == null) {
                    c = false;
                } else {
                    if (a instanceof Book) {
                        booksInSystem.add((Book) a);
                    } else if (a instanceof BookLocationRecord) {
                        bookLocationRecordsInSystem.add((BookLocationRecord) a);
                    } else if (a instanceof BookAuthorRecord) {
                        bookAuthorRecordsInSystem.add((BookAuthorRecord) a);
                    } else if (a instanceof Location) {
                        locationsInSystem.add((Location) a);
                    } else if (a instanceof Author) {
                        authorsInSystem.add((Author) a);
                    }
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
        for(Author author : authorsInSystem){
            o.writeObject(author);
        }
        for(Book book : booksInSystem){
            o.writeObject(book);
        }
        for(Location location : locationsInSystem){
            o.writeObject(location);
        }
        for(BookAuthorRecord bookAuthorRecord : bookAuthorRecordsInSystem){
            o.writeObject(bookAuthorRecord);
        }
        for( BookLocationRecord bookLocationRecord : bookLocationRecordsInSystem){
            o.writeObject(bookLocationRecord);
        }

        o.close();
        f.close();
    }

    public void bookSysBackToMainMenu() {
        main.mainSystemBackToMainMenu();
    }

    public void bookSysOpenRegisterGUI() {
        bookRegisterGUI.startBookRegisterGUI();
    }



    public void searchBook(String query) {
        ArrayList<Author> resultsAuthor = new ArrayList<>();
        for (Author author : authorsInSystem) {
            if (author.getFirstName().equals(query.trim())) {
                resultsAuthor.add(author);
            }
        }
        if (resultsAuthor.size() == 0) {
            ArrayList<Book> resultsBook = new ArrayList<>();
            for (Book book : booksInSystem) {
                if (book.getTitle().contains(query.trim())) {
                    resultsBook.add(book);
                }
            }
            if (resultsBook.size() == 0) {
                bookSysDisplayInfo("Not found 404");
                return;
            } else {
                String info = "";
                for (Book book : resultsBook) {
                    BookAuthorRecord bookAuthorRecord = null;
                    for (BookAuthorRecord record : bookAuthorRecordsInSystem) {
                        if (record.getBookId().equals(book.getId())) {
                            bookAuthorRecord = record;
                            break;
                        }
                    }
                    BookLocationRecord bookLocationRecord = null;
                    for (BookLocationRecord record : bookLocationRecordsInSystem) {
                        if (record.getBookId().equals(book.getId())) {
                            bookLocationRecord = record;
                            break;
                        }
                    }
                    Author author = null;
                    for (Author au : authorsInSystem) {
                        if (au.getId().equals(bookAuthorRecord.getAuthorId())) {
                            author = au;
                            break;
                        }
                    }
                    Location location = null;
                    for (Location lo : locationsInSystem) {
                        if (lo.getId().equals(bookLocationRecord.getLocationId())) {
                            location = lo;
                            break;
                        }
                    }

                    info += book.toString() + "\n" + author.toString() + "\n" + location.toString() + "\n";
                }
                bookSysDisplayInfo(info);
            }
        } else {
            String info = "";
            for (Author au : resultsAuthor) {
                Book bookOfAuthor = null;
                for (BookAuthorRecord record : bookAuthorRecordsInSystem) {
                    if (record.getAuthorId().equals(au.getId())) {
                        for (Book book : booksInSystem) {
                            if (book.getId().equals(record.getBookId())) {
                                bookOfAuthor = book;
                                break;
                            }
                        }
                        break;
                    }
                }

                Location locationOfBookFromAuthor = null;
                for (BookLocationRecord record : bookLocationRecordsInSystem) {
                    if (record.getBookId().equals(bookOfAuthor.getId())) {
                        for (Location location : locationsInSystem) {
                            if (location.getId().equals(record.getLocationId())) {
                                locationOfBookFromAuthor = location;
                                break;
                            }
                        }
                        break;
                    }
                }

                info += bookOfAuthor.toString() + "\n" + au.toString()
                        + "\n" + locationOfBookFromAuthor.toString() + "\n";
            }
            bookSysDisplayInfo(info);
        }

    }
    public void bookSysOpenSearchGUI() {
        bookQueryGUI.startBookQueryGUI();
    }

    public void bookSysDisplayInfo(String info) {
        bookInfoDisplayGUI.displayInfoOnGUI(info);
    }

    public void registerBook(String[] bookInfo) {
        bookInfo[6] = bookInfo[6].trim();
        String[] authorDetails = bookInfo[6].split(" ");
        Book bookToRegister = new Book(booksInSystem.size() + "", bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4], bookInfo[5]);
        booksInSystem.add(bookToRegister);

        Author authorToRegister = new Author(authorsInSystem.size() + "", authorDetails[0], authorDetails[1], authorDetails[2], authorDetails[3]);
        authorsInSystem.add(authorToRegister);
        Location locationToRegister = new Location(locationsInSystem.size() + "", bookInfo[7], bookInfo[8], bookInfo[9]);
        locationsInSystem.add(locationToRegister);
        BookAuthorRecord bookAuthorRecordToRegister = new BookAuthorRecord(bookAuthorRecordsInSystem.size() + "", bookToRegister.getId(), authorToRegister.getId(), "1");
        bookAuthorRecordsInSystem.add(bookAuthorRecordToRegister);
        BookLocationRecord bookLocationToRegister = new BookLocationRecord(bookLocationRecordsInSystem.size() + "", bookToRegister.getId(), locationToRegister.getId());
        bookLocationRecordsInSystem.add(bookLocationToRegister);

        bookSysDisplayInfo(bookToRegister.toString() + "\n" + authorToRegister.toString() + "\n" + locationToRegister.toString());
    }

}
