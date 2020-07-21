package com.bridgelabz.ParkingLot;

import com.bridgelabz.ParkingLot.exception.ParkingLotException;
import com.bridgelabz.ParkingLot.observer.AirportSecurity;
import com.bridgelabz.ParkingLot.observer.Owner;
import com.bridgelabz.ParkingLot.service.ParkingLot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
      ParkingLot parkingLot;

      @Before
      public void setUp() {
            parkingLot = new ParkingLot(new Owner(), new AirportSecurity());
      }

      @Test
      public void givenVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
            parkingLot.parkedVehicle(1,"GA-08-A-2323");
            boolean isParked = parkingLot.isVehiclePresent("GA-08-A-2323");
            Assert.assertTrue(isParked);
      }

      @Test
      public void givenVehicleNull_WhenParked_ShouldReturnTrue() {
            try {
                  parkingLot.parkedVehicle(1,null);
            } catch (ParkingLotException e) {
                  Assert.assertEquals(e.type, ParkingLotException.ExceptionType.INVALID_VEHICLE);
            }
      }

      @Test
      public void givenVehicle_WhenAlreadyParked_ShouldThrowCustomException() {
            try {
                  parkingLot.parkedVehicle(1,"GA-08-A-2323");
                  parkingLot.parkedVehicle(1,"GA-08-A-2323");
            } catch (ParkingLotException e) {
                  Assert.assertEquals(e.type, ParkingLotException.ExceptionType.ALREADY_PARKED);
            }
      }

      @Test
      public void givenVehicle_WhenUnparked_ShouldReturnTrue() throws ParkingLotException {
            parkingLot.parkedVehicle(1,"GA-08-A-2323");
            parkingLot.unparkVehicle("GA-08-A-2323");
            boolean isUnparked = parkingLot.isVehiclePresent("GA-08-A-2323");
            Assert.assertFalse(isUnparked);
      }

      @Test
      public void givenVehicleToUnpark_WhenNotPresent_ShouldThrowCustomException() {
            try {
                  parkingLot.unparkVehicle("GA-08-A-2323");
            } catch (ParkingLotException e) {
                  Assert.assertEquals(e.type, ParkingLotException.ExceptionType.VEHICLE_NOT_PRESENT);
            }
      }

      @Test
      public void givenParkingLotWithSize_WhenFull_ShouldInformOwnerAndReturnTrue() {
            parkingLot.parkinLotSize(3);
            try {
                  parkingLot.parkedVehicle(1,"GA-08-A-2323");
                  parkingLot.parkedVehicle(2,"MH-08-A-3455");
                  parkingLot.parkedVehicle(3,"GJ-08-A-4567");
                  parkingLot.parkedVehicle(4,"AP-08-A-4557");
            } catch (ParkingLotException e) {
                  Assert.assertEquals(e.type, ParkingLotException.ExceptionType.PARKING_LOT_FULL);
            }
      }

      @Test
      public void givenParkingLotWithSize_WhenFullInformOwner_ShouldInformOwnerAndReturnTrue() throws ParkingLotException {
            parkingLot.parkinLotSize(3);
            parkingLot.parkedVehicle(1,"GA-08-A-2323");
            parkingLot.parkedVehicle(2,"MH-08-A-3455");
            parkingLot.parkedVehicle(3,"GJ-08-A-4567");
            boolean informedOwner = parkingLot.owner.isParkingLotFull();

            Assert.assertTrue(informedOwner);
      }

      @Test
      public void givenParkingLotWithSize_WhenFullInformAirportSecurity_ShouldInformOwnerAndReturnTrue() throws ParkingLotException {
            parkingLot.parkinLotSize(3);
            parkingLot.parkedVehicle(1,"GA-08-A-2323");
            parkingLot.parkedVehicle(2,"MH-08-A-3455");
            parkingLot.parkedVehicle(3,"GJ-08-A-4567");
            boolean informedAirportSecuirty = parkingLot.airportSecurity.isParkingLotFull();
            Assert.assertTrue(informedAirportSecuirty);
      }

      @Test
      public void givenParkingLotWithSize_WhenSpaceAvailableInformOwner_ShouldInformOwnerAndReturnTrue() throws ParkingLotException {
            parkingLot.parkinLotSize(10);
            parkingLot.parkedVehicle(1,"GA-08-A-2323");
            parkingLot.parkedVehicle(2,"GJ-08-A-4567");
            parkingLot.unparkVehicle("GJ-08-A-4567");
            parkingLot.parkedVehicle(2,"MH-08-A-4567");
            parkingLot.parkedVehicle(3,"TN-08-A-4567");
            parkingLot.parkedVehicle(4,"KL-08-A-4567");
            boolean informedOwner = parkingLot.owner.isParkingLotFull();
            Assert.assertFalse(informedOwner);
      }

      @Test
      public void givenVehicleSpotAndNumberToParkingAttendant_WhenParkedInSlot_ShouldReturnTrue()
              throws ParkingLotException {
            parkingLot.parkedVehicle(1, "MH-32-AW-4348");
            boolean isPresent = parkingLot.isVehiclePresent("MH-32-AW-4348");
            Assert.assertTrue(isPresent);
      }

      @Test
      public void givenParkedVehicle_WhenFound_ShouldReturnSpotInParkingLot() throws ParkingLotException {
            parkingLot.parkedVehicle(1,"GA-08-A-2323");
            parkingLot.parkedVehicle(2,"GJ-08-A-4567");
            parkingLot.parkedVehicle(3,"MH-08-A-4567");
            int position = parkingLot.vehicleSpotInLot("MH-08-A-4567");
            Assert.assertEquals(3, position);
      }
}
