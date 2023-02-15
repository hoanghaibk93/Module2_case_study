package models;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private int bookingReference;
    private String serviceID;
    private String startDate;
    private String endDate;
    private int id;
    private String typeOfService;

    public Booking() {
    }

    public Booking(int bookingReference, String serviceID, String startDate, String endDate, int id, String typeOfService) {
        this.bookingReference = bookingReference;
        this.serviceID = serviceID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.id = id;
        this.typeOfService = typeOfService;
    }

    public int getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(int bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingReference=" + bookingReference +
                ", serviceID='" + serviceID + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", id=" + id +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        Date date1 = null;
        Date date2 = null;
        Date date3 = null;
        Date date4 = null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse(this.getStartDate());
            date2 = new SimpleDateFormat("dd/MM/yyyy").parse(o.getStartDate());
            date3 = new SimpleDateFormat("dd/MM/yyyy").parse(this.getEndDate());
            date4 = new SimpleDateFormat("dd/MM/yyyy").parse(o.getEndDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (!date1.equals(date2)) {
            return date1.compareTo(date2);
        } else if (!date3.equals(date4)) {
            return date3.compareTo(date4);
        } else {
            return this.getBookingReference() - o.getBookingReference();
        }

    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate);
    }
}
