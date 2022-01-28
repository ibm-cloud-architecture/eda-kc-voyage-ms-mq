package ibm.gse.voyagems.infra.api;

import ibm.gse.voyagems.domain.VoyageServiceProxy;
import ibm.gse.voyagems.domain.model.Voyage;
import io.smallrye.mutiny.Multi;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/voyages/history")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class VoyageHistoryResource {
    
    @Inject
    public VoyageServiceProxy service;

    @GET
    public Multi<Voyage> getVoyageHistory(@QueryParam String voyageId) {
        List<Voyage> l = service.getVoyageHistory(voyageId);
        return Multi.createFrom().items(l.stream());
    }
}
