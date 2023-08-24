package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.ProjectService;
import org.kainos.ea.cli.ProjectRequestAddClient;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Programming Group Project - Project API")
@Path("/api")
public class ProjectController {
    private ProjectService projectService = new ProjectService();

    @PUT
    @Path("/project/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addClientToProject(@PathParam("projectId") int projectId,
                                       ProjectRequestAddClient project) {
        projectService.addClientToProject(projectId, project);

        return Response.ok().build();
    }
}
