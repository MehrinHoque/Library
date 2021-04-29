package mehrin6399940;

import java.io.Serializable;

/**
 * @author Mosammat Mehrin Fatima Hoque
 */

public class Location implements Serializable {
    private String id;
    private String campus;
    private String shelfNumber;
    private String floor;

    public Location(String id, String campus, String floor, String shelfNumber) {
        this.id = id;
        this.floor = floor;
        this.shelfNumber = shelfNumber;
        this.campus = campus;
    }

    public String getId() {
        return id;
    }

    public String getCampus() {
        return campus;
    }

    public String getFloor() {
        return floor;
    }

    @Override
    public String toString() {
        return campus + ',' + floor + ',' + shelfNumber;
    }
}
