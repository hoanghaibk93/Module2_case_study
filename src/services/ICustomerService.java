package services;

import models.Customer;


import java.util.List;

public interface ICustomerService extends IService {
    List<Customer> displayCustomer();
    void addCustomer(Customer customer);
    boolean editCustomer(int idEmployee, Customer newCustomer);
}
