package ibm.gse.voyagems.infra.api;

import ibm.gse.voyagems.domain.VoyageServiceProxy;
import ibm.gse.voyagems.domain.model.Voyage;
import io.smallrye.mutiny.Multi;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/voyages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class VoyageResource {
    
    @Inject
    public VoyageServiceProxy service;

    @GET
    public Multi<Voyage> getAllActiveVoyages() {
        List<Voyage> l = service.getAll();
        return Multi.createFrom().items(l.stream());
    }
}
