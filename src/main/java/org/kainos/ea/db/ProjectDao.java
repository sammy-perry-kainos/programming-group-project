package org.kainos.ea.db;

import org.kainos.ea.cli.Project;
import org.kainos.ea.cli.ProjectRequestAddClient;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.*;

public class ProjectDao {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public void addClientToProject(int id, ProjectRequestAddClient project)
            throws SQLException {
        Connection c = databaseConnector.getConnection();

        System.out.println(id);
        System.out.println(project.getClientId());

        String updateStatement ="UPDATE Projects SET ClientID = ? WHERE ProjectID = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, project.getClientId());
        st.setInt(2, id);

        st.executeUpdate();
    }

    public Project getProjectById(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();

        Statement st = c.createStatement();

        ResultSet rs = st.executeQuery("SELECT ProjectID, Name, Value, TechLead, ClientID"
                + " FROM Projects WHERE ProjectID=" + id);

        while (rs.next()) {
            return new Project(
                    rs.getInt("ProjectID"),
                    rs.getString("Name"),
                    rs.getDouble("Value"),
                    rs.getInt("TechLead"),
                    rs.getInt("ClientID")
            );
        }

        return null;
    }
}
