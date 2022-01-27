package ibm.gse.voyagems.infra.repo;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;

import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.gse.voyagems.domain.model.Voyage;

@Singleton
public class VoyageRepositoryMem implements VoyageRepository {
    private static ConcurrentHashMap<String,Voyage> repo = new ConcurrentHashMap<String,Voyage>();
    private static ObjectMapper mapper = new ObjectMapper();

    public VoyageRepositoryMem(){
        InputStream is = getClass().getClassLoader().getResourceAsStream("voyages.json");
        if (is == null) 
            throw new IllegalAccessError("file not found for voyages json");
        try {
            List<Voyage> currentDefinitions = mapper.readValue(is, mapper.getTypeFactory().constructCollectionType(List.class, Voyage.class));
            currentDefinitions.stream().forEach( (t) -> repo.put(t.voyageID,t));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repo.values().stream().forEach(v -> System.out.println(v.voyageID));
    }

    @Override
    public List<Voyage> getAll() {
        return new ArrayList<Voyage>(repo.values());
    }
    
    @Override
    public Voyage findById(String key) {
        return repo.get(key);
    }
}
