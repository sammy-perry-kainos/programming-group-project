package org.kainos.ea.db;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientDao {
    private DatabaseConnector databaseConnector;

    public ClientDao(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public boolean validateClientId(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();

        // Valid request
        ResultSet rs = st.executeQuery("SELECT COUNT(ClientID) FROM Clients WHERE ClientID=" + id);

        while (rs.next()) {
            if (rs.getInt("COUNT(ClientID)") > 0) {
                return true;
            }
        }

        return false;
    }
}
