package com.bridgelabz.ParkingLot.observer;

public class Owner implements Observer {
      private boolean isParkingLotFull;

      @Override
      public void parkingLotFull(boolean isParkingLotFull) {
            this.isParkingLotFull = isParkingLotFull;
      }

      public boolean isParkingLotFull() {
            return isParkingLotFull;
      }
}
