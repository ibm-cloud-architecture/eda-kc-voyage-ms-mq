package ibm.gse.voyagems.infra.repo.history;

import ibm.gse.voyagems.domain.model.Voyage;

import java.util.List;

public interface VoyageHistoryRepository {

    List<Voyage> getHistory(String key);
    void add(Voyage voyage);
    void update(Voyage voyage);

}