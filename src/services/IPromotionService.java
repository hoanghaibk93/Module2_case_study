package services;

import com.sun.source.util.Trees;
import models.Booking;
import models.Customer;

import java.util.List;
import java.util.TreeSet;

public interface IPromotionService {
    List<Customer> displayCustomerUseServiceByYear(TreeSet<Booking> listBooking, List<Customer> listCustomer, int year);
    List<Customer> displayCustomerUseServiceByMonth(TreeSet<Booking> listBooking, List<Customer> listCustomer);

    void displayCustomerGetVoucher();
}
