package br.com.ies.persistence;

import br.com.ies.dto.QueryDTO;
import br.com.ies.persistence.impl.PersistanceImpl;
import br.com.ies.util.Callback;

public class FilePersistance extends PersistanceImpl{

	private final String PERSISTANCE_NAME = new String("Arquivo");
	
	public FilePersistance() {
		super.setName(PERSISTANCE_NAME);
	}
	
	@Override
	public void persist(QueryDTO queryDTO) {
	}

	public void select(String sql, Callback callback) {
	}
}
