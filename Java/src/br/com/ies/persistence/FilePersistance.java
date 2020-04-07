package br.com.ies.persistence;

import br.com.ies.dto.QueryDTO;
import br.com.ies.persistence.impl.PersistanceImpl;

public class FilePersistance extends PersistanceImpl{

	private final String PERSISTANCE_NAME = new String("Arquivo");
	
	public FilePersistance() {
		super.setName(PERSISTANCE_NAME);
	}
	
	@Override
	public void persist(QueryDTO queryDTO) {
	}

	@Override
	public Object select(Integer primaryKeyId, Object fromObject) {
		return null;
	}
}
