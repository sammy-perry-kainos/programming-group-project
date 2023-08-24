package org.kainos.ea.db;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesRequest;

import java.sql.*;

public class SalesDao {
    DatabaseConnector databaseConnector;
    public SalesDao(DatabaseConnector databaseConnector){
        databaseConnector = new DatabaseConnector();
    }

    public SalesEmployee getSalesEmployeeByID(int id) throws SQLException{
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT SalesEmployeeID, Name, Salary, BankAccountNumber, NationalInsuranceNumber, Commission FROM SalesEmployees WHERE SalesEmployeeID =" + id);

        while(rs.next()){
            return new SalesEmployee(
                    rs.getInt("SalesEmployeeID"),
                    rs.getString("Name"),
                    rs.getDouble("Salary"),
                    rs.getString("BankAccountNumber"),
                    rs.getString("NationalInsuranceNumber"),
                    rs.getDouble("Commission")
            );
        }

        return null;
    }


    public int createSalesEmployee(SalesRequest employee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO SalesEmployees (Name, Salary, BankAccountNumber, NationalInsuranceNumber, CommissionRate) " +
                "VALUES(?, ?, ?, ?, ?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankNumber());
        st.setString(4, employee.getNI());
        st.setDouble(5, employee.getCommission());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateSales(int id, SalesRequest employee) throws SQLException{
        Connection c = databaseConnector.getConnection();

        String updateStatement = "UPDATE SalesEmployees SET Name = ?, Salary = ?, BankAccountNumber = ? WHERE SalesEmployeeID";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankNumber());
        st.setInt(4, id);

        st.executeUpdate();
    }
}
