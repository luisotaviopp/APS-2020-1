package br.com.ies.backend.persistence.base;

import br.com.ies.backend.dto.PersistanceDTO;
import br.com.ies.backend.dto.PersistanceParameterDTO;
import br.com.ies.backend.util.Callback;

public interface IPersistance {


	public String getName();
	public void setName(String name);
	
	public abstract void persist(PersistanceDTO queryDTO);
	
	public abstract <T> void select(PersistanceParameterDTO<T> select, Callback callback);
	
}
