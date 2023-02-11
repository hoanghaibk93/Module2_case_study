package services;

import models.Facility;
import models.Room;
import models.Villa;

import java.util.LinkedHashMap;
import java.util.Map;

public interface IFacilityService extends IService{
    Map<Facility,Integer> displayFacility();
    void addRoom(Room room,int numberOfUses);
    void addVilla(Villa villa, int numberOfUses);
    Map<Facility,Integer> displayMaintenanceFacility();
}
