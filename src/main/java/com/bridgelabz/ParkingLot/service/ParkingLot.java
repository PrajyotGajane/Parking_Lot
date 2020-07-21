package com.bridgelabz.ParkingLot.service;

import com.bridgelabz.ParkingLot.exception.ParkingLotException;
import com.bridgelabz.ParkingLot.observer.AirportSecurity;
import com.bridgelabz.ParkingLot.observer.Observer;
import com.bridgelabz.ParkingLot.observer.Owner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
      public ParkAttendant parkAttendant;
      private List<String> isVehicleParked = new ArrayList<>();
      private HashMap<Integer, String> parkingSpotMap = new HashMap<>();
      private int sizeOfParkingLot = 10;
      public Owner owner;
      public AirportSecurity airportSecurity;
      List<Observer> observerList = new ArrayList<>();

      public boolean isVehiclePresent(String vehicleNumber) {
            return parkingSpotMap.containsValue(vehicleNumber);
      }

      public ParkingLot(Owner owner, AirportSecurity airportSecurity) {
            this.owner = owner;
            this.airportSecurity = airportSecurity;
            this.parkAttendant = new ParkAttendant();
            this.observerList.add(owner);
            this.observerList.add(airportSecurity);
      }

      public void parkedVehicle(String vehicleNumber) throws ParkingLotException {
            if (vehicleNumber == null)
                  throw new ParkingLotException("Invalid Vehicle", ParkingLotException.ExceptionType.INVALID_VEHICLE);
            if (isVehicleParked.contains(vehicleNumber))
                  throw new ParkingLotException("Already Parked", ParkingLotException.ExceptionType.ALREADY_PARKED);
            if (isVehicleParked.size() == sizeOfParkingLot)
                  throw new ParkingLotException("Parking Lot Full", ParkingLotException.ExceptionType.PARKING_LOT_FULL);
            parkingSpotMap = parkAttendant.attendantParkedVehicle(vehicleNumber, parkingSpotMap);
            if (parkingSpotMap.size() == sizeOfParkingLot) {
                 notifyAllObservers(true);
            }
      }

      public void notifyAllObservers(boolean status){
            for (Observer observer : observerList){
                  observer.parkingLotFull(status);
            }
      }

      public void unparkVehicle(String vehicleNumber) throws ParkingLotException {
            Integer key = null;
            if (!parkingSpotMap.containsValue(vehicleNumber))
                  throw new ParkingLotException("Vehicle not present in lot",
                          ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
            for (Map.Entry<Integer, String> entry : parkingSpotMap.entrySet()) {
                  if (entry.getValue().equals(vehicleNumber)) {
                        key = entry.getKey();
                  }
            }
            parkingSpotMap.put(key, null);
            notifyAllObservers(false);
      }

      public void parkinLotSize(int size) {
            this.sizeOfParkingLot = size;
      }
}
