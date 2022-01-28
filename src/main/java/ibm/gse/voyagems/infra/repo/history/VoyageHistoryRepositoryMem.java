package ibm.gse.voyagems.infra.repo.history;

import com.fasterxml.jackson.databind.ObjectMapper;
import ibm.gse.voyagems.domain.model.Voyage;

import javax.inject.Singleton;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class VoyageHistoryRepositoryMem implements VoyageHistoryRepository{

    private static ConcurrentHashMap<String,List<Voyage>> repo = new ConcurrentHashMap<>();
    private static ObjectMapper mapper = new ObjectMapper();

    public VoyageHistoryRepositoryMem() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("voyages.json");
        if (is == null)
            throw new IllegalAccessError("file not found for voyages json");
        try {
            List<Voyage> currentDefinitions = mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, Voyage.class));
            currentDefinitions.stream().forEach( (t) -> repo.put(t.voyageID, new ArrayList<>(List.of(t))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repo.values().stream().forEach(v -> System.out.println(v.toString()));
    }

    @Override
    public List<Voyage> getHistory(String key) {
        return repo.get(key);
    }

    @Override
    public void add(Voyage voyage) {
        String key = voyage.voyageID;
        List<Voyage> firstHistoryElem = new ArrayList<>(List.of(voyage));
        repo.put(key, firstHistoryElem);

    }

    @Override
    public void update(Voyage voyage) {
        String key = voyage.voyageID;
        List<Voyage> history = repo.remove(key);
        history.add(voyage);
        repo.put(key, history);
    }
}
