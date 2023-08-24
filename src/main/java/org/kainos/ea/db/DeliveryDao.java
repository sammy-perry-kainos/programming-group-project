package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryRequest;

import java.sql.*;

public class DeliveryDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();


    public int createDeliveryEmployee(DeliveryRequest deliveryRequest) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO DeliveryEmployees (Name, Salary, BankAccountNumber, NationalInsuranceNumber) VALUES (?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, deliveryRequest.getName());
        st.setDouble(2, deliveryRequest.getSalary());
        st.setString(3, deliveryRequest.getBankNumber());
        st.setString(4, deliveryRequest.getNI());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }
}
