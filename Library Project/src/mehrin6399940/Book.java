package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class Book implements Serializable {
    private String id;
    private String isbn;
    private String callNumber;
    private String publisher;
    private String status;
    private String title;
    private String abstrc;


    public Book(String id, String isbn, String callNumber, String title, String abstrc, String publisher, String status) {
        this.id = id;
        this.title = title;
        this.abstrc = abstrc;
        this.isbn = isbn;
        this.publisher = publisher;
        this.status = status;
        this.callNumber = callNumber;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAbstrc() {
        return abstrc;
    }

    public String getCallNumber() {
        return callNumber;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return isbn + "," + callNumber + "," + title + "," + abstrc + "," + publisher + "," + status;
    }

}
