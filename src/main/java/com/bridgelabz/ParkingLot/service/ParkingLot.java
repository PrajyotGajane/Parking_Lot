package com.bridgelabz.ParkingLot.service;

import com.bridgelabz.ParkingLot.exception.ParkingLotException;

import java.util.HashMap;

public class ParkingLot {
      HashMap<String, String> isVehicleParked = new HashMap<>();
      private int sizeOfParkingLot;

      public boolean parkedVehicle(String vehicleNumber, String owner) throws ParkingLotException {
            if (isVehicleParked.containsKey(vehicleNumber))
                  throw new ParkingLotException("Already Parked", ParkingLotException.ExceptionType.ALREADY_PARKED);
            if (ownerKnowsIsFull())
                  throw new ParkingLotException("Parking Lot Full", ParkingLotException.ExceptionType.PARKING_LOT_FULL);
            isVehicleParked.put(vehicleNumber, owner);
            return isVehicleParked.containsKey(vehicleNumber);
      }

      public boolean unparkVehicle(String vehicleNumber) throws ParkingLotException {
            if (!isVehicleParked.containsKey(vehicleNumber))
                  throw new ParkingLotException("Vehicle not present in lot",
                          ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
            isVehicleParked.remove(vehicleNumber);
            return isVehicleParked.containsKey(vehicleNumber);
      }

      public boolean ownerKnowsIsFull() {
            if (isVehicleParked.size() == sizeOfParkingLot) {

                  return true;
            }
            return false;
      }

      public void parkinLotSize(int size) {
            this.sizeOfParkingLot = size;
      }
}
