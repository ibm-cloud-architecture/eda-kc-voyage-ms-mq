package ibm.gse.voyagems.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Voyage {
    public static final String VOYAGE_TERMINATED = "VOYAGE_TERMINATED";
    public static final String VOYAGE_INTRANSIT = "VOYAGE_INTRANSIT";
    public static final String VOYAGE_CANCELLED = "VOYAGE_CANCELLED";
    public static final String VOYAGE_PENDING = "VOYAGE_PENDING";

    public String voyageID;
    public String origin;
    public String destination;
    public String departureDate;
    public String expectedArrivalDate;
    public String status = VOYAGE_PENDING;
    public List<String> orderIDs = new ArrayList<String>();


    public Voyage() {}

    public Voyage(String vid, String oid) {
        this.voyageID = vid;
        this.orderIDs.add(oid);
    }

    public Voyage (Voyage voyage) {
        this.voyageID = voyage.voyageID;
        this.orderIDs = new ArrayList<>();
        orderIDs.addAll(voyage.orderIDs);
    }

    public void addOrder(String oid) {
        this.orderIDs.add(oid);
    }

    public void removeOrder(String oid) {
        this.orderIDs.remove(oid);
    }

}
