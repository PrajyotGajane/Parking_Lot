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

      public void parkedVehicle(int spot, String vehicleNumber) throws ParkingLotException {
            if (vehicleNumber == null)
                  throw new ParkingLotException("Invalid Vehicle", ParkingLotException.ExceptionType.INVALID_VEHICLE);
            if (parkingSpotMap.containsValue(vehicleNumber))
                  throw new ParkingLotException("Already Parked", ParkingLotException.ExceptionType.ALREADY_PARKED);
            if (parkingSpotMap.size() == sizeOfParkingLot)
                  throw new ParkingLotException("Parking Lot Full", ParkingLotException.ExceptionType.PARKING_LOT_FULL);
            parkingSpotMap = parkAttendant.attendantParkedVehicle(spot, vehicleNumber, parkingSpotMap);
            if (parkingSpotMap.size() == sizeOfParkingLot) {
                  notifyAllObservers(true);
            }
      }

      public void notifyAllObservers(boolean status) {
            for (Observer observer : observerList) {
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

      public int vehicleSpotInLot(String vehicelNumber) throws ParkingLotException {
            int spot = parkingSpotMap.keySet()
                    .stream()
                    .filter(key -> vehicelNumber.equals(parkingSpotMap.get(key)))
                    .findFirst().get();
            this.unparkVehicle(vehicelNumber);
            return spot;
      }

      public void parkinLotSize(int size) {
            this.sizeOfParkingLot = size;
      }
}
