package org.kainos.ea.resources;

import io.swagger.annotations.Api;
import org.kainos.ea.api.DeliveryService;
import org.kainos.ea.cli.DeliveryRequest;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.client.FailedToCreateDeliveryEmployeeeException;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Api("Team SCM DeliveryEmployee API")
@Path("/api")
public class DeliveryController {
    private DeliveryService deliveryService = new DeliveryService();


    @POST
    @Path("/deliveryemployees")
    @Produces(MediaType.APPLICATION_JSON)

    public Response createDeliveryEmployee(DeliveryRequest deliveryRequest) {
        try {
            return Response.ok(deliveryService.createDeliveryEmployee(deliveryRequest)).build();
        }catch(FailedToCreateDeliveryEmployeeeException e){
            System.err.println(e.getMessage());

            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/deliveryemployees/{id}")
    @Produces(MediaType.APPLICATION_JSON)

    public Response updateDeliveryEmployee(@PathParam("id") int id, DeliveryRequest deliveryRequest){
        try{
            deliveryService.updateDeliveryEmployee(id, deliveryRequest);
            return Response.ok().build();
        } catch (DeliveryEmployeeDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
