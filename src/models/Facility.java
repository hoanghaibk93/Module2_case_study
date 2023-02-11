package models;

public abstract class Facility {
    private String serviceID;
    private String serviceName;
    private double useableArea;
    private double price;
    private int maximumPerson;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceID, String serviceName, double useableArea, double price, int maximumPerson, String rentalType) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.useableArea = useableArea;
        this.price = price;
        this.maximumPerson = maximumPerson;
        this.rentalType = rentalType;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUseableArea() {
        return useableArea;
    }

    public void setUseableArea(double useableArea) {
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
                "serviceID='" + serviceID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", useableArea=" + useableArea +
                ", price=" + price +
                ", maximumPerson=" + maximumPerson +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
