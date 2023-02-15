package models;

import java.util.Comparator;

public class BookingById implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getBookingReference() - o2.getBookingReference();
    }
}
