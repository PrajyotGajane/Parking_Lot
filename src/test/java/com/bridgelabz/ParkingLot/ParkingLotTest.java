package com.bridgelabz.ParkingLot;

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
      public void givenVehicle_WhenParked_ShouldReturnTrue() {
            ParkingLot parkingLot = new ParkingLot();
            boolean isParked = parkingLot.parkedVehicle("GA-08-A-2323", "Prajyot");
            Assert.assertTrue(isParked);
      }

      @Test
      public void givenVehicle_WhenUnparked_ShouldReturnTrue() {
            parkingLot.parkedVehicle("GA-08-A-2323", "Prajyot");
            boolean isUnparked = parkingLot.unparkVehicle("GA-08-A-2323");
            Assert.assertEquals(false, isUnparked);
      }
}
