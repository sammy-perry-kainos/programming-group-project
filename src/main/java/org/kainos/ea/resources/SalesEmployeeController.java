package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.SalesEmployeeService;
import org.kainos.ea.cli.SalesRequest;
import org.kainos.ea.client.FailedToCreateSalesException;
import org.kainos.ea.client.InvalidSalesEmployeeException;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.DatabaseConnector;
import org.kainos.ea.db.SalesDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Api("Team SCM SalesEmployee API")
@Path("/api")
public class SalesEmployeeController {

    private final SalesEmployeeService salesEmployeeService = new SalesEmployeeService(new SalesDao(new DatabaseConnector()), new SalesEmployeeValidator());

    @POST
    @Path("/SalesEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesRequest employee){
        try{
            int id = salesEmployeeService.createSales(employee);
            return Response.status(Response.Status.CREATED).entity(id).build();
        } catch (FailedToCreateSalesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        } catch (InvalidSalesEmployeeException e) {
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
