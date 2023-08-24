package org.kainos.ea.db;

import org.kainos.ea.cli.SalesRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SalesDao {
    DatabaseConnector databaseConnector = new DatabaseConnector();

    public int createSalesEmployee(SalesRequest employee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployee (Name, Salary, BankAccountNumber, NationalInsuranceNumber, CommissionRate) " +
                "VALUES(?, ?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);


    }
}
