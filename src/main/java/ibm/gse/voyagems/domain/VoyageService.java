package ibm.gse.voyagems.domain;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import ibm.gse.voyagems.domain.model.Voyage;
import ibm.gse.voyagems.infra.repo.VoyageRepository;


@ApplicationScoped
public class VoyageService {

    @Inject
    public VoyageRepository repository;

    public List<Voyage> getAllVoyages() {
        return repository.getAll();
    }
    
}
