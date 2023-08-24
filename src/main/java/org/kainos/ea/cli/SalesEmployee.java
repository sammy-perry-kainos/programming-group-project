package org.kainos.ea.cli;

public class SalesEmployee extends Employee{
    public double getCommision() {
        return commision;
    }

    public void setCommision(double commision) {
        this.commision = commision;
    }

    private Double commision;

    @Override
    public int getEmployeeID() {
        return EmployeeID;
    }

    @Override
    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    private int EmployeeID;

    public SalesEmployee(int EmployeeID, String name, double salary, String bankNumber, String NI,double commission) {
        super(EmployeeID,name, salary, bankNumber, NI);
        this.commision = commission;
    }
}
