package br.com.ies.backend.manager;

import java.util.ArrayList;
import java.util.List;

import br.com.ies.backend.persistence.FilePersistance;
import br.com.ies.backend.persistence.PostgresPersistance;
import br.com.ies.backend.persistence.base.IPersistance;

public class PersistanceManager {

	private List<IPersistance> persistanceList;
	
	public PersistanceManager() {
		this.persistanceList = new ArrayList<>();
		
		addDefaultPersistances();
	}
	
	public List<IPersistance> getPersistanceList() {
		return persistanceList;
	}


	private void addDefaultPersistances() {
		persistanceList.add(new FilePersistance());
		persistanceList.add(new PostgresPersistance());
	}
	
}
