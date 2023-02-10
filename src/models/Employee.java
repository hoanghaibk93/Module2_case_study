package models;

public class Employee extends Person {
    private String lever;
    private String position;
    public double salary;

    public Employee() {
    }

    public Employee(int id, String name, String dateOfBirth, String gender, long idCard, String phoneNumber, String email) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
    }

    public Employee(String lever, String position, double salary) {
        this.lever = lever;
        this.position = position;
        this.salary = salary;
    }

    public Employee(int id, String name, String dateOfBirth, String gender, long idCard, String phoneNumber, String email, String lever, String position, double salary) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.lever = lever;
        this.position = position;
        this.salary = salary;
    }

    public String getLever() {
        return lever;
    }

    public void setLever(String lever) {
        this.lever = lever;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "lever='" + lever + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
