package com.bridgelabz.ParkingLot.exception;

public class ParkingLotException extends Exception {
      public ExceptionType type;

      public enum ExceptionType {
            ALREADY_PARKED
      }

      public ParkingLotException(String message, ExceptionType type) {
            super(message);
            this.type = type;
      }
}