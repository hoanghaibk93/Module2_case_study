package controllers;

import libs.NumberOfUsesService;
import models.*;
import services.BookingService;
import services.CustomerService;
import services.EmployeeService;
import services.FacilityService;
import utils.CheckAddNewFacility;
import utils.ReadWriteFile;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class FuramaController {
    private static EmployeeService employeeService = new EmployeeService();
    private static CustomerService customerService = new CustomerService();
    private static FacilityService facilityService = new FacilityService();
    private static CheckAddNewFacility checkAddNewFacility = new CheckAddNewFacility();
    private static BookingService bookingService = new BookingService();
    private static final String PATH_FILE_VILLA = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\villa.csv";
    private static final String PATH_FILE_ROOM = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\room.csv";

    public static void main(String[] args) {
        int select = 0;
        try {
            do {
                System.out.println("------Furama Resort Management------");
                System.out.println("1. Employee Management");
                System.out.println("2. Customer Management");
                System.out.println("3. Facility Management");
                System.out.println("4. Booking Management");
                System.out.println("5. Promotion Management");
                System.out.println("6. Exit");
                System.out.println("Enter your choice, Please!!!");
                Scanner scanner = new Scanner(System.in);
                select = Integer.parseInt(scanner.nextLine());
                boolean flag = true;
                switch (select) {
                    case 1:
                        do {
                            System.out.println("------Employee Management------");
                            System.out.println("1. Display list employees");
                            System.out.println("2. Add new employee");
                            System.out.println("3. Delete employee");
                            System.out.println("4. Edit employee");
                            System.out.println("5. Return main menu");
                            int selectEmployeeManagement = Integer.parseInt(scanner.nextLine());
                            switch (selectEmployeeManagement) {
                                case 1:
                                    List<Employee> listEmployees = employeeService.displayEmployee();
                                    for (Employee employee : listEmployees) {
                                        System.out.println(employee);
                                    }
                                    break;
                                case 2:
                                    System.out.println("You enter a new employee that you need");
                                    System.out.println("Enter id");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Enter name");
                                    String name = scanner.nextLine();
                                    System.out.println("Enter date of birth");
                                    String dateOfBirth = scanner.nextLine();
                                    System.out.println("Enter gender");
                                    String gender = scanner.nextLine();
                                    System.out.println("Enter ID card");
                                    long idCard = Long.parseLong(scanner.nextLine());
                                    System.out.println("Enter phone number");
                                    String phoneNumber = scanner.nextLine();
                                    System.out.println("Enter email");
                                    String email = scanner.nextLine();
                                    System.out.println("Enter lever");
                                    String lever = scanner.nextLine();
                                    System.out.println("Enter position");
                                    String position = scanner.nextLine();
                                    System.out.println("Enter salary");
                                    double salary = Double.parseDouble(scanner.nextLine());
                                    Employee newEmployee = new Employee(id, name, dateOfBirth, gender, idCard, phoneNumber, email, lever, position, salary);
                                    employeeService.addEmployee(newEmployee);
                                    break;
                                case 3:
                                    System.out.println("Enter a id of Employee that you want delete");
                                    int deleteId = Integer.parseInt(scanner.nextLine());
                                    try {
                                        if (employeeService.deleteEmployee(deleteId)) {
                                            System.out.println("This employee has been delete");
                                        } else {
                                            throw new FileNotFoundException("id not exist");
                                        }
                                    } catch (FileNotFoundException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 4:
                                    boolean flagOne = false;
                                    boolean flagTwo = false;
                                    int count = 0;
                                    int oldId;
                                    do {
                                        do {
                                            System.out.println("Enter a id of Employee that you want to edit");
                                            oldId = Integer.parseInt(scanner.nextLine());
                                            List<Employee> editList = employeeService.displayEmployee();
                                            for (Employee editEmployee : editList) {
                                                if (editEmployee.getId() == oldId) {
                                                    count++;
                                                    flagOne = false;
                                                    break;
                                                }
                                            }
                                            if (count == 0) {
                                                System.out.println("This id was not found");
                                                flagOne = true;
                                            }
                                        } while (flagOne);
                                        System.out.println("Enter id you want to edit");
                                        int idEdit = Integer.parseInt(scanner.nextLine());
                                        System.out.println("Enter name you want to edit");
                                        String nameEdit = scanner.nextLine();
                                        System.out.println("Enter date of birth you want to edit");
                                        String dateOfBirthEdit = scanner.nextLine();
                                        System.out.println("Enter gender you want to edit");
                                        String genderEdit = scanner.nextLine();
                                        System.out.println("Enter ID card you want to edit");
                                        long idCardEdit = Long.parseLong(scanner.nextLine());
                                        System.out.println("Enter phone number you want to edit");
                                        String phoneNumberEdit = scanner.nextLine();
                                        System.out.println("Enter email you want to edit");
                                        String emailEdit = scanner.nextLine();
                                        System.out.println("Enter lever you want to edit");
                                        String leverEdit = scanner.nextLine();
                                        System.out.println("Enter position you want to edit");
                                        String positionEdit = scanner.nextLine();
                                        System.out.println("Enter salary you want to edit");
                                        double salaryEdit = Double.parseDouble(scanner.nextLine());
                                        Employee editEmployee = new Employee(idEdit, nameEdit, dateOfBirthEdit, genderEdit, idCardEdit, phoneNumberEdit, emailEdit, leverEdit, positionEdit, salaryEdit);
                                        if (employeeService.editEmployee(oldId, editEmployee)) {
                                            System.out.println("edit success");
                                            flag = true;
                                        } else {
                                            flagTwo = true;
                                        }
                                    } while (flagTwo);
                                    break;
                                case 5:
                                    flag = false;
                                    break;
                            }
                        } while (flag);
                        break;
                    case 2:
                        do {
                            System.out.println("------Customer Management------");
                            System.out.println("1. Display list customers");
                            System.out.println("2. Add new customer");
                            System.out.println("3. Edit customer");
                            System.out.println("4. Return main menu");
                            int selectCustomerManagement = Integer.parseInt(scanner.nextLine());
                            switch (selectCustomerManagement) {
                                case 1:
                                    List<Customer> listCustomer = customerService.displayCustomer();
                                    for (Customer customer : listCustomer) {
                                        System.out.println(customer);
                                    }
                                    break;
                                case 2:
                                    System.out.println("You enter a new Customer that you need");
                                    System.out.println("Enter id");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    System.out.println("Enter name");
                                    String name = scanner.nextLine();
                                    System.out.println("Enter date of birth");
                                    String dateOfBirth = scanner.nextLine();
                                    System.out.println("Enter gender");
                                    String gender = scanner.nextLine();
                                    System.out.println("Enter ID card");
                                    long idCard = Long.parseLong(scanner.nextLine());
                                    System.out.println("Enter phone number");
                                    String phoneNumber = scanner.nextLine();
                                    System.out.println("Enter email");
                                    String email = scanner.nextLine();
                                    System.out.println("Enter typeOfCustomer");
                                    String typeOfCustomer = scanner.nextLine();
                                    System.out.println("Enter address");
                                    String address = scanner.nextLine();
                                    Customer newCustomer = new Customer(id, name, dateOfBirth, gender, idCard, phoneNumber, email, typeOfCustomer, address);
                                    customerService.addCustomer(newCustomer);
                                    break;
                                case 3:
                                    boolean flagOneCustomer = false;
                                    boolean flagTwoCustomer = false;
                                    int countCustomer = 0;
                                    int oldIdCustomer;
                                    do {
                                        do {
                                            System.out.println("Enter a id of Customer that you want to edit");
                                            oldIdCustomer = Integer.parseInt(scanner.nextLine());
                                            List<Customer> editListCustomer = customerService.displayCustomer();
                                            for (Customer editCustomer : editListCustomer) {
                                                if (editCustomer.getId() == oldIdCustomer) {
                                                    countCustomer++;
                                                    flagOneCustomer = false;
                                                    break;
                                                }
                                            }
                                            if (countCustomer == 0) {
                                                System.out.println("This id was not found");
                                                flagOneCustomer = true;
                                            }
                                        } while (flagOneCustomer);
                                        System.out.println("Enter id you want to edit");
                                        System.out.println("Enter id");
                                        int idEdit = Integer.parseInt(scanner.nextLine());
                                        System.out.println("Enter name");
                                        String nameEdit = scanner.nextLine();
                                        System.out.println("Enter date of birth");
                                        String dateOfBirthEdit = scanner.nextLine();
                                        System.out.println("Enter gender");
                                        String genderEdit = scanner.nextLine();
                                        System.out.println("Enter ID card");
                                        long idCardEdit = Long.parseLong(scanner.nextLine());
                                        System.out.println("Enter phone number");
                                        String phoneNumberEdit = scanner.nextLine();
                                        System.out.println("Enter email");
                                        String emailEdit = scanner.nextLine();
                                        System.out.println("Enter typeOfCustomer");
                                        String typeOfCustomerEdit = scanner.nextLine();
                                        System.out.println("Enter address");
                                        String addressEdit = scanner.nextLine();
                                        Customer editCustomer = new Customer(idEdit, nameEdit, dateOfBirthEdit, genderEdit, idCardEdit, phoneNumberEdit, emailEdit, typeOfCustomerEdit, addressEdit);
                                        if (customerService.editCustomer(oldIdCustomer, editCustomer)) {
                                            System.out.println("edit success");
                                            flag = true;
                                        } else {
                                            flagTwoCustomer = true;
                                        }
                                    } while (flagTwoCustomer);
                                    break;
                                case 4:
                                    flag = false;
                                    break;
                            }
                        } while (flag);
                        break;
                    case 3:
                        boolean flagOneFacility = false;
                        do {
                            System.out.println("------Facility Management------");
                            System.out.println("1. Display list facility");
                            System.out.println("2. Add new facility");
                            System.out.println("3. Display list facility maintenance");
                            System.out.println("4. Return main menu");
                            int selectFacilityManagement = Integer.parseInt(scanner.nextLine());
                            switch (selectFacilityManagement) {
                                case 1:
                                    Map<Facility, Integer> mapListFacility = facilityService.displayFacility();
                                    for (Map.Entry<Facility, Integer> entry : mapListFacility.entrySet()) {
                                        System.out.println(entry.getKey() + "-" + entry.getValue());
                                    }
                                    flag = true;
                                    break;
                                case 2:
                                    do {
                                        System.out.println("1. And New Villa");
                                        System.out.println("2. Add New Room");
                                        System.out.println("3. Back to menu");
                                        int selectAddFacility = Integer.parseInt(scanner.nextLine());
                                        switch (selectAddFacility) {
                                            case 1:
                                                String serviceID;
                                                String serviceNameVilla;
                                                double usableAreaVilla;
                                                double priceVilla;
                                                int maximumPersonVilla;
                                                String reatalTypeVilla;
                                                String standardRoomVilla;
                                                double poolAreaVilla;
                                                int numberOfFloorVilla;
                                                int numberOfUsesVilla;
                                                do {
                                                    System.out.println("Enter ID of service");
                                                    serviceID = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkVillaId(serviceID));
                                                do {
                                                    System.out.println("Enter name of service");
                                                    serviceNameVilla = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkNameService(serviceNameVilla));
                                                do {
                                                    System.out.println("Enter usable Area");
                                                    usableAreaVilla = Double.parseDouble(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkArea(String.valueOf(usableAreaVilla)));
                                                do {
                                                    System.out.println("Enter price");
                                                    priceVilla = Double.parseDouble(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkPrice(String.valueOf(priceVilla)));
                                                do {
                                                    System.out.println("Enter maximum Person");
                                                    maximumPersonVilla = Integer.parseInt(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkMaximumPerson(String.valueOf(maximumPersonVilla)));
                                                do {
                                                    System.out.println("Enter type of rental");
                                                    reatalTypeVilla = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkRentalType(reatalTypeVilla));
                                                do {
                                                    System.out.println("Enter standard room");
                                                    standardRoomVilla = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkStandardRoom(standardRoomVilla));
                                                do {
                                                    System.out.println("Enter area of pool");
                                                    poolAreaVilla = Double.parseDouble(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkArea(String.valueOf(poolAreaVilla)));
                                                do {
                                                    System.out.println("Enter number Of floor");
                                                    numberOfFloorVilla = Integer.parseInt(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkNumberOfFloors(String.valueOf(numberOfFloorVilla)));
                                                numberOfUsesVilla = 0;
                                                Villa newVilla = new Villa(serviceID, serviceNameVilla, usableAreaVilla, priceVilla, maximumPersonVilla, reatalTypeVilla, standardRoomVilla, poolAreaVilla, numberOfFloorVilla);
                                                facilityService.addVilla(newVilla, numberOfUsesVilla);
                                                flagOneFacility = true;
                                                break;
                                            case 2:
                                                String serviceIDRoom;
                                                String serviceNameRoom;
                                                double usableAreaRoom;
                                                double priceRoom;
                                                int maximumPersonRoom;
                                                String reatalTypeRoom;
                                                String freeServiceRoom;
                                                int numberOfUsesRoom;
                                                do {
                                                    System.out.println("Enter ID of service");
                                                    serviceIDRoom = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkRoomId(serviceIDRoom));
                                                do {
                                                    System.out.println("Enter name of service");
                                                    serviceNameRoom = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkNameService(serviceNameRoom));
                                                do {
                                                    System.out.println("Enter usable Area");
                                                    usableAreaRoom = Double.parseDouble(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkArea(String.valueOf(usableAreaRoom)));
                                                do {
                                                    System.out.println("Enter price");
                                                    priceRoom = Double.parseDouble(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkPrice(String.valueOf(priceRoom)));
                                                do {
                                                    System.out.println("Enter maximum Person");
                                                    maximumPersonRoom = Integer.parseInt(scanner.nextLine());
                                                } while (!checkAddNewFacility.checkMaximumPerson(String.valueOf(maximumPersonRoom)));
                                                do {
                                                    System.out.println("Enter type of rental");
                                                    reatalTypeRoom = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkRentalType(reatalTypeRoom));
                                                do {
                                                    System.out.println("Enter free service");
                                                    freeServiceRoom = scanner.nextLine();
                                                } while (!checkAddNewFacility.checkNameService(freeServiceRoom));
                                                numberOfUsesRoom = 0;
                                                Room newRoom = new Room(serviceIDRoom, serviceNameRoom, usableAreaRoom, priceRoom, maximumPersonRoom, reatalTypeRoom, freeServiceRoom);
                                                facilityService.addRoom(newRoom, numberOfUsesRoom);
                                                flagOneFacility = true;
                                                break;
                                            case 3:
                                                flagOneFacility = false;
                                                break;
                                        }
                                    } while (flagOneFacility);
                                    break;
                                case 3:
                                    Map<Facility, Integer> mapListMaintenanceFacility = facilityService.displayMaintenanceFacility();
                                    for (Map.Entry<Facility, Integer> entry : mapListMaintenanceFacility.entrySet()) {
                                        System.out.println(entry.getKey() + "-" + entry.getValue());
                                    }
                                    flag = true;
                                    break;
                                case 4:
                                    flag = false;
                                    break;
                            }
                        } while (flag);
                        break;
                    case 4:
                        boolean flagBooking = false;
                        do {
                            System.out.println("------Booking Management------");
                            System.out.println("1. Add new booking");
                            System.out.println("2. Display list booking");
                            System.out.println("3. Return main menu");
                            int selectBooking = Integer.parseInt(scanner.nextLine());
                            switch (selectBooking) {
                                case 1:
                                    System.out.println("You enter a new Booking that you need");
                                    List<Customer> listCustomer = customerService.displayCustomer();
                                    for (Customer customer : listCustomer) {
                                        System.out.println(customer);
                                    }
                                    System.out.println("Enter id of customer");
                                    int id = Integer.parseInt(scanner.nextLine());
                                    Map<Facility, Integer> mapListFacility = facilityService.displayFacility();
                                    for (Map.Entry<Facility, Integer> entry : mapListFacility.entrySet()) {
                                        System.out.println(entry.getKey() + "-" + entry.getValue());
                                    }
                                    System.out.println("Select id of service that you want book");
                                    String idService = scanner.nextLine();
                                    int bookingReference;
                                    boolean flagBookingTwo = true;
                                    do {
                                        System.out.println("Enter reference booking");
                                        bookingReference = Integer.parseInt(scanner.nextLine());
                                        TreeSet<Booking> listBooking = bookingService.displayBooking();
                                        for (Booking booking : listBooking) {
                                            if (booking.getBookingReference() == bookingReference) {
                                                System.out.println("Reference booking is duplicated");
                                                flagBookingTwo = true;
                                                break;
                                            } else {
                                                flagBookingTwo = false;
                                            }
                                        }
                                    } while (flagBookingTwo);
                                    System.out.println("Enter start date");
                                    String startDate = scanner.nextLine();
                                    System.out.println("Enter end date");
                                    String endDate = scanner.nextLine();
                                    System.out.println("Enter type of service");
                                    String typeOfService = scanner.nextLine();
                                    Booking newBooking = new Booking(bookingReference, idService, startDate, endDate, id, typeOfService);
                                    bookingService.addBooking(newBooking);
                                    ReadWriteFile.writeFileVilla(PATH_FILE_VILLA, NumberOfUsesService.updateVilla());
                                    ReadWriteFile.writeFileRoom(PATH_FILE_ROOM, NumberOfUsesService.updateRoom());
                                    flagBooking = true;
                                    break;
                                case 2:
                                    TreeSet<Booking> listBooking = bookingService.displayBooking();
                                    for (Booking booking : listBooking) {
                                        System.out.println(booking);
                                    }
                                    flagBooking = true;
                                    break;
                                case 3:
                                    flagBooking = false;
                                    break;
                            }
                        } while (flagBooking);
                        break;
                    case 5:
                        System.out.println("------Promotion Management------");
                        System.out.println("1. Display list customers use service");
                        System.out.println("2. Display list customers get voucher");
                        System.out.println("Return main menu");
                        break;
                    case 6:
                        System.exit(0);
                        break;
                }
            } while (true);
        } catch (
                NumberFormatException e) {
            System.out.println("Not Number!!!!, Enter again");
        } catch (
                Exception e) {
            e.getMessage();
        }
    }
}
