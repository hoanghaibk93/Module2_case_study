package controllers;

import models.Customer;
import models.Employee;
import services.CustomerService;
import services.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class FuramaController {
    private static EmployeeService employeeService = new EmployeeService();
    private static CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        int select = 0;
        do {
            System.out.println("------Furama Resort Management------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Enter your choice");
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
                                if (employeeService.deleteEmployee(deleteId)) {
                                    System.out.println("This employee has been delete");
                                } else {
                                    System.out.println("Find not found ");
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
                    System.out.println("------Facility Management------");
                    System.out.println("1. Display list facility");
                    System.out.println("2. Add new facility");
                    System.out.println("3. Display list facility maintenance");
                    System.out.println("4. Return main menu");
                    break;
                case 4:
                    System.out.println("------Booking Management------");
                    System.out.println("1. Add new booking");
                    System.out.println("2. Display list booking");
                    System.out.println("3. Return main menu");
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
    }
}
