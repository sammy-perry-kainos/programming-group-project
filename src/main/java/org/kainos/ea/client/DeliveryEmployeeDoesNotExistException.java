package org.kainos.ea.client;

public class DeliveryEmployeeDoesNotExistException extends Throwable {
    @Override
    public String getMessage(){
        return "Delivery Employee doesn't exist";
    }
}
