package com.bridgelabz.ParkingLot.observer;

import java.util.HashMap;

public class Owner implements Observer {
      private boolean isParkingLotFull;

      @Override
      public void parkingLotFull(boolean isParkingLotFull) {
            this.isParkingLotFull = isParkingLotFull;
      }

      public boolean isParkingLotFull() {
            return isParkingLotFull;
      }

      public Integer getSpot(HashMap<Integer, String> parkingSpotMap) {
            for (int i = 0; i <= parkingSpotMap.size(); i++) {
                  if (parkingSpotMap.get(i) == null)
                        return i;
            }
            return null;
      }
}
