package com.bridgelabz.ParkingLot.service;

import java.util.HashMap;

public class ParkAttendant {
      public HashMap<Integer, String> attendantParkedVehicle(int spot, String vehicleNumber, HashMap<Integer, String> parkingSpotMap) {
            parkingSpotMap.putIfAbsent(spot, vehicleNumber);
            return parkingSpotMap;
      }
}
