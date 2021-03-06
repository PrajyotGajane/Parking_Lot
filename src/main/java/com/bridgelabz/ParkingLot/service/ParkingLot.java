package com.bridgelabz.ParkingLot.service;

import com.bridgelabz.ParkingLot.exception.ParkingLotException;

import java.util.HashSet;

public class ParkingLot {
      HashSet<String> isVehicleParked = new HashSet<>();
      private int sizeOfParkingLot = 10;
      public Owner owner = new Owner();
      public AirportSecurity airportSecurity = new AirportSecurity();

      public boolean isVehiclePresent(String vehicleNumber) {
            return isVehicleParked.contains(vehicleNumber);
      }

      public void parkedVehicle(String vehicleNumber) throws ParkingLotException {
            if (vehicleNumber == null)
                  throw new ParkingLotException("Invalid Vehicle", ParkingLotException.ExceptionType.INVALID_VEHICLE);
            if (isVehicleParked.contains(vehicleNumber))
                  throw new ParkingLotException("Already Parked", ParkingLotException.ExceptionType.ALREADY_PARKED);
            if (isVehicleParked.size() == sizeOfParkingLot)
                  throw new ParkingLotException("Parking Lot Full", ParkingLotException.ExceptionType.PARKING_LOT_FULL);
            isVehicleParked.add(vehicleNumber);
            if (isVehicleParked.size() == sizeOfParkingLot) {
                  owner.parkingLotFull(true);
                  airportSecurity.parkingLotFull(true);
            }
      }

      public void unparkVehicle(String vehicleNumber) throws ParkingLotException {
            if (!isVehicleParked.contains(vehicleNumber))
                  throw new ParkingLotException("Vehicle not present in lot",
                          ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
            isVehicleParked.remove(vehicleNumber);
            owner.parkingLotFull(false);
      }

      public void parkinLotSize(int size) {
            this.sizeOfParkingLot = size;
      }
}
