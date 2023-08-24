package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProjectRequestAddClient {
    private String name;
    private double value;
    private int techLead;
    private int clientId;

    @JsonCreator
    public ProjectRequestAddClient(
            @JsonProperty("name") String name,
            @JsonProperty("value") double value,
            @JsonProperty("techLead") int techLead,
            @JsonProperty("clientId") int clientId) {
        this.name = name;
        this.value = value;
        this.techLead = techLead;
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getTechLead() {
        return techLead;
    }

    public void setTechLead(int techLead) {
        this.techLead = techLead;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
}
