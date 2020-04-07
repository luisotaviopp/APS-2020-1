package br.com.ies.persistence.base;

import br.com.ies.dto.QueryDTO;

public interface IPersistance {


	public String getName();
	public void setName(String name);
	
	public abstract void persist(QueryDTO queryDTO);
	
	public abstract Object select(Integer primaryKeyId, Object fromObject);
	
}
