package com.captraining.exception;

public class InvalidAppointmentException extends Exception {
    public InvalidAppointmentException(String message) {
        super(message);
    }

    public InvalidAppointmentException(String message, Throwable cause) {
        super(message, cause);
    }
}
