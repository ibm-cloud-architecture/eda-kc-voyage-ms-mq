package ibm.gse.voyagems.infra.api;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ibm.gse.voyagems.domain.VoyageService;
import ibm.gse.voyagems.domain.model.Voyage;
import io.smallrye.mutiny.Multi;

@Path("/api/v1/voyages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class VoyageResource {
    
    @Inject
    public VoyageService service;

    @GET
    public Multi<Voyage> getAllActiveVoyages() {
        List<Voyage> l = service.getAllVoyages();
        return Multi.createFrom().items(l.stream());
    }
}
