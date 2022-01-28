package ibm.gse.voyagems.domain;

import ibm.gse.voyagems.domain.model.Voyage;
import ibm.gse.voyagems.infra.repo.VoyageRepositoryMem;
import ibm.gse.voyagems.infra.repo.history.VoyageHistoryRepositoryMem;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class VoyageServiceProxy {

    @Inject
    VoyageHistoryRepositoryMem voyageHistoryRepositoryMem;

    @Inject
    VoyageRepositoryMem voyageRepositoryMem;


    public List<Voyage> getAll() {
        return voyageRepositoryMem.getAll();
    }

    public Voyage findById(String key) {
        return voyageRepositoryMem.findById(key);
    }

    public Voyage add(Voyage voyage) {
        Voyage createdVyage = voyageRepositoryMem.add(voyage);
        Voyage newVoyage = new Voyage(createdVyage);
        voyageHistoryRepositoryMem.add(newVoyage);
        return newVoyage;
    }

    public Voyage update(Voyage voyage) {
        Voyage updatedVoyage = voyageRepositoryMem.update(voyage);
        voyageHistoryRepositoryMem.update(updatedVoyage);
        return updatedVoyage;

    }

    public Voyage removeOrderId(String orderId) {

        Voyage updatedVoyage = voyageRepositoryMem.removeOrderId(orderId);
        voyageHistoryRepositoryMem.update(updatedVoyage);
        return updatedVoyage;
    }

    public List<Voyage> getVoyageHistory(String voyageId) {
        return voyageHistoryRepositoryMem.getHistory(voyageId);
    }
}
