package models;

public class Customer extends Person {
    private String typeOfCustomer;
    private String address;

    public Customer() {
    }

    public Customer(String typeOfCustomer, String address) {
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public Customer(int id, String name, String dateOfBirth, String gender, long idCard, String phoneNumber, String email, String typeOfCustomer, String address) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
