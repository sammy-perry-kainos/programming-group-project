package org.kainos.ea.client;

public class FailedToGetDeliveryEmployeeException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to create new delivery employee in database";
    }
}
