package br.com.ies.backend.manager;

import java.util.ArrayList;
import java.util.List;

import br.com.ies.backend.persistence.FilePersistence;
import br.com.ies.backend.persistence.PostgresPersistence;
import br.com.ies.backend.persistence.base.IPersistence;

public class PersistenceManager {

	private List<IPersistence> persistenceList;

	public PersistenceManager() {
		this.persistenceList = new ArrayList<>();

		addDefaultPersistences();
	}

	public List<IPersistence> getPersistenceList() {
		return persistenceList;
	}

	private void addDefaultPersistences() {
		persistenceList.add(new FilePersistence());
		persistenceList.add(new PostgresPersistence());
	}

	public IPersistence getPersistance(PersistenceType persistenceType) {
		return persistenceType == PersistenceType.FILE ? persistenceList.get(0) : persistenceList.get(1);
	}

	static enum PersistenceType {
		POSTGRES, FILE;
	}
}
