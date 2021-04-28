package edu.upc.dsa.services;

import edu.upc.dsa.Covid19Manager;
import edu.upc.dsa.Covid19ManagerImpl;
import edu.upc.dsa.models.Brote;
import edu.upc.dsa.models.Caso;

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
import java.util.Date;
import java.util.List;



//Ruta donde se encuentra el servicio
@Api(value = "/caso", description = "Endpoint to Caso Service")
@Path("/casos")

public class CasoService {


    private Covid19Manager cm;

    public CasoService() {
        this.cm = Covid19ManagerImpl.getInstance();
        if (cm.sizeCasos()==0) {

            Date fechaN = new Date( 1995, 07, 24);
            Date fechaInfo = new Date (2020,11,20);
            this.cm.addCaso("Kevin","Alcalde","caso1",fechaN,fechaInfo,"noCaso","Masculino","kevin.alca@gmail.com","93493493","TravesseraLesCorts");




        }
    }

    /* añadimos  un caso*/
    @PUT
    @ApiOperation(value = "update a Caso", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Caso not found")
    })
    @Path("/")
    public Response addCaso(Caso caso) {

        Caso c = this.cm.addCaso(caso);

        if (c == null) return Response.status(404).build();

        return Response.status(201).build();
    }


    @GET
    @ApiOperation(value = "get a ListaOrdenada", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Caso.class, responseContainer = "List"),
            @ApiResponse(code = 404, message = "fecha No Encontrada")
    })
    @Path("/{id}") //Le pasamos el ID del brote
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListaOrdenada(@PathParam("id") String id) {
        List<Caso> casos = this.cm.ordersByClasificacion(id);
        if (casos == null) return Response.status(404).build();
        else  return Response.status(201).entity(casos).build();
    }






}
