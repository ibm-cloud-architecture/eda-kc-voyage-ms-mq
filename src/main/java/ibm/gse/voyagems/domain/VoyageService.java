package ibm.gse.voyagems.domain;

import ibm.gse.voyagems.domain.model.Voyage;
import ibm.gse.voyagems.infra.repo.VoyageRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;


@ApplicationScoped
public class VoyageService {

    @Inject
    public VoyageRepository repository;

    public List<Voyage> getAllVoyages() {
        return repository.getAll();
    }
    
}
