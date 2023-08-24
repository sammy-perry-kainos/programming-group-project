package org.kainos.ea.api;

import org.kainos.ea.cli.ProjectRequestAddClient;
import org.kainos.ea.client.FailedToUpdateProjectException;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public void addClientToProject (int id, ProjectRequestAddClient project) throws FailedToUpdateProjectException
    {
        try {
            projectDao.addClientToProject(id, project);
        } catch (SQLException e) {
            System.err.println(e.getMessage());

            throw new FailedToUpdateProjectException();
        }
    }
}
