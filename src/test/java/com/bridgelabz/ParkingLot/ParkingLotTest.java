package com.bridgelabz.ParkingLot;

import org.junit.Assert;
import org.junit.Test;

public class ParkingLotTest {
      @Test
      public void givenVehicle_WhenParked_ShouldReturnTrue() {
            ParkingLot parkingLot = new ParkingLot();
            boolean isParked = parkingLot.parkedVehicle("GA-08-A-2323", "Light");
            Assert.assertTrue(isParked);
      }
}
