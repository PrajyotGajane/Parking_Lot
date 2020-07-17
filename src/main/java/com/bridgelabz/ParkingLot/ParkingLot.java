package com.bridgelabz.ParkingLot;

import java.util.HashMap;

public class ParkingLot {
      HashMap<String, String> isVehicleParked = new HashMap<>();

      public boolean parkedVehicle(String vehicleNumber, String owner) {
           isVehicleParked.put(vehicleNumber, owner);
            return isVehicleParked.containsKey(vehicleNumber);
      }
}
