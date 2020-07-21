package com.bridgelabz.ParkingLot.service;

import com.bridgelabz.ParkingLot.observer.Owner;

import java.util.HashMap;

public class ParkAttendant {
      public Owner owner = new Owner();
      public HashMap<Integer, String> attendantParkedVehicle(String vehicleNumber, HashMap<Integer, String> parkingSpotMap) {
            parkingSpotMap.put(owner.getSpot(parkingSpotMap), vehicleNumber);
            return parkingSpotMap;
      }
}
