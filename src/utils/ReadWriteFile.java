package utils;

import models.*;

import java.io.*;
import java.util.*;

public class ReadWriteFile {
    private static final String COMMA = ",";
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;
    private static FileReader fileReader;
    private static BufferedReader bufferedReader;

    public static void writeFileEmployee(String pathFileEmployee, List<Employee> employeeList) {
        try {
            fileWriter = new FileWriter(pathFileEmployee);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                String line = employee.getId() + COMMA + employee.getName() + COMMA + employee.getDateOfBirth() + COMMA + employee.getGeder() + COMMA + employee.getIdCard() + COMMA + employee.getPhoneNumber() + COMMA + employee.getEmail() + COMMA + employee.getLever() + COMMA + employee.getPosition() + COMMA + employee.getSalary();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readFileEmployee(String pathFileEmployee) {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            fileReader = new FileReader(pathFileEmployee);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String arrayLine[] = line.split(COMMA);
                Employee employee = new Employee(Integer.parseInt(arrayLine[0]), arrayLine[1], arrayLine[2], arrayLine[3], Long.parseLong(arrayLine[4]), arrayLine[5], arrayLine[6], arrayLine[7], arrayLine[8], Double.parseDouble(arrayLine[9]));
                listEmployee.add(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }

    public static void writeFileCustomer(String pathFileCustomer, List<Customer> customerList) {
        try {
            fileWriter = new FileWriter(pathFileCustomer);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                String line = customer.getId() + COMMA + customer.getName() + COMMA + customer.getDateOfBirth() + COMMA + customer.getGeder() + COMMA + customer.getIdCard() + COMMA + customer.getPhoneNumber() + COMMA + customer.getEmail() + COMMA + customer.getTypeOfCustomer() + COMMA + customer.getAddress();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readFileCustomer(String pathFileCustomer) {
        List<Customer> listCustomer = new LinkedList<>();
        try {
            fileReader = new FileReader(pathFileCustomer);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String arrayLine[] = line.split(COMMA);
                Customer customer = new Customer(Integer.parseInt(arrayLine[0]), arrayLine[1], arrayLine[2], arrayLine[3], Long.parseLong(arrayLine[4]), arrayLine[5], arrayLine[6], arrayLine[7], arrayLine[8]);
                listCustomer.add(customer);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCustomer;
    }

    public static void writeFileVilla(String pathFileVilla, Map<Villa, Integer> villaList) {
        try {
            fileWriter = new FileWriter(pathFileVilla);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Villa, Integer> entry : villaList.entrySet()) {
                Villa villa = entry.getKey();
                String line = villa.getServiceID() + COMMA + villa.getServiceName() + COMMA + villa.getUseableArea() + COMMA + villa.getPrice() + COMMA + villa.getMaximumPerson() + COMMA + villa.getRentalType() + COMMA + villa.getStandardRoom() + COMMA + villa.getPoolArea() + COMMA + villa.getNumberOfFloor() + COMMA + entry.getValue();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Villa, Integer> readFileVilla(String pathFileVilla) {
        Map<Villa, Integer> listVilla = new LinkedHashMap<>();
        try {
            fileReader = new FileReader(pathFileVilla);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String arrayLine[] = line.split(COMMA);
                Villa villa = new Villa(arrayLine[0], arrayLine[1], Double.parseDouble(arrayLine[2]), Double.parseDouble(arrayLine[3]), Integer.parseInt(arrayLine[4]), arrayLine[5], arrayLine[6], Double.parseDouble(arrayLine[7]), Integer.parseInt(arrayLine[8]));
                listVilla.put(villa, Integer.parseInt(arrayLine[9]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listVilla;
    }

    public static void writeFileRoom(String pathFileRoom, Map<Room, Integer> roomList) {
        try {
            fileWriter = new FileWriter(pathFileRoom);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Map.Entry<Room, Integer> entry : roomList.entrySet()) {
                Room room = entry.getKey();
                String line = room.getServiceID() + COMMA + room.getServiceName() + COMMA + room.getUseableArea() + COMMA + room.getPrice() + COMMA + room.getMaximumPerson() + COMMA + room.getRentalType() + COMMA + room.getFreeService() + COMMA + entry.getValue();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Room, Integer> readFileRoom(String pathFileRoom) {
        Map<Room, Integer> listRoom = new LinkedHashMap<>();
        try {
            fileReader = new FileReader(pathFileRoom);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String arrayLine[] = line.split(COMMA);
                Room room = new Room(arrayLine[0], arrayLine[1], Double.parseDouble(arrayLine[2]), Double.parseDouble(arrayLine[3]), Integer.parseInt(arrayLine[4]), arrayLine[5], arrayLine[6]);
                listRoom.put(room, Integer.parseInt(arrayLine[7]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listRoom;
    }

    public static TreeSet<Booking> readFileBooking(String pathFileBooking) {
        TreeSet<Booking> listBooking = new TreeSet<>();
        try {
            fileReader = new FileReader(pathFileBooking);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String arrayLine[] = line.split(COMMA);
                Booking booking = new Booking(Integer.parseInt(arrayLine[0]), arrayLine[1], arrayLine[2], arrayLine[3], Integer.parseInt(arrayLine[4]), arrayLine[5]);
                listBooking.add(booking);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listBooking;
    }

    public static void writeFileBooking(String pathFileBooking, TreeSet<Booking> bookingList) {
        try {
            fileWriter = new FileWriter(pathFileBooking);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking booking : bookingList) {
                String line = booking.getBookingReference() + COMMA + booking.getServiceID() + COMMA + booking.getStartDate() + COMMA + booking.getEndDate() + COMMA + booking.getId() + COMMA + booking.getTypeOfService();
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
