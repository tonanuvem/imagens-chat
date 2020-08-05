package imagens;

/*
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fruits")
public class FruitResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
}
*/


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/imagens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ControllerResource {

    @Inject
    SyncService service;

    @GET
    public List<Imagem> getAll() {
        return service.findAll();
    }

    @GET
    @Path("{name}")
    public Imagem getSingle(@PathParam("name") String name) {
        return service.get(name);
    }

    @POST
    public List<Imagem> add(Imagem img) {
        service.add(img);
        return getAll();
    }
    
    @DELETE
    public List<Imagem> delete(Imagem img) {
        service.delete(img);
        return getAll();
    }
}