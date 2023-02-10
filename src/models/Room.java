package models;

public class Room extends Facility {
    private String freeService;

    public Room() {

    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(String serviceName, int useableArea, double price, int maximumPerson, String rentalType, String freeService) {
        super(serviceName, useableArea, price, maximumPerson, rentalType);
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
