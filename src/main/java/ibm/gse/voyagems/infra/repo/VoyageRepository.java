package ibm.gse.voyagems.infra.repo;

import ibm.gse.voyagems.domain.model.Voyage;

import java.util.List;

public interface VoyageRepository {

    public List<Voyage> getAll();
    public Voyage findById(String key);
}