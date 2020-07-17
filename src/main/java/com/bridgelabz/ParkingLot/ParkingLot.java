package com.bridgelabz.ParkingLot;

import java.util.HashMap;

public class ParkingLot {
      HashMap<String, String> isVehicleParked = new HashMap<>();

<<<<<<< HEAD
      public boolean parkedVehicle(String vehicleNumber, String carType) {
            isVehicleParked.put(vehicleNumber, carType);
            return isVehicleParked.containsKey(vehicleNumber);
      }

      public boolean unparkVehicle(String vehicleNumber) {
            isVehicleParked.remove(vehicleNumber);
=======
      public boolean parkedVehicle(String vehicleNumber, String owner) {
           isVehicleParked.put(vehicleNumber, owner);
>>>>>>> UC_1_Parking_Cars
            return isVehicleParked.containsKey(vehicleNumber);
      }
}
