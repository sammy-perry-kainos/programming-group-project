package org.kainos.ea.db;

import org.kainos.ea.cli.DeliveryEmployee;
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

    public DeliveryEmployee getDeliveryEmployeeById(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT DeliveryEmployeeID, Name, Salary, BankAccountNumber, NationalInsuranceNumber FROM DeliveryEmployees WHERE DeliveryEmployeeID =" + id);

        while(rs.next()){
            return new DeliveryEmployee(
                    rs.getInt("DeliveryEmployeeID"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber")
            );
        }
        return null;
    }

    public void updateDeliveryEmployee(int id, DeliveryRequest deliveryRequest) throws SQLException{
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE DeliveryEmployees SET Name = ?, Salary = ?, BankAccountNumber = ? WHERE DeliveryEmployeeID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, deliveryRequest.getName());
        st.setDouble(2,deliveryRequest.getSalary());
        st.setString(3, deliveryRequest.getBankNumber());
        st.setInt(4, id);

        st.executeUpdate();
    }

}
