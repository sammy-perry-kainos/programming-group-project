package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.SalesEmployeeService;
import org.kainos.ea.cli.SalesRequest;
import org.kainos.ea.client.FailedToCreateSalesException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Team SCM SalesEmployee API")
@Path("/api")
public class SalesEmployeeController {

    private final SalesEmployeeService salesEmployeeService = new SalesEmployeeService();

    @POST
    @Path("/SalesEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesRequest employee){
        try{
            return Response.ok(salesEmployeeService.createSales(employee)).build();
        } catch (FailedToCreateSalesException e) {
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }
}