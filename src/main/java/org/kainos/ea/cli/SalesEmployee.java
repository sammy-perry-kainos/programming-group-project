package org.kainos.ea.cli;

public class SalesEmployee extends Employee{
    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    private double commision;

    public SalesEmployee(String name, double salary, String bankNumber, String NI,double commission) {
        super(name, salary, bankNumber, NI);
        this.commision = commission;
    }
}
