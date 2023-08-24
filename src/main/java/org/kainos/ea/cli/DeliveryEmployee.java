package org.kainos.ea.cli;

public class DeliveryEmployee extends Employee{
    @Override
    public int getEmployeeID() {
        return EmployeeID;
    }

    @Override
    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    private int EmployeeID;
    public DeliveryEmployee(int EmployeeID, String name, Double salary, String bankNumber, String NI) {
        super(EmployeeID, name, salary, bankNumber, NI);
    }

}
