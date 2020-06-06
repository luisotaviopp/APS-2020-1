package br.com.ies.manager;

import java.util.ArrayList;
import java.util.List;

import br.com.ies.persistence.FilePersistance;
import br.com.ies.persistence.PostgresPersistance;
import br.com.ies.persistence.base.IPersistance;

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
