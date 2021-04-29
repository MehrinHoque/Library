package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class BookAuthorRecord implements Serializable {
    private String id;
    private String authorId;
    private String orderOfAuthorInBook;
    private String bookId;

    public BookAuthorRecord(String id, String bookId, String authorId, String orderOfAuthorInBook) {
        this.id = id;
        this.authorId = authorId;
        this.orderOfAuthorInBook = orderOfAuthorInBook;
        this.bookId = bookId;
    }

    public String getOrderOfAuthorInBook() {
        return orderOfAuthorInBook;
    }

    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthorId() {
        return authorId;
    }


    @Override
    public String toString() {
        return bookId + ',' + authorId + ',' + orderOfAuthorInBook;
    }
}
