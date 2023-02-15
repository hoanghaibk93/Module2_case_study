package services;

import models.Booking;
import utils.ReadWriteFile;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class BookingService implements IBookingService {
    private static final String PATH_FILE_BOOKING = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\booking.csv";
    private static TreeSet<Booking> listBooking = ReadWriteFile.readFileBooking(PATH_FILE_BOOKING);

//    static {
//        Booking booking1 = new Booking(001, "SVVL-0002", "04/11/2023", "08/11/2023", 1, "Free coffee");
//        Booking booking2 = new Booking(002, "SVRO-0003", "01/09/2023", "05/09/2023", 2, "Free golf");
//        Booking booking3 = new Booking(003, "SVVL-0004", "01/10/2023", "05/10/2023", 3, "Free gym");
//        listBooking.add(booking1);
//        listBooking.add(booking2);
//        listBooking.add(booking3);
//        ReadWriteFile.writeFileBooking(PATH_FILE_BOOKING, listBooking);
//    }

    @Override
    public TreeSet<Booking> displayBooking() {
        //Collections.sort((List) listBooking,new ComparatorDate());
        return listBooking;
    }

    @Override
    public void addBooking(Booking booking) {
        listBooking.add(booking);
        //Collections.sort((List) listBooking,new ComparatorDate());
        ReadWriteFile.writeFileBooking(PATH_FILE_BOOKING, listBooking);
    }
}
