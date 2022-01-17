package ibm.gse.voyagems.domain.model.voyage;


import ibm.gse.voyagems.domain.model.EventBase;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class VoyageAssignedEvent extends EventBase {

  
	VoyageAssignmentPayload payload;
	
    public VoyageAssignedEvent(long timestampMillis, String version, VoyageAssignmentPayload payload) {
    	this.timestampMillis = timestampMillis;
    	this.version = version;
    	this.type = EventBase.TYPE_VOYAGE_ASSIGNED;
    	this.payload = payload;
    }

    public VoyageAssignedEvent() {
    }

	public VoyageAssignmentPayload getPayload() {
		return payload;
	}

    

}
