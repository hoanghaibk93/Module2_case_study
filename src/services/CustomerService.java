package services;

import models.Customer;
import services.enumfile.TypeOfCustomer;
import utils.ReadWriteFile;

import java.util.LinkedList;
import java.util.List;

public class CustomerService implements ICustomerService {
    private static final String PATH_FILE_CUSTOMER = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\customer.csv";

    private static List<Customer> listCustomer = ReadWriteFile.readFileCustomer(PATH_FILE_CUSTOMER);
//    static {
//        Customer customer1 = new Customer(1,"Hoang Duy","06/11/2000","Nam",191794672,"0911833574","hoangduy@gmail.com", TypeOfCustomer.Diamond.name(),"Hue");
//        Customer customer2 = new Customer(3,"Pham Anh","06/11/1990","Nu",191794892,"0911833897","hoanganh@gmail.com", TypeOfCustomer.Silver.name(), "Ha Noi");
//        Customer customer3 = new Customer(2,"Quang Vu","06/11/1895","Nam",191794267,"0911833900","hoangvu@gmail.com", TypeOfCustomer.Gold.name(), "Quang tri");
//        listCustomer.add(customer1);
//        listCustomer.add(customer2);
//        listCustomer.add(customer3);
//        ReadWriteFile.writeFileCustomer(PATH_FILE_CUSTOMER,listCustomer);
//    }

    @Override
    public List<Customer> displayCustomer() {
        return listCustomer;
    }

    @Override
    public void addCustomer(Customer customer) {
        listCustomer.add(customer);
        ReadWriteFile.writeFileCustomer(PATH_FILE_CUSTOMER,listCustomer);
    }

    @Override
    public boolean editCustomer(int idCustomer, Customer newCustomer) {
        for(Customer editCustomer : listCustomer){
            if(editCustomer.getId()==idCustomer){
                System.out.println(editCustomer);
                listCustomer.set(listCustomer.indexOf(editCustomer),newCustomer);
                ReadWriteFile.writeFileCustomer(PATH_FILE_CUSTOMER,listCustomer);
                return true;
            }
        }
        return false;
    }
}
