package models;

public class Villa extends Facility {
    private String standardRoom;
    private double poolArea;
    private int numberOfFloor;

    public Villa() {
    }

    public Villa(String standardRoom, double poolArea, int numberOfFloor) {
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String serviceID, String serviceName, double useableArea, double price, int maximumPerson, String rentalType, String standardRoom, double poolArea, int numberOfFloor) {
        super(serviceID, serviceName, useableArea, price, maximumPerson, rentalType);
        this.standardRoom = standardRoom;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString() +
                "standardRoom='" + standardRoom + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
