package services;

import com.sun.source.tree.Tree;
import models.Booking;

import java.util.TreeSet;

public interface IBookingService extends IService {
    TreeSet<Booking> displayBooking();
    void addBooking(Booking booking);
}
