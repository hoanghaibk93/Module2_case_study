package libs;

import com.sun.source.tree.Tree;
import models.Booking;
import models.Facility;
import models.Room;
import models.Villa;
import services.BookingService;
import utils.ReadWriteFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class NumberOfUsesService {
    private static final String PATH_FILE_VILLA = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\villa.csv";
    private static final String PATH_FILE_ROOM = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\room.csv";
    private static BookingService bookingService = new BookingService();
    private static Map<Facility, Integer> mapFacilityService = new LinkedHashMap<>();
    private static Map<Villa, Integer> mapVillaService = ReadWriteFile.readFileVilla(PATH_FILE_VILLA);
    private static Map<Room, Integer> mapRoomService = ReadWriteFile.readFileRoom(PATH_FILE_ROOM);

    private static Calendar calendar = Calendar.getInstance();
    private static Date currentDate = calendar.getTime();
    private static int currentYear = calendar.get(Calendar.YEAR);
    private static int currentMonth = calendar.get(Calendar.MONTH) + 1;
    private static int currentDay = calendar.get(Calendar.DATE);

    public static Map<Villa, Integer> updateVilla() {
        TreeSet<Booking> listBooking = bookingService.displayBooking();
        String dateBooking;
        for (Map.Entry<Villa, Integer> entry : mapVillaService.entrySet()) {
            int count = 0;
            for (Booking booking : listBooking) {
                dateBooking = booking.getStartDate();
                int month = Integer.parseInt(dateBooking.substring(3, 5));
                int year = Integer.parseInt(dateBooking.substring(6, 10));
                if ((currentYear == year) && (currentMonth == month) && entry.getKey().getServiceID().equals(booking.getServiceID())) {
                    count++;
                }
                mapVillaService.put(entry.getKey(), count);
            }
        }
        return mapVillaService;
    }

    public static Map<Room, Integer> updateRoom() {
        TreeSet<Booking> listBooking = bookingService.displayBooking();
        String dateBooking;
        for (Map.Entry<Room, Integer> entry : mapRoomService.entrySet()) {
            int count = 0;
            for (Booking booking : listBooking) {
                dateBooking = booking.getStartDate();
                int month = Integer.parseInt(dateBooking.substring(3, 5));
                int year = Integer.parseInt(dateBooking.substring(6, 10));
                if ((currentYear == year) && (currentMonth == month) && entry.getKey().getServiceID().equals(booking.getServiceID())) {
                    count++;
                }
                mapRoomService.put(entry.getKey(), count);
            }
        }
        return mapRoomService;
    }

    public static int numberOfUses(TreeSet<Booking> bookingTree, String ServiceID) {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        int currentYear = calendar.get(Calendar.YEAR);
        int currentMonth = calendar.get(Calendar.MONTH);
        String dateBooking;
        int numberOfUses = 0;
        for (Booking booking : bookingTree) {
            dateBooking = booking.getStartDate();
            int month = Integer.parseInt(dateBooking.substring(3, 5));
            int year = Integer.parseInt(dateBooking.substring(6, 10));
            String serviceIDBooking = booking.getServiceID();
            if ((currentYear == year) && (currentMonth == month) && (ServiceID.equals(serviceIDBooking))) {
                numberOfUses++;
            }
        }
        return numberOfUses;
    }
}
