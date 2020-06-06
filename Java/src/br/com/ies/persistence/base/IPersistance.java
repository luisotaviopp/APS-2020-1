package br.com.ies.persistence.base;

import br.com.ies.dto.QueryDTO;
import br.com.ies.util.Callback;

public interface IPersistance {


	public String getName();
	public void setName(String name);
	
	public abstract void persist(QueryDTO queryDTO);
	
	public abstract void select(String select, Callback callback);
	
}
