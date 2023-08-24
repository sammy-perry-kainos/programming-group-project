package org.kainos.ea.cli;

public class ClientSalesEmployee {
    private String clientName;
    private String salesEmployeeName;

    public ClientSalesEmployee(String clientName, String salesEmployeeName) {
        this.clientName = clientName;
        this.salesEmployeeName = salesEmployeeName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSalesEmployeeName() {
        return salesEmployeeName;
    }

    public void setSalesEmployeeName(String salesEmployeeName) {
        this.salesEmployeeName = salesEmployeeName;
    }
}
