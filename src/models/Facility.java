package models;

public abstract class Facility {
    private  String serviceName;
    private int useableArea;
    private double price;
    private int maximumPerson;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceName, int useableArea, double price, int maximumPerson, String rentalType) {
        this.serviceName = serviceName;
        this.useableArea = useableArea;
        this.price = price;
        this.maximumPerson = maximumPerson;
        this.rentalType = rentalType;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getUseableArea() {
        return useableArea;
    }

    public void setUseableArea(int useableArea) {
        this.useableArea = useableArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaximumPerson() {
        return maximumPerson;
    }

    public void setMaximumPerson(int maximumPerson) {
        this.maximumPerson = maximumPerson;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceName='" + serviceName + '\'' +
                ", useableArea=" + useableArea +
                ", price=" + price +
                ", maximumPerson=" + maximumPerson +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
