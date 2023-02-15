package services;

import models.Booking;
import models.BookingById;
import models.Customer;

import java.util.*;

public class PromotionService implements IPromotionService {
    private static Calendar calendar = Calendar.getInstance();
    private static Date currentDate = calendar.getTime();
    private static int currentYear = calendar.get(Calendar.YEAR);
    private static int currentMonth = calendar.get(Calendar.MONTH) + 1;
    private static BookingService bookingService = new BookingService();
    private static CustomerService customerService = new CustomerService();
    Scanner scanner = new Scanner(System.in);

    @Override
    public List<Customer> displayCustomerUseServiceByYear(TreeSet<Booking> listBooking, List<Customer> listCustomer, int year) {
        List<Customer> listCustomerUseService = new ArrayList<>();
        for (Customer customer : listCustomer) {
            for (Booking booking : listBooking) {
                int idCustomer = customer.getId();
                int idCustomerUseService = booking.getId();
                int yearUseService = Integer.parseInt(booking.getStartDate().substring(6, 10));
                if ((idCustomer == idCustomerUseService) && (yearUseService == year) && (!listCustomerUseService.contains(customer))) {
                    listCustomerUseService.add(customer);
                }
            }
        }
        return listCustomerUseService;
    }

    @Override
    public List<Customer> displayCustomerUseServiceByMonth(TreeSet<Booking> listBooking, List<Customer> listCustomer) {
        List<Customer> listCustomerUseService = new ArrayList<>();
        for (Customer customer : listCustomer) {
            for (Booking booking : listBooking) {
                int idCustomer = customer.getId();
                int idCustomerUseService = booking.getId();
                int yearUseService = Integer.parseInt(booking.getStartDate().substring(6, 10));
                int monthUseService = Integer.parseInt(booking.getStartDate().substring(3, 5));
                if ((idCustomer == idCustomerUseService) && (monthUseService == currentMonth) && (yearUseService == currentYear) && (!listCustomerUseService.contains(customer))) {
                    listCustomerUseService.add(customer);
                }
            }
        }
        return listCustomerUseService;
    }

    @Override
    public void displayCustomerGetVoucher() {
        System.out.println("Enter number of voucher of 10% promotion");
        int number10 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of voucher of 20% promotion");
        int number20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter number of voucher of 50% promotion");
        int number50 = Integer.parseInt(scanner.nextLine());
        int sumVoucher = number10 + number20 + number50;
        TreeSet<Booking> listBookingById = new TreeSet<>(new BookingById());
        for (Booking booking : bookingService.displayBooking()) {
            listBookingById.add(booking);
        }
        List<Customer> listCustomerService = displayCustomerUseServiceByMonth(listBookingById, customerService.displayCustomer());
        Stack<Customer> stackListCustomer = new Stack<>();
        for (Customer customer : listCustomerService) {
            stackListCustomer.push(customer);
        }
        while (!stackListCustomer.isEmpty()) {
            if (number10 > 0) {
                System.out.println(stackListCustomer.pop() + "have a voucher 10% promotion");
                number10--;
            } else if (number20 > 0) {
                System.out.println(stackListCustomer.pop() + "have a voucher 20% promotion");
                number20--;
            } else if (number50 > 0) {
                System.out.println(stackListCustomer.pop() + "have a voucher 50% promotion");
            } else {
                System.out.println("Not voucher");
            }
        }
    }
}