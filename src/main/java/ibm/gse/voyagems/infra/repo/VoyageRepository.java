package ibm.gse.voyagems.infra.repo;

import ibm.gse.voyagems.domain.model.Voyage;

import java.util.List;

public interface VoyageRepository {

    List<Voyage> getAll();
    Voyage findById(String key);
    Voyage add(Voyage voyage);
    Voyage update(Voyage voyage);
    Voyage removeOrderId(String orderId);
}