package ibm.gse.voyagems.infra.repo;

import java.util.List;

import ibm.gse.voyagems.domain.model.Voyage;

public interface VoyageRepository {

    public List<Voyage> getAll();
    public Voyage findById(String key);
}