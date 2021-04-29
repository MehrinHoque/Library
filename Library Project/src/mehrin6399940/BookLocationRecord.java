package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */
public class BookLocationRecord implements Serializable {
    private String id;
    private String bookId;
    private String locationId;

    public BookLocationRecord(String id, String bookId, String locationId) {
        this.id = id;
        this.locationId = locationId;
        this.bookId = bookId;
    }

    public String getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public String getLocationId() {
        return locationId;
    }

    @Override
    public String toString() {
        return bookId + ',' + locationId;
    }
}
