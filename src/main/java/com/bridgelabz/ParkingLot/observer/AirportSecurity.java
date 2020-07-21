package com.bridgelabz.ParkingLot.observer;

public class AirportSecurity implements Observer {
      private boolean isParkingLotFull;

      @Override
      public void parkingLotFull(boolean isParkingLotFUll) {
            this.isParkingLotFull = isParkingLotFUll;
      }

      public boolean isParkingLotFull() {
            return isParkingLotFull;
      }
}
