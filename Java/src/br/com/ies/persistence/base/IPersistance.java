package br.com.ies.persistence.base;

import br.com.ies.dto.PersistanceParameterDTO;
import br.com.ies.dto.PersistanceDTO;
import br.com.ies.util.Callback;

public interface IPersistance {


	public String getName();
	public void setName(String name);
	
	public abstract void persist(PersistanceDTO queryDTO);
	
	public abstract <T> void select(PersistanceParameterDTO<T> select, Callback callback);
	
}
