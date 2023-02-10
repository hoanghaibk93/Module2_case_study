package services;

import models.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeService extends IService {
    List<Employee> displayEmployee();
    void addEmployee(Employee employee);
    boolean editEmployee(int idEmployee, Employee newEmployee);
    boolean deleteEmployee(int idEmployee);

}
