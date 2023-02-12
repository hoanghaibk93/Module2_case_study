package services;

import models.Employee;
import services.enumfile.Lever;
import services.enumfile.Position;
import utils.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService {

    private static final String PATH_FILE_EMPLOYEE = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\employee.csv";
    private static List<Employee> listEmployee = ReadWriteFile.readFileEmployee(PATH_FILE_EMPLOYEE);

//    static {
//        Employee employee1 = new Employee(1, "Pham Hoang Hai", "04/11/1990", "Nam", 191794551, "0911.899.512", "Hoanghai123@gmail.com", Lever.Master.name(), Position.Director.name(), 400000000);
//        Employee employee2 = new Employee(2, "Tran Thi Tin", "03/10/2000", "Nu", 191794467, "0911.839.512", "thitin@gmail.com", Lever.College.name(), Position.Supervisor.name(), 300000000);
//        Employee employee3 = new Employee(3, "Pham Tran Thao Nguyen", "07/5/2003", "Nu", 191794981, "0911.893.512", "NguyenThao03@gmail.com", Lever.University.name(), Position.Supervisor.name(), 200000000);
//        Employee employee4 = new Employee(6, "Nguyen Bao ky", "04/11/1990", "Nam", 191794891, "0911.819.512", "kybao@gmail.com", Lever.Intermediate.name(), Position.Receptionist.name(), 100000000);
//        Employee employee5 = new Employee(4, "Tran Hong Anh", "04/11/1995", "Nam", 191794354, "0911.899.516", "anhHong456@gmail.com", Lever.University.name(), Position.Expert.name(), 50000000);
//        Employee employee6 = new Employee(5, "Le Quoc Linh", "04/11/2000", "Nam", 191794891, "0911.899.511", "LinhLe90@gmail.com", Lever.College.name(), Position.Supervisor.name(), 40000000);
//        Employee employee7 = new Employee(7, "Phan Van Duc", "04/11/2001", "Nam", 191794571, "0911.709.100", "DucVan567@gmail.com", Lever.Intermediate.name(), Position.Director.name(), 30000000);
//        listEmployee.add(employee1);
//        listEmployee.add(employee2);
//        listEmployee.add(employee3);
//        listEmployee.add(employee4);
//        listEmployee.add(employee5);
//        listEmployee.add(employee6);
//        listEmployee.add(employee7);
//        ReadWriteFile.writeFileEmployee(PATH_FILE_EMPLOYEE, listEmployee);
//    }

    @Override
    public List<Employee> displayEmployee() {
        return listEmployee;
    }

    @Override
    public void addEmployee(Employee employee) {
        listEmployee.add(employee);
        ReadWriteFile.writeFileEmployee(PATH_FILE_EMPLOYEE, listEmployee);
    }

    @Override
    public boolean editEmployee(int idEmployee, Employee newEmployee) {
        for (Employee editEmployee : listEmployee) {
            if (editEmployee.getId() == idEmployee) {
                System.out.println(editEmployee);
                listEmployee.set(listEmployee.indexOf(editEmployee), newEmployee);
                ReadWriteFile.writeFileEmployee(PATH_FILE_EMPLOYEE, listEmployee);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int idEmployee) {
        for (Employee deleteEmployee : listEmployee) {
            if (deleteEmployee.getId() == idEmployee) {
                listEmployee.remove(deleteEmployee);
                    ReadWriteFile.writeFileEmployee(PATH_FILE_EMPLOYEE, listEmployee);
                return true;
            }
        }
        return false;
    }
}
