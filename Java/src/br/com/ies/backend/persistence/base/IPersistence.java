package br.com.ies.backend.persistence.base;

import br.com.ies.backend.dto.PersistenceDTO;
import br.com.ies.backend.dto.PersistenceParameterDTO;
import br.com.ies.backend.util.lib.Callback;

public interface IPersistence {


	public String getName();
	public void setName(String name);
	
	public abstract void persist(PersistenceDTO queryDTO);
	
	public abstract <T> void select(PersistenceParameterDTO<T> select, Callback callback);
	
}
