package com.bridgelabz.ParkingLot;

import java.util.HashMap;

public class ParkingLot {
      HashMap<String, String> isVehicleParked = new HashMap<>();

      public boolean parkedVehicle(String vehicleNumber, String carType) {
            isVehicleParked.put(vehicleNumber, carType);
            return isVehicleParked.containsKey(vehicleNumber);
      }

      public boolean unparkVehicle(String vehicleNumber) {
            isVehicleParked.remove(vehicleNumber);
            return isVehicleParked.containsKey(vehicleNumber);
      }
}