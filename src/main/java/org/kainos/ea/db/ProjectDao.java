package org.kainos.ea.db;

import org.kainos.ea.cli.ProjectRequestAddClient;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProjectDao {

    private DatabaseConnector databaseConnector = new DatabaseConnector();

    public void addClientToProject(int projectId, ProjectRequestAddClient project)
            throws SQLException {
        Connection c = databaseConnector.getConnection();

        String updateStatement ="UPDATE Projects SET ClientId = ? WHERE ProjectId = ?";

        PreparedStatement st = c.prepareStatement(updateStatement);

        st.setInt(1, project.getClientId());
        st.setInt(2, projectId);

        st.executeUpdate();
    }
}
