package edu.upc.dsa.services;


import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Track;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;
import java.util.List;

@Api(value = "/brotes", description = "Endpoint to Video Service")
@Path("/brotes")



public class BroteService {

    private Covid19Manager cm;

    public BroteService() {

        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.sizeBrotes()==0) {
            this.cm.addBrote("Brote1");
            this.cm.addBrote("Brote2");
            this.cm.addBrote("Brote3");

        }
    }
     /*Las respuestas que se obtienen aqui es como si fuese un if/elseif con los codigos de respuesta posibles
    Es decir, si ha habido exito o no en la peticion*/
    @GET
    @ApiOperation(value = "get all Brotes", notes = "asdasd")
    @ApiResponses(value = {
            //Codigos de respuesta
            @ApiResponse(code = 201, message = "Successful", response = Brote.class, responseContainer="List"),
    })
    @Path("/") //campos de la petición, en este caso esta vacío ya que no necesitamos información necesaria
    @Produces(MediaType.APPLICATION_JSON) //Tipo de archivo
    //Respuesta
    public Response getBrotes() {
        Collection<Brote> brotes = this.cm.brotesDisp();
        GenericEntity<Collection<Brote>> brot = new GenericEntity<Collection<Brote>>(brotes) {};
        return Response.status(201).entity(brot).build()  ;

    }


    @POST
    @ApiOperation(value = "create a new Brote", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Brote.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBrote(Brote brote) {

        if (brote.getIdBrote()==null)  return Response.status(500).entity(brote).build();
        this.cm.addBrote(brote);
        return Response.status(201).entity(brote).build();

    }























}
