package org.kainos.ea.db;

import org.kainos.ea.cli.SalesRequest;

import java.sql.*;

public class SalesDao {
    DatabaseConnector databaseConnector;
    public SalesDao(DatabaseConnector databaseConnector){
        databaseConnector = new DatabaseConnector();
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
    }
}
