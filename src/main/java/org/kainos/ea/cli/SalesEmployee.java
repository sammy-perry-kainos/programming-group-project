package org.kainos.ea.cli;

public class SalesEmployee extends Employee{
    private Double commision;

    public SalesEmployee(String name, Double salary, String bankNumber, String NI,Double commission) {
        super(name, salary, bankNumber, NI);
        this.commision = commission;
    }
}
