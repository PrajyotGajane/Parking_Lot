package com.bridgelabz.ParkingLot.service;

import com.bridgelabz.ParkingLot.observer.Observer;

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
