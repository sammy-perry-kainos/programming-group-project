package org.kainos.ea.core;

import org.joda.time.DateTime;
import org.kainos.ea.cli.ProjectRequestAddClient;
import org.kainos.ea.db.ClientDao;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;

public class ProjectValidator {

    private ClientDao clientDao = new ClientDao();
    private ProjectDao projectDao = new ProjectDao();

    public String isValidProject(int id, ProjectRequestAddClient project) {
        try {
            if (!clientDao.validateClientId(project.getClientId())) {
                return "ClientID must exist in Client table";
            }

            if (projectDao.getProjectById(id) == null) {
                return "ProjectID must exist in Project table";
            }

            return null;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return null;
    }
}
