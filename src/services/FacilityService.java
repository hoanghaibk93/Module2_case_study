package services;

import libs.NumberOfUsesService;
import models.Facility;
import models.Room;
import models.Villa;
import utils.ReadWriteFile;

import java.util.LinkedHashMap;
import java.util.Map;

public class FacilityService implements IFacilityService {
    private static final String PATH_FILE_VILLA = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\villa.csv";
    private static final String PATH_FILE_ROOM = "D:\\04_hoc_tap2\\codegym\\c1122g1\\FuramaResort\\src\\data\\room.csv";
    //private static Map<Villa, Integer> mapVillaService = ReadWriteFile.readFileVilla(PATH_FILE_VILLA);
    private static Map<Villa, Integer> mapVillaService = NumberOfUsesService.updateVilla();
    //private static Map<Room, Integer> mapRoomService = ReadWriteFile.readFileRoom(PATH_FILE_ROOM);
    private static Map<Room, Integer> mapRoomService = NumberOfUsesService.updateRoom();
   // private static Map<Facility, Integer> mapFacilityService = new LinkedHashMap<>();


//    static {
//        Villa villa1 = new Villa("SVVL-0001", "Pool villa", 320, 2000000, 5, RentalType.RentByDay.name(), "Three Bedrooms", 45, 2);
//        Villa villa2 = new Villa("SVVL-0002", "Garden villa", 220, 1500000, 4, RentalType.RentByMonth.name(), "Two Bedrooms", 50, 3);
//        Villa villa3 = new Villa("SVVL-0004", "Beach front villa", 250, 2500000, 3, RentalType.RentByYear.name(), "Five Bedrooms", 70, 1);
//        Room room1 = new Room("SVRO-0003", "Garden deluxe", 40, 1500000, 2, RentalType.RentByDay.name(), "Free BreakFast");
//        Room room2 = new Room("SVRO-0005", "Beach deluxe", 34, 2000000, 2, RentalType.RentByMonth.name(), "Free Gym");
//        Room room3 = new Room("SVRO-0006", "Presidential suite", 45, 3000000, 3, RentalType.RentByYear.name(), "Free Spa");
//        mapVillaService.put(villa1, 2);
//        mapVillaService.put(villa2, 3);
//        mapVillaService.put(villa3, 5);
//        mapRoomService.put(room1, 1);
//        mapRoomService.put(room2, 3);
//        mapRoomService.put(room3, 3);
//        ReadWriteFile.writeFileVilla(PATH_FILE_VILLA, mapVillaService);
//        ReadWriteFile.writeFileRoom(PATH_FILE_ROOM, mapRoomService);
//    }

    @Override
    public Map<Facility, Integer> displayFacility() {
        Map<Facility, Integer> mapFacilityService = new LinkedHashMap<>();
        mapFacilityService.putAll(mapRoomService);
        mapFacilityService.putAll(mapVillaService);
        return mapFacilityService;
    }

    @Override
    public void addRoom(Room room, int numberOfUses) {
        mapRoomService.put(room, numberOfUses);
        ReadWriteFile.writeFileRoom(PATH_FILE_ROOM, NumberOfUsesService.updateRoom());
    }

    @Override
    public void addVilla(Villa villa, int numberOfUses) {
        mapVillaService.put(villa, numberOfUses);
        //Map<Villa, Integer> mapVillaServiceUpdate = NumberOfUsesService.updateFacility();
        ReadWriteFile.writeFileVilla(PATH_FILE_VILLA, NumberOfUsesService.updateVilla());
    }

    @Override
    public Map<Facility, Integer> displayMaintenanceFacility() {
        Map<Facility, Integer> mapMaintenanceFacility = new LinkedHashMap<>();
        for (Facility facility : displayFacility().keySet())
            if (displayFacility().get(facility) >= 5) {
                mapMaintenanceFacility.put(facility, displayFacility().get(facility));
            }
        return mapMaintenanceFacility;
    }
}
