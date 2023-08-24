package org.kainos.ea.db;

import org.kainos.ea.cli.ProjectRequestAddClient;
import org.kainos.ea.db.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
