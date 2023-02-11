package services;

import models.Facility;
import models.Room;
import models.Villa;
import services.enumfile.RentalType;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private static Map<Facility, Integer> mapFacilityService;

    static {
        mapFacilityService = new LinkedHashMap<>();
        Villa villa1 = new Villa("SVVL-0001","Pool villa", 320, 2000000, 5, RentalType.RentByDay.name(), "Three Bedrooms", 20, 2);
        Villa villa2 = new Villa("SVVL-0002","Garden villa", 220, 1500000, 4, RentalType.RentByMonth.name(), "Two Bedrooms", 15, 3);
        Villa villa3 = new Villa("SVVL-0004","Beach front villa", 250, 2500000, 3, RentalType.RentByYear.name(), "Five Bedrooms", 25, 1);
        Room room1 = new Room("SVRO-0003","Garden deluxe", 40, 1500000, 2, RentalType.RentByDay.name(), "Free BreakFast");
        Room room2 = new Room("SVRO-0005","Beach deluxe", 30, 2000000, 2, RentalType.RentByMonth.name(), "Free Gym");
        Room room3 = new Room("SVRO-0006","Presidential suite", 45, 3000000, 3, RentalType.RentByYear.name(), "Free Spa");
        mapFacilityService.put(villa1, 2);
        mapFacilityService.put(villa2, 3);
        mapFacilityService.put(villa3, 5);
        mapFacilityService.put(room1, 1);
        mapFacilityService.put(room2, 3);
        mapFacilityService.put(room3, 3);

    }

    @Override
    public Map<Facility, Integer> displayFacility() {
        return mapFacilityService;
    }

    @Override
    public void addRoom(Room room, int numberOfUses) {
        mapFacilityService.put(room, numberOfUses);
    }

    @Override
    public void addVilla(Villa villa, int numberOfUses) {
        mapFacilityService.put(villa, numberOfUses);
    }

    @Override
    public Map<Facility, Integer> displayMaintenanceFacility() {
        Map<Facility, Integer> mapMaintenanceFacility = new LinkedHashMap<>();
        for (Facility facility : mapFacilityService.keySet())
            if (mapFacilityService.get(facility) == 5) {
                mapMaintenanceFacility.put(facility, mapFacilityService.get(facility));
            }
        return mapMaintenanceFacility;
    }
}
