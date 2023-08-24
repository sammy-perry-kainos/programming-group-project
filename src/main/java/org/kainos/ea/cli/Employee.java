package org.kainos.ea.cli;

public class Employee {
    private String name;
    private Double salary;

    public Employee(String name, Double salary, String bankNumber, String NI) {
        this.name = name;
        this.salary = salary;
        this.bankNumber = bankNumber;
        this.NI = NI;
    }

    private String bankNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getNI() {
        return NI;
    }

    public void setNI(String NI) {
        this.NI = NI;
    }

    private String NI;


}
