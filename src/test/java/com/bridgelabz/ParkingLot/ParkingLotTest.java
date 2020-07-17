package com.bridgelabz.ParkingLot;

import com.bridgelabz.ParkingLot.exception.ParkingLotException;
import com.bridgelabz.ParkingLot.service.ParkingLot;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParkingLotTest {
      ParkingLot parkingLot;

      @Before
      public void setUp() {
            parkingLot = new ParkingLot();
      }

      @Test
      public void givenVehicle_WhenParked_ShouldReturnTrue() throws ParkingLotException {
            ParkingLot parkingLot = new ParkingLot();
            boolean isParked = parkingLot.parkedVehicle("GA-08-A-2323", "Prajyot");
            Assert.assertTrue(isParked);
      }
      @Test
      public void givvenVehicle_WhenAlreadyParked_ShouldThrowCustomException() {
            ParkingLot parkingLot = new ParkingLot();
            try {
                  parkingLot.parkedVehicle("GA-08-A-2323", "Prajyot");
                  parkingLot.parkedVehicle("GA-08-A-2323", "Prajyot");
            } catch (ParkingLotException e) {
                  Assert.assertEquals(e.type, ParkingLotException.ExceptionType.ALREADY_PARKED);
            }
      }
}
