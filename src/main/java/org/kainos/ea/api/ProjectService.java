package org.kainos.ea.api;

import org.kainos.ea.cli.ProjectRequestAddClient;
import org.kainos.ea.db.ProjectDao;

import java.sql.SQLException;

public class ProjectService {
    private ProjectDao projectDao = new ProjectDao();

    public void addClientToProject(int projectId, ProjectRequestAddClient project)
    {
        try {
            projectDao.addClientToProject(projectId, project);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
